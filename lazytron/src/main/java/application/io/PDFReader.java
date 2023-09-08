package application.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class PDFReader{
	
	private File file;
	private FileChooser chooser;
	private PDDocument doc;
	
	
	/**
	 * Basic constructor
	 */
	public PDFReader() {
		
	}
	
	/**
	 * Loads in the PDF file using filechooser.  IF NOTHING IS SELECTED WILL RETURN NULL
	 * @throws IOException
	 */
	public String gettFile(Stage stage)throws IOException {
		
		//CREATES THE FILECHOOSER AND ADDS PDF ONLY EXTENSION.
		ExtensionFilter filter = new ExtensionFilter("PDF Files", "*.PDF", "*.pdf");
		chooser = new FileChooser();
		chooser.setSelectedExtensionFilter(filter);
		chooser.setInitialDirectory(new File(System.getProperty("user.home")));
		chooser.getExtensionFilters().add(filter);
		file = chooser.showOpenDialog(stage);
		
		//IF THE FILE IS NULL GETFILE() RETURNS NULL
		if(file == null) {
			return null;
		}
		
		//IF THE FILE FROM CHOOSER WAS A PDF FILE THE PDF LOADER WILL LOAD TO PDDOCUMENT
		doc = Loader.loadPDF(file);
		
		//if the document is not empty it will return the selected document
		if(doc != null) {
			return convertPDFtoText(doc);
		}
		//returns null if the document was empty or no document selected;
		return null;
			
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
	
	public static void writeToRoster(String roster) {
	
		
		
	}

}
