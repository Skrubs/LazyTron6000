package application.views;

import java.util.ArrayList;
import java.util.Arrays;

import application.Student;
import application.io.CertPrinter;
import certificates.ABCCert;
import certificates.DGCert;
import certificates.GradCert;
import certificates.ImpactCert;
import certificates.SalesCert;
import certificates.TGCert;
import certificates.TorresCert;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;


/**
 * PRINTCERTVIEW CLASS IS A CLASS THAT REPRESENTS A VISUAL REPRESENTATION OF
 * SELECTING AND PRINTING CERTIFICATES FOR AWARDS AND GRADUATION
 */
public class PrintCertView extends Pane {

	private CertPrinter job = new CertPrinter();

	private VBox vBox_1;
	private HBox hBox_1;
	private HBox hBox_2;
	private HBox hBox_3;

	// CERTIFICATES
	GradCert gradCert = new GradCert();
	ImpactCert impactCert = new ImpactCert();
	TGCert tgCert = new TGCert();
	DGCert dgCert = new DGCert();
	SalesCert salesCert = new SalesCert();
	TorresCert salvCert = new TorresCert();
	ABCCert abcCert = new ABCCert();

	// BUTTONS FOR PRINTING OPTIONS. YOU CAN EITHER PRINTALL FOR GRAD ADN IMPACT
	// OR YOU CAN PRINT SELECTED FOR ANY CERTIFICATE
	private Button printAll;
	private Button printSelected;

	// VBOX FOR BUTTONS
	private VBox printVBox;

	// selectionmodel arraylist
	private ArrayList<Pane> selectionModel;

	// List of Certificates for easy access
	private ArrayList<Pane> certList;

	private ArrayList<Student> studentList = new ArrayList<>();

	/**
	 * BASIC CONSTRUCTOR
	 */
	public PrintCertView() {

		super();
		this.setId("printcertview");
		initialize();
		initializeButtonBox();
		buttonAction();
	}

	/**
	 * Initializes printcertbox variables
	 */
	private void initialize() {

		// INITIALIZES VIEW CONTAINERS
		vBox_1 = new VBox();
		vBox_1.setId("vBox_1");
		vBox_1.setMinSize(600, 500);
		vBox_1.setPrefSize(800, 600);

		hBox_1 = new HBox();
		hBox_1.setId("hBox_1");

		hBox_2 = new HBox();
		hBox_2.setId("hBox_1");

		hBox_3 = new HBox();
		hBox_3.setId("hBox_1");

		// ArrayLists that contain the Panes for the imageviews
		// The selectionModel is used to determine if Pane == selected
		certList = new ArrayList<>();
		selectionModel = new ArrayList<>();

		// ADDS CERTIFICATES TO THEIR RESPECTIVE H_BOX FOR LAYOUT
		// HBOX IS THEN ADDED TO A VBOX FOR ADDITIONAL LAYOUT CONTROL
		hBox_1.getChildren().addAll(gradCert, impactCert, salesCert);
		hBox_2.getChildren().addAll(tgCert, dgCert, salvCert);
		hBox_3.getChildren().add(abcCert);

		// VBOX ADDS ALL IMAGEVIEW CONTAINERS
		vBox_1.getChildren().addAll(hBox_1, hBox_2, hBox_3);

		// THIS PANE ADDS VBOX CONTAINER
		this.getChildren().add(vBox_1);

		// ARRAYLIST CONTAINERS ADDS ALL IMAGEVIEW CONTAINERS TO LIST
		certList.addAll(Arrays.asList(gradCert, impactCert, salesCert, tgCert, dgCert, salvCert, abcCert));

		// GOES THROUGH ALL PANES IN THE CONTAINRES LIST
		for (Pane p : certList) {

			// SETS TEH ON MOUSE CLICKED FOR EACH IMAGEVIEW CONTAINER
			p.setOnMouseClicked(e -> {

				// ACTIVATES THE SELECTIONMODEL FIRST THE MODEL IS CLEARED THEN
				// THE CLICKED IMAGEVIEW CONTAINER IS ADDED TO THE SELECTIONMODEL
				selectionModel.clear();
				selectionModel.add(p);
				p.setId("previewContainer_selected");

				certList.forEach(pane -> {

					if (!selectionModel.contains(pane)) {

						if (pane.getId() != "previewContainer") {

							pane.setId("previewContainer");

						}

					}

				});

			});

		}

	}

	// GETS STUDENTLIST FROM APP
	public void getStudentList(ArrayList<Student> studentList) {
		this.studentList = studentList;
	}

	// button actions
	private void buttonAction() {

		
		/**
		 * PRINTALL ACTION: THIS LAMDA WILL ONLY WORK WITH GRAD CERT AND
		 * IMPACT CERT.  FOR INDIVIDUAL AWARDS WE WILL BE USING PRINTSELECTED
		 */
		printAll.setOnAction(e -> {

			// CHECKS THE CURRENT SELECTIONMODEL IS SET TO GRAD OR IMPACT
			if (!selectionModel.contains(gradCert) && !selectionModel.contains(impactCert)) {

				Alert alert = new Alert(AlertType.WARNING);
				alert.setContentText("Graduation or Impact Certificate not selected");
				alert.show();
				return;

			}

			// CHECKS IF A CLASS HAS BEEN UPLOADED
			if (studentList.size() == 0) {

				return;

			}

			studentList.forEach(s -> {

				if (selectionModel.contains(gradCert)) {

					gradCert.getSnapShot(s);

				}

				if (selectionModel.contains(impactCert)) {

					impactCert.getSnapShot(s);

				}

			});

		});

	}

	// INSTANTIATES BUTTONS
	private void initializeButtonBox() {

		printVBox = new VBox();

		printVBox.setAlignment(Pos.CENTER);

		printVBox.setSpacing(25);

		printAll = new Button("Print All");

		printSelected = new Button("Print Selected");

		printVBox.getChildren().addAll(printAll, printSelected);

	}

	/**
	 * Returns VBox that holds the buttons printall and printselected in the
	 * printcertview
	 * 
	 * @return
	 */
	public VBox printButtonBox() {

		return printVBox;
	}

}
