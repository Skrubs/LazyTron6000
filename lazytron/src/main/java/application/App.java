/**
 * APPLICATION WRITTEN AND DESIGNED BY ANGELO BARCELONA 20230923.  APPLICATION IS USED
 * FOR USAF RECRUITING SCHOOL ADMIN PURPOSES.  APPLICATION WRITTEN IN JAVA USING JAVAFX LIBRARY
 * FOR A MODERN LOOK, STYLING IS DONE THROUGH CSS.  APPLICATION IS A MAVEN PROJECT, AND DEPENDENCIES
 * ARE LOCATED IN THE POM.  THIS IS A MODULE PROJECT ALL REQUIRED MODULES ARE LOCATED IN THE 
 * MODULE-INFO.JAVA.
 */

package application;

import application.components.NavigationBar;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
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
	
	private double width;
	private double height;
	
		
	//Navigation bar declaration 
	private NavigationBar navBar;
	
	//Title for application version control based on CHANGELOG.txt.
	private final String TITLE = "LazyTron6000 v0.01";

    @Override
    public void start(Stage stage) {
    	
    	//WIDTH AND HEIGHT OF THE APPLICATION SET BY PRIMARY SCREEN RATIO 1.4W, 1.3H
    	width = Screen.getPrimary().getVisualBounds().getWidth() / 1.4;
    	height = Screen.getPrimary().getVisualBounds().getHeight() / 1.3;
    	
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
    	background.setTop(navBar);
    

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