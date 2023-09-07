package application;

import java.io.IOException;

import application.io.PDFReader;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {
	
	private String style = App.class.getResource("application.css").toExternalForm();
	private Stage window;
	private Group root;
	private Pane background;
	private Scene scene;
	
	private final String TITLE = "LazyTron6000 v0.01";

    @Override
    public void start(Stage stage) {
    	
    	root = new Group();
    	background = new Pane();
    	background.setId("background");
    	
    	root.getChildren().add(background);
    	scene = new Scene(root);
    	scene.getStylesheets().add(style);
    	window = stage;
    	background.setPrefSize(1280, 800);
    	window.setScene(scene);
    	window.setResizable(false);
    	window.setTitle(TITLE);
    	window.show();


    }
    
    
    public static void main(String[] args) {
        launch();
    }

}