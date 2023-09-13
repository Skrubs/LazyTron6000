package application.views;

import application.io.ImageLoader;
import javafx.geometry.Insets;
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
	
	private double fitHeightSize = 150;
		
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
		
		vBox_1.getChildren().addAll(hBox_1, hBox_2, hBox_3);
				
		this.getChildren().add(vBox_1);
		
	}

	

}
