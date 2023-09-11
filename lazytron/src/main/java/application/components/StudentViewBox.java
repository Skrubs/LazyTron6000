package application.components;

import application.Student;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class StudentViewBox extends VBox {
	
	ListView<Student> list;
	
	/**
	 * Basic Constructor
	 */
	public StudentViewBox() {
		
		super();
		this.setId("studentviewbox");
		initialize();
		
	}
	
	/**
	 * Initialize studentviewbox components.
	 */
	private void initialize() {
		
		list = null;
		
	}
	
	/**
	 * Grabs a non empty listview to populate studentview box
	 * @param list
	 */
	public void populateList(ListView<Student> list) {
		
		if(list != null) {
			
			this.list = list;
			
		}
		
	}

}
