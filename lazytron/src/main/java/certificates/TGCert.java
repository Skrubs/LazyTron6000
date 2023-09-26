package certificates;

import application.Student;
import application.io.ImageLoader;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class TGCert extends Certificate {

	public TGCert() {
		super(new ImageView(ImageLoader.tgCert));
		
	}
	
	public ImageView getSnapShot(Student student) {
		
		ImageView iv = new ImageView(ImageLoader.tgCert);
				
		String studentLabelText = student.certString();
		
		Label label = new Label(studentLabelText);
		label.setId("nameLabel");
		label.setTranslateY(-15);
		
		Label gradDate = new Label(student.getGradDate());
		gradDate.setId("gradLabel");
		gradDate.setTranslateX(110);
		gradDate.setTranslateY(150);
		
		StackPane stack = new StackPane(iv, label, gradDate);
		Scene scene = new Scene(stack);
		scene.getStylesheets().add(this.getClass().getResource("/application/application.css").toExternalForm());
		
		SnapshotParameters snap = new SnapshotParameters();
		
		ImageView printIV = new ImageView(stack.snapshot(snap, null));
		
		return printIV;
	}

}
