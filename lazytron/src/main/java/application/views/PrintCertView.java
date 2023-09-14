package application.views;

import java.util.ArrayList;
import java.util.Arrays;

import application.io.ImageLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class PrintCertView extends Pane {
	
	
	private VBox vBox_1;
	private HBox hBox_1;
	private HBox hBox_2;
	private HBox hBox_3;
	
	private ImageView abcView;
	private ImageView dgView;
	private ImageView impactView;
	private ImageView salesView;
	private ImageView salvView;
	private ImageView tgView;
	private ImageView gradView;
	
	//BUTTONS FOR PRINTING OPTIONS.  YOU CAN EITHER PRINTALL FOR GRAD ADN IMPACT
	//OR YOU CAN PRINT SELECTED FOR ANY CERTIFICATE
	private Button printAll;
	private Button printSelected;
	
	//VBOX FOR BUTTONS
	private VBox printVBox;
	
	//FIT HEIGHT FOR IMAGEVIEWS
	private double fitHeightSize = 150;
		
	/**
	 * BASIC CONSTRUCTOR
	 */
	public PrintCertView() {
		
		super();
		this.setId("printcertview");
		initialize();
	}
	
	/**
	 * Initializes printcertbox variables
	 */
	private void initialize() {
		
		//INITIALIZES VIEW CONTAINERS
		vBox_1 = new VBox();
		vBox_1.setId("vBox_1");
		vBox_1.setMinSize(600,500);
		vBox_1.setPrefSize(800, 600);
		
		hBox_1 = new HBox();
		hBox_1.setId("hBox_1");
		
		hBox_2 = new HBox();
		hBox_2.setId("hBox_1");
		
		hBox_3 = new HBox();
		hBox_3.setId("hBox_1");
		
		//ArrayLists that contain the Panes for the imageviews
		//The selectionModel is used to determine if Pane == selected
		ArrayList<Pane> containers = new ArrayList<>();
		ArrayList<Pane> selectionModel = new ArrayList<>();
		
		//INITIALIZES IMAGEVIEWS
		abcView = new ImageView(ImageLoader.abcCert);
		abcView.setFitHeight(fitHeightSize);
		abcView.setPreserveRatio(true);
		Pane p1 = new Pane();
		p1.setId("previewContainer");
		p1.getChildren().add(abcView);		
		
		dgView = new ImageView(ImageLoader.dgCert);
		dgView.setFitHeight(fitHeightSize);
		dgView.setPreserveRatio(true);
		Pane p2 = new Pane();
		p2.setId("previewContainer");
		p2.getChildren().add(dgView);
		
		impactView = new ImageView(ImageLoader.impactCert);
		impactView.setFitHeight(fitHeightSize);
		impactView.setPreserveRatio(true);
		Pane p3 = new Pane();
		p3.setId("previewContainer");
		p3.getChildren().add(impactView);
		
		salesView = new ImageView(ImageLoader.salesCert);
		salesView.setFitHeight(fitHeightSize);
		salesView.setPreserveRatio(true);
		Pane p4 = new Pane();
		p4.setId("previewContainer");
		p4.getChildren().add(salesView);
		
		salvView = new ImageView(ImageLoader.salvCert);
		salvView.setFitHeight(fitHeightSize);
		salvView.setPreserveRatio(true);
		Pane p5 = new Pane();
		p5.setId("previewContainer");
		p5.getChildren().add(salvView);
		
		tgView = new ImageView(ImageLoader.tgCert);
		tgView.setFitHeight(fitHeightSize);
		tgView.setPreserveRatio(true);
		Pane p6 = new Pane();
		p6.setId("previewContainer");
		p6.getChildren().add(tgView);
		
		gradView = new ImageView(ImageLoader.gradCert);
		gradView.setFitHeight(fitHeightSize);
		gradView.setPreserveRatio(true);
		Pane p7 = new Pane();
		p7.setId("previewContainer");
		p7.getChildren().add(gradView);
		
		hBox_1.getChildren().addAll(p7, p3, p4);
		hBox_2.getChildren().addAll(p1, p6, p2);
		hBox_3.getChildren().add(p5);
		
		//VBOX ADDS ALL IMAGEVIEW CONTAINERS
		vBox_1.getChildren().addAll(hBox_1, hBox_2, hBox_3);
				
		//THIS PANE ADDS VBOX CONTAINER
		this.getChildren().add(vBox_1);
		
		//ARRAYLIST CONTAINERS ADDS ALL IMAGEVIEW CONTAINERS TO LIST
		containers.addAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7));
		
		
		//GOES THROUGH ALL PANES IN THE CONTAINRES LIST
		for(Pane p : containers) {
				
			//SETS TEH ON MOUSE CLICKED FOR EACH IMAGEVIEW CONTAINER
			p.setOnMouseClicked(e->{
				
				//ACTIVATES THE SELECTIONMODEL FIRST THE MODEL IS CLEARED THEN
				//THE CLICKED IMAGEVIEW CONTAINER IS ADDED TO THE SELECTIONMODEL
				selectionModel.clear();
				selectionModel.add(p);
				p.setId("previewContainer_selected");
				
				containers.forEach(pane ->{
					
					if(!selectionModel.contains(pane)) {
						
						if(pane.getId() != "previewContainer") {
							
							pane.setId("previewContainer");
							
						}
						
					}
					
				});
				
			});
			
		}
				
	}
	
	/**
	 * Returns VBox that holds the buttons printall and printselected in the 
	 * printcertview
	 * @return
	 */
	public VBox printButtonBox() {
		
		printVBox = new VBox();
		
		
		
		printVBox.setAlignment(Pos.CENTER);
		
		printVBox.setSpacing(25);
		
		printAll = new Button("Print All");
		
		printSelected = new Button("Print Selected");
		
		printVBox.getChildren().addAll(printAll, printSelected);
		
		
		return printVBox;
	}

	

}
