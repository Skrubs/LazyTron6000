package certificates;

import application.io.ImageLoader;
import javafx.scene.image.ImageView;

public class TGCert extends Certificate {

	public TGCert() {
		super(new ImageView(ImageLoader.tgCert));
		
	}

}
