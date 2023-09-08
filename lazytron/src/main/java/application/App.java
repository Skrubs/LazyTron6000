/**
 * APPLICATION WRITTEN AND DESIGNED BY ANGELO BARCELONA 20230923.  APPLICATION IS USED
 * FOR USAF RECRUITING SCHOOL ADMIN PURPOSES.  APPLICATION WRITTEN IN JAVA USING JAVAFX LIBRARY
 * FOR A MODERN LOOK, STYLING IS DONE THROUGH CSS.  APPLICATION IS A MAVEN PROJECT, AND DEPENDENCIES
 * ARE LOCATED IN THE POM.  THIS IS A MODULE PROJECT ALL REQUIRED MODULES ARE LOCATED IN THE 
 * MODULE-INFO.JAVA.
 */

package application;


import application.components.NavigationBar;
import application.components.StudentViewBox;
import application.views.ClassAdmin;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {
	
	//Declaration for initial window set up variables
	private String style = App.class.getResource("application.css").toExternalForm();
	private Stage window;
	private Group root;
	private BorderPane background;
	private Scene scene;
	
	//Height and Width of the scene.  based on primary screen visual bounds.
	private double width;
	private double height;
	
	//insets for element spacing for BorderPane
	private Insets insets;
	
		
	//Navigation bar declaration 
	private NavigationBar navBar;
	
	//Student View Box declaration
	private StudentViewBox studentViewBox;
	
	//Title for application version control based on CHANGELOG.txt.
	private final String TITLE = "LazyTron6000 v0.01";
	
	//Declares class admin view this view is to bet set to the center node.
	private ClassAdmin classAdminView;

    @Override
    public void start(Stage stage) {
    	
    	//WIDTH AND HEIGHT OF THE APPLICATION SET BY PRIMARY SCREEN RATIO 1.4W, 1.3H
    	width = Screen.getPrimary().getVisualBounds().getWidth() / 1.4;
    	height = Screen.getPrimary().getVisualBounds().getHeight() / 1.3;
    	
    	//Insets used for borderPane spacing
    	insets = new Insets(25);
    	
    	//Background pane for main view all views are to be layered on top of this view
    	background = new BorderPane();
    	background.setId("background");
    	background.setPrefSize(width, height);
    	
    	//root node for the scene
    	root = new Group();
    	root.getChildren().add(background);
    	
    	//Scene used for window stage, utilizes style sheet: style.
    	scene = new Scene(root, width, height);
    	scene.getStylesheets().add(style);
    	    	
    	//Sets window settings for scene, sizable, title and allows windows to show the stage.
    	window = stage;
    	window.setScene(scene);
    	window.setResizable(false);
    	window.setTitle(TITLE);
    	window.sizeToScene();
    	window.show();
    	
    	//Navigation bar instantiation, Navigation bar is used in all views
    	navBar = new NavigationBar();
    	
    	//Navigation Bar Button Actions
    	navBarButtonActions();
    	
    	//Sets top of BPane as Navigation Bar
    	BorderPane.setAlignment(navBar, Pos.CENTER);
    	background.setTop(navBar);
    	
    	//Outer shell for student view box. used for styling width and height of left bpane
    	Pane leftShellPane = new Pane();
    	leftShellPane.setId("leftshellpane");
    	
    	//sets left of BPane as Student View Box
    	studentViewBox = new StudentViewBox();
    	leftShellPane.getChildren().add(studentViewBox);
    	BorderPane.setAlignment(leftShellPane, Pos.CENTER_LEFT);
    	background.setLeft(leftShellPane);
    	studentViewBox.setTranslateX(50);
    	
    	//sets center of BPane as Class Admin View to start, until other views are selected.
    	classAdminView = new ClassAdmin();
    	BorderPane.setAlignment(classAdminView, Pos.CENTER_LEFT);
    	BorderPane.setMargin(classAdminView, insets);
    	background.setCenter(classAdminView);
    	
    

    }
    
    /**
     * Actions for the navigation bar
     */
    private void navBarButtonActions() {
    	
    	
    	
    }
    
    
    public static void main(String[] args) {
        launch();
    }

}