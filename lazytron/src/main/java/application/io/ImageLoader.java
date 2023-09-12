package application.io;

import javafx.scene.image.Image;

public class ImageLoader {
	
	
	
	private static String abcLocation = ImageLoader.class.getResource("/certs/abccert.png").toExternalForm();
	private static String dgLocation = ImageLoader.class.getResource("/certs/dgcert.png").toExternalForm();
	private static String gradLocation = ImageLoader.class.getResource("/certs/gradcert.png").toExternalForm();
	private static String impactLocation = ImageLoader.class.getResource("/certs/impactcert.png").toExternalForm();
	private static String salesLocation = ImageLoader.class.getResource("/certs/salescert.png").toExternalForm();
	private static String salvLocation = ImageLoader.class.getResource("/certs/salvadorcert_Page_1.png").toExternalForm();
	private static String salv2Location = ImageLoader.class.getResource("/certs/salvadorcert_Page_1_Page_2.png").toExternalForm();
	private static String tgLocation = ImageLoader.class.getResource("/certs/tgcert.png").toExternalForm();

	
	public static Image abcCert = new Image(abcLocation, 500, 500, true, false);
	public static Image dgCert = new Image(dgLocation, 500, 500, true, false);
	public static Image gradCert = new Image(gradLocation, 500, 500, true, false);
	public static Image impactCert = new Image(impactLocation, 500, 500, true, false);
	public static Image salesCert = new Image(salesLocation, 500, 500, true, false);
	public static Image salvCert = new Image(salesLocation, 500, 500, true, false);
	public static Image tgCert = new Image(tgLocation, 500, 500, true, false);
	public static Image salvPg2 = new Image(salv2Location, 500, 500, true, false);
		

}
