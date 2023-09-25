package certificates;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public abstract class Certificate extends Pane {
	
	protected ImageView certImageView;
	protected double fitHeight = 150;
	protected String id = "previewContainer";
	
	public Certificate(ImageView iv) {
		
		certImageView = iv;
		this.getChildren().add(certImageView);
		certImageView.setFitHeight(fitHeight);
		certImageView.setPreserveRatio(true);
		
		this.setId(id);
		
		
	}

	public ImageView getCertImageView() {
		return certImageView;
	}

	public void setCertImageView(ImageView certImageView) {
		this.certImageView = certImageView;
	}

	public double getFitHeight() {
		return fitHeight;
	}

	public void setFitHeight(double fitHeight) {
		this.fitHeight = fitHeight;
	}

	
	
	
}
