package application.io;

import java.io.File;
import java.io.IOException;
import java.security.cert.Extension;

import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class PDFReader {
	
	private File file;
	private FileChooser chooser;
	
	
	/**
	 * Basic constructor
	 */
	public PDFReader() {
		
	}
	
	public PDFReader(File file) {
		
		this.file = file;
		
	}
	
	public void gettFile()throws IOException {
		
		ExtensionFilter filter = new ExtensionFilter("PDF files(*.pdf)", "*.pdf", "*.PDF");
		chooser = new FileChooser();
		chooser.setSelectedExtensionFilter(filter);
		
		
		file = chooser.showOpenDialog(null);
		
		
	}

}
