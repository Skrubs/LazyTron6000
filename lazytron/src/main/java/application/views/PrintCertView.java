package application.views;

import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class PrintCertView extends Pane {
	
	
	private VBox vBox_1;
	private HBox hBox_1;
	private HBox hBox_2;
	private HBox hBox_3;
	
	
	public PrintCertView() {
		
		super();
		this.setId("printcertview");
		initialize();
		addHBoxsToVBox();
	}
	
	/**
	 * Initializes printcertbox variables
	 */
	private void initialize() {
		
		vBox_1 = new VBox();
		hBox_1 = new HBox();
		hBox_2 = new HBox();
		hBox_3 = new HBox();
		
		
	}
	
	private void addHBoxsToVBox() {
		
		this.vBox_1.getChildren().addAll(hBox_1, hBox_2, hBox_3);
		
	}
	

}
