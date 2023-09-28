package certificates;

import application.Student;
import application.io.ImageLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ImpactCert extends Certificate {

	public ImpactCert() {
		super(new ImageView(ImageLoader.impactCert));
		
	}
	
	public ImageView getSnapShot(Student student) {
		
		ImageView iv = new ImageView(ImageLoader.impactCert);
				
		String studentLabelText = student.certString();
		
		Label label = new Label(studentLabelText);
		label.setId("nameLabel");
		label.setTranslateY(-90);
		
		Label gradDate = new Label(student.getGradDate());
		gradDate.setId("gradLabel");
		gradDate.setTranslateY(75);
		
		StackPane stack = new StackPane(iv, label, gradDate);
		Scene scene = new Scene(stack);
		scene.getStylesheets().add(this.getClass().getResource("/application/application.css").toExternalForm());
		
		SnapshotParameters snap = new SnapshotParameters();
		
		ImageView printIV = new ImageView(stack.snapshot(snap, null));
		Stage stage = new Stage();
		stage.setScene(new Scene(new Group(printIV)));
		stage.setResizable(false);
		stage.show();
		
		return printIV;
	}

}
