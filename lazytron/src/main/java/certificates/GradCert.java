package certificates;

import application.Student;
import application.io.ImageLoader;
import javafx.print.PageLayout;
import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.print.Printer;
import javafx.print.Printer.MarginType;
import javafx.print.PrinterJob;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

public class GradCert extends Certificate {

	public GradCert() {
		super(new ImageView(ImageLoader.gradCert));
		
	}
	
	
	public ImageView getSnapShot(Student student) {
		
		ImageView iv = new ImageView(ImageLoader.gradCert);
				
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