package application.views;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class ClassAdmin extends VBox {

	private Button uploadClassButton;
	private Button removeStudentButton;
	private Button addStudentButton;
	private Button loadScoresButton;
	private Button showScoresButton;
	private Button unloadClassButton;

	/**
	 * default constructor
	 */
	public ClassAdmin() {

		super();
		this.setId("classadminview");
		initialize();
		addButtons();
	}

	/**
	 * initializes content for class admin view
	 */
	private void initialize() {

		uploadClassButton = new Button("Upload Class");
		unloadClassButton = new Button("Unload Class");
		removeStudentButton = new Button("Remove Student");
		addStudentButton = new Button("Add Student");
		loadScoresButton = new Button("Load Scores");
		showScoresButton = new Button("Show Scores");
		
	}
	
	/**
	 * adds the upload class, remove student, add student, loadscores and showscores buttons.
	 */
	private void addButtons() {
		
		this.getChildren().addAll(uploadClassButton, unloadClassButton, removeStudentButton,
								addStudentButton, loadScoresButton, showScoresButton);
		
	}

	//GETTERS FOR ALL CLASS ADMIN BUTTONS
	public Button getUploadClassButton() {
		return uploadClassButton;
	}

	public Button getRemoveStudentButton() {
		return removeStudentButton;
	}

	public Button getAddStudentButton() {
		return addStudentButton;
	}

	public Button getLoadScoresButton() {
		return loadScoresButton;
	}

	public Button getShowScoresButton() {
		return showScoresButton;
	}

	public Button getUnloadClassButton() {
		return unloadClassButton;
	}
	
	

}
