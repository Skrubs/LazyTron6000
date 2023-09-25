package certificates;

import application.io.ImageLoader;
import javafx.scene.image.ImageView;

public class ABCCert extends Certificate{

	public ABCCert() {
		super(new ImageView(ImageLoader.abcCert));
		
	}

}
