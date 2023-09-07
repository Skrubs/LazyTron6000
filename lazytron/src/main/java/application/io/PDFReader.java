package application.io;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class PDFReader{
	
	private File file;
	private FileChooser chooser;
	private PDDocument doc;
	
	
	/**
	 * Basic constructor
	 */
	public PDFReader() {
		
	}
	
	public PDFReader(File file) {
		
		this.file = file;
		
	}
	
	/**
	 * Loads in the PDF file using filechooser
	 * @throws IOException
	 */
	public void gettFile()throws IOException {
		
		ExtensionFilter filter = new ExtensionFilter("PDF files(*.pdf)", "*.pdf", "*.PDF");
		chooser = new FileChooser();
		chooser.setSelectedExtensionFilter(filter);
		
		
		file = chooser.showOpenDialog(null);
		doc = Loader.loadPDF(file);
			
	}
	
	
	/**
	 * Takes in a PDF document and converts it to a string
	 * @param doc
	 * @return
	 * @throws IOException
	 */
	public String convertPDFtoText(PDDocument doc) throws IOException {
		
		return new PDFTextStripper().getText(doc);
		
	}

}
