/**
 * APPLICATION WRITTEN AND DESIGNED BY ANGELO BARCELONA 20230923.  APPLICATION IS USED
 * FOR USAF RECRUITING SCHOOL ADMIN PURPOSES.  APPLICATION WRITTEN IN JAVA USING JAVAFX LIBRARY
 * FOR A MODERN LOOK, STYLING IS DONE THROUGH CSS.  APPLICATION IS A MAVEN PROJECT, AND DEPENDENCIES
 * ARE LOCATED IN THE POM.  THIS IS A MODULE PROJECT ALL REQUIRED MODULES ARE LOCATED IN THE 
 * MODULE-INFO.JAVA.
 */

package application;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

import application.components.NavigationBar;
import application.components.StudentViewBox;
import application.io.PDFReader;
import application.views.ClassAdmin;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

	// Declaration for initial window set up variables
	private String style = App.class.getResource("application.css").toExternalForm();
	private Stage window;
	private Group root;
	private BorderPane background;
	private Scene scene;

	// Height and Width of the scene. based on primary screen visual bounds.
	private double width;
	private double height;

	// insets for element spacing for BorderPane
	private Insets insets;

	// Navigation bar declaration
	private NavigationBar navBar;

	// Student View Box declaration
	private StudentViewBox studentViewBox;

	// Title for application version control based on CHANGELOG.txt.
	private final String TITLE = "LazyTron6000 v0.02";

	// Declares class admin view this view is to bet set to the center node.
	private ClassAdmin classAdminView;

	private String roster;

	// Declares home string that stores the path for the roster
	private String home;

	// Declares an array list to house students
	private ArrayList<Student> studentList;

	// Declares a list view for students for the studentViewBox
	private ListView<Student> listView;

	@Override
	public void start(Stage stage) {

		// INSTANTIATE THE ARRAYLIST FOR STUDENTS
		setStudentList(new ArrayList<Student>());

		// INSTANTIATE THE LISTVIEW FOR STUDENTS
		listView = new ListView<Student>();
		listView.setId("studentlistview");

		// INSTANTIATES THE HOME VARIABLE
		home = System.getProperty("user.home") + File.separator + "classroster" + File.separator + "roster.txt";

		// WIDTH AND HEIGHT OF THE APPLICATION SET BY PRIMARY SCREEN RATIO 1.4W, 1.3H
		width = Screen.getPrimary().getVisualBounds().getWidth() / 1.4;
		height = Screen.getPrimary().getVisualBounds().getHeight() / 1.3;

		// Insets used for borderPane spacing
		insets = new Insets(25);

		// Background pane for main view all views are to be layered on top of this view
		background = new BorderPane();
		background.setId("background");
		background.setPrefSize(width, height);

		// root node for the scene
		root = new Group();
		root.getChildren().add(background);

		// Scene used for window stage, utilizes style sheet: style.
		scene = new Scene(root, width, height);
		scene.getStylesheets().add(style);

		// Sets window settings for scene, sizable, title and allows windows to show the
		// stage.
		window = stage;
		window.setScene(scene);
		window.setResizable(false);
		window.setTitle(TITLE);
		window.sizeToScene();
		window.show();

		// Navigation bar instantiation, Navigation bar is used in all views
		navBar = new NavigationBar();

		// Navigation Bar Button Actions
		navBarButtonActions();

		// Sets top of BPane as Navigation Bar
		BorderPane.setAlignment(navBar, Pos.CENTER);
		background.setTop(navBar);

		// Outer shell for student view box. used for styling width and height of left
		// bpane
		Pane leftShellPane = new Pane();
		leftShellPane.setId("leftshellpane");

		// sets left of BPane as Student View Box
		studentViewBox = new StudentViewBox();
		leftShellPane.getChildren().add(studentViewBox);
		BorderPane.setAlignment(leftShellPane, Pos.CENTER_LEFT);
		background.setLeft(leftShellPane);
		studentViewBox.setTranslateX(50);

		// sets center of BPane as Class Admin View to start, until other views are
		// selected.
		classAdminView = new ClassAdmin();
		BorderPane.setAlignment(classAdminView, Pos.CENTER_LEFT);
		BorderPane.setMargin(classAdminView, insets);
		background.setCenter(classAdminView);

		// BUTTON ACTION METHODS
		classAdminActionButtons();

		// NAVBAR ACTION METHODS
		navBarButtonActions();

		//LOADS STUDENTS TO THE LIST VIEW
		loadStudentsToListView();

	}//END START
	
	// CHECKS TO SEE IF THE ROSTER IS AVAILABLE IF SO WILL LOAD STUDENTS
	private void loadStudentsToListView() {
		
		try {

			boolean isRoster = checkIsRosterAvailable();

			if (createStudents(isRoster)) {

				ObservableList<Student> list = FXCollections.observableArrayList(studentList);

				if(listView.getItems().isEmpty()) {
					
					listView.setItems(list);
					
				}else {
					
					listView.getItems().clear();
					listView.setItems(list);
					
				}

				if (studentViewBox != null && !studentViewBox.getChildren().contains(listView)) {
					
					studentViewBox.getChildren().clear();
					studentViewBox.getChildren().add(listView);

				}

			}

		} catch (IOException e) {

			e.printStackTrace();
		}
		
	}

	/**
	 * Actions for the navigation bar
	 */
	private void navBarButtonActions() {

		// CLOSES THE APPLICATION
		navBar.getExitButton().setOnAction(e -> {

			Platform.exit();

		});

	}

	private void classAdminActionButtons() {

		classAdminView.getUploadClassButton().setOnAction(e -> {
			PDFReader reader = new PDFReader();
			try {

				// TEMP STRING TO TEST IF THE PDF SELECTED IS A ROSTER
				String testFileIsRoster = "";

				// ONCE READER HAS THE FILE IT WILL PASS THE STRING TO CLASSTEXT
				String classText = reader.gettFile(window);

				// IF CLASSTEXT IS NULL (NO FILE SELECTED) THE METHOD WILL RETURN
				if (classText == null) {
					return;
				}

				// GRABS THE LENGTH OF THE TEXT, IF GREATER THAN 9 THEN TESTFILEISROSTER IS SET
				if (classText.length() > 9) {

					testFileIsRoster = classText.substring(0, 8);

				}

				// IF TESTFILEISROSTER IS EQUAL TO PREPARED THEN THE SELECTED FILE IS A ROSTER
				if (!testFileIsRoster.equals("PREPARED")) {

					Alert a1 = new Alert(AlertType.ERROR);
					a1.initOwner(window);
					a1.initModality(Modality.WINDOW_MODAL);
					a1.setContentText("The File Selected is not a Roster");
					a1.show();

				}

				// IF THE TEST STRING EQUALS ROSTER SETS THE ROSTER STRING TO CLASSTEXT
				if (testFileIsRoster.equals("PREPARED")) {

					roster = classText;

					writeRoster(roster);
					
					loadStudentsToListView();


				}
			} catch (IOException | URISyntaxException f) {
				f.printStackTrace();
			}
		});

	}

	/**
	 * Takes in the class roster. Checks to see if the user directory
	 * user.home.classroster.roster.txt exists if not it creates the directory, the
	 * file, and writes the roster to the file.
	 * 
	 * @param roster
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public void writeRoster(String roster) throws IOException, URISyntaxException {

		// CREATES THE HOME PATH
		Path path = Paths.get(home);

		// CHECKS IF THE PARENT FOLDER USER.HOME.CLASSROSTER EXISTS IF NOT CREATE IT
		if (!Files.exists(path.getParent())) {

			Files.createDirectories(path.getParent());

		}

		// CHECKS IF THE CLASSROSTER.TXT EXISTS IF NOT CREATE IT
		if (!Files.exists(path)) {

			Files.createFile(path);

		}

		// WRITES THE ROSTER FROM FILECHOOSER TO THE CLASSROSTER.TXT
		Files.write(path, roster.getBytes(), StandardOpenOption.WRITE);

	}

	/**
	 * Checks to see if the classroster directory exists, and roster.txt file if so
	 * it will return true.
	 * 
	 * @throws IOException
	 */
	public boolean checkIsRosterAvailable() throws IOException {
		// CREATES THE HOME PATH
		Path path = Paths.get(home);

		// CHECKS IF THE PARENT FOLDER USER.HOME.CLASSROSTER EXISTS IF NOT CREATE IT
		if (!Files.exists(path.getParent())) {

			Files.createDirectories(path.getParent());

		}

		// CHECKS IF THE CLASSROSTER.TXT EXISTS IF NOT CREATE IT
		if (!Files.exists(path)) {

			Files.createFile(path);

			return false;

		} else {

			String tmpRost = Files.readString(path);

			if (tmpRost.length() > 9) {

				tmpRost = tmpRost.substring(0, 8);

				if (tmpRost.equals("PREPARED")) {

					return true;

				}

			}

		}

		return false;

	}

	/**
	 * Takes in the boolean isRoster. If true creates Students
	 * 
	 * @param isRoster
	 * @throws IOException
	 */
	public boolean createStudents(boolean isRoster) throws IOException {

		if (!isRoster) {

			return false;

		}

		// CREATES PATH FOR HOME
		Path path = Paths.get(home);

		// CONVERTS THE STRING RETURN FROM FILES.READSTRING TO A STRING ARRAY FOR
		// PROCESSING
		String[] rosterLines = Files.readString(path).split("\n");

		// A TEMPARORY STRING ARRAY WITH A DELIMITER OF (" ")
		String[] temp = rosterLines[4].split(" ");

		// TEMP VARIABLES FOR STUDENT CREATION
		String startDate = temp[3];
		String gradDate = temp[7];
		String lastName = "";
		String firstName = "";
		String middle = "";
		String rank = "";

		// ITERATES OF THE TEXT FILE ROSTER STARTING AT INDEX FOR STUDENTS
		for (int i = 8; i < rosterLines.length; i++) {

			temp = rosterLines[i].split(" ");

			lastName = temp[0].substring(0, temp[0].length() - 1);

			firstName = temp[1];

			middle = temp[2];

			char[] middleArray = middle.toCharArray();

			int index = 0;

			// Iterates of the middle name to determine if it has numbers. If so substring
			for (char c : middleArray) {

				if (Character.isDigit(c)) {

					middle = middle.substring(0, index);
					break;

				}

				index++;
			}

			// IF THE THIRD INDEX OF TEMP IS NOT A NUMBER IT IS CONCATENATED TO MIDDLE NAME
			if (!isNumber(temp[3])) {

				middle += " " + temp[3];

			}

			// ITERATES OF THE CURRENT TEMP LINE, IF THE STRING == 34,35,36,37 WILL RETURN
			// RANK
			for (String s : temp) {
				if (s.equals("34") || s.equals("35") || s.equals("36") || s.equals("37")) {
					rank = determineRank(s);
				}
			}
			
			//CHECKS TO SEE IF THE STUDENT ARLEADY EXISTS IN THE LIST.  IF SO IT WILL NOT DUPLICATE.
			Student student = new Student(rank, firstName, lastName, middle, startDate, gradDate);
			
			if(!studentList.contains(student)) {
				
				studentList.add(student);
				
			}

			
		} // END FOR

		return true;

	}

	/**
	 * Takes in a numerical String representation of rank, and converts it to a rank
	 * 
	 * @param rank
	 * @return String
	 */
	public String determineRank(String rank) {

		String tmp = "";

		switch (rank) {

		case "34":
			tmp = "SrA";
			break;
		case "35":
			tmp = "SSgt";
			break;
		case "36":
			tmp = "TSgt";
			break;
		case "37":
			tmp = "MSgt";
			break;
		default:
			tmp = "uknown";
			break;

		}

		return tmp;

	}

	/**
	 * Takes in a string and attempts to parse it to int. If the line can not be
	 * parsed then the String is not a number; and will be concatenated to the
	 * middle name.
	 * 
	 * @param line
	 * @return boolean
	 */
	public boolean isNumber(String line) {

		try {

			Integer.parseInt(line);
			return true;

		} catch (Exception e) {

			return false;

		}

	}

	/**
	 * @return the studentList
	 */
	public ArrayList<Student> getStudentList() {
		return studentList;
	}

	/**
	 * @param studentList the studentList to set
	 */
	public void setStudentList(ArrayList<Student> studentList) {
		this.studentList = studentList;
	}

	public static void main(String[] args) {
		launch();
	}

}