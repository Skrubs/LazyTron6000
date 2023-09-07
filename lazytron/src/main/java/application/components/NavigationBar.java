package application.components;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;

public class NavigationBar extends HBox{
	
	//BUTTONS FOR THE NAVIGATION BAR
	private Button classAdminButton;
	private Button printCertsButton;
	private Button labsButton;
	private Button exitButton;
	
	
	public NavigationBar() {
		super();
		this.setId("navButtonBox");
		initialization();
		addButtons();
	}
	
	/**
	 * Instantiates all navbar buttons
	 */
	private void initialization() {
		
		classAdminButton = new Button("Class Admin");
		classAdminButton.setId("navButton");
		
		printCertsButton = new Button("Print Certificates");
		printCertsButton.setId("navButton");
		
		labsButton = new Button("Labs");
		labsButton.setId("navButton");
		
		exitButton = new Button("Exit");
		exitButton.setId("navButton");
			
	}
	
	private void setNavSize() {
		
		
		
	}
	
	private void addButtons() {
		
		this.getChildren().addAll(classAdminButton, printCertsButton, labsButton, exitButton);
		
	}

	//button getters for classadmin, printcerts, labs, exit.
	
	public Button getClassAdminButton() {
		return classAdminButton;
	}

	public Button getPrintCertsButton() {
		return printCertsButton;
	}

	public Button getLabsButton() {
		return labsButton;
	}

	public Button getExitButton() {
		return exitButton;
	}
	
	
	
	

}
