package certificates;

import application.io.ImageLoader;
import javafx.scene.image.ImageView;

public class SalesCert extends Certificate{

	public SalesCert() {
		super(new ImageView(ImageLoader.salesCert));
	
	}

}
