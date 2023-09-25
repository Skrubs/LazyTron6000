package certificates;

import application.io.ImageLoader;
import javafx.scene.image.ImageView;

public class ImpactCert extends Certificate {

	public ImpactCert() {
		super(new ImageView(ImageLoader.impactCert));
		
	}

}
