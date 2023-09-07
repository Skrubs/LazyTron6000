package application.components;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class NavigationBar extends Pane{
	
	//BUTTONS FOR THE NAVIGATION BAR
	private Button classAdminButton;
	private Button printCertsButton;
	private Button labsButton;
	private Button exitButton;
	
	//HBOX TO HOLD THE BUTTONS IN A HORIZONTAL POSITION RELATIVE TO EACH OTHER
	private HBox buttonBox;
	
	
	public NavigationBar() {
		initialization();
	}
	
	
	private void initialization() {
		
		classAdminButton = new Button("Class Admin");
		classAdminButton.setId("navButton");
		
		printCertsButton = new Button("Print Certificates");
		printCertsButton.setId("navButton");
		
		labsButton = new Button("Labs");
		labsButton.setId("navButton");
		
		exitButton = new Button("Exit");
		exitButton.setId("navButton");
		
		buttonBox = new HBox();
		buttonBox.setId("navButtonBox");
		
	}

}
