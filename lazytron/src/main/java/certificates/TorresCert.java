package certificates;

import application.io.ImageLoader;
import javafx.scene.image.ImageView;

public class TorresCert extends Certificate {

	public TorresCert() {
		super(new ImageView(ImageLoader.salvCert));

	}

}
