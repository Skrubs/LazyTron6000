package application.io;

import javafx.print.PageLayout;
import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.print.Printer;
import javafx.print.Printer.MarginType;
import javafx.print.PrinterJob;
import javafx.scene.image.ImageView;

public class CertPrinter {
	
	
	private PrinterJob job;
	private Printer printer;
	private PageLayout layout;
		
	
	public CertPrinter() {
		
	}
	
	
	public void printAll(ImageView iv) {
		
		
		
		printer = Printer.getDefaultPrinter();
		layout = printer.createPageLayout(Paper.NA_LETTER, PageOrientation.LANDSCAPE, 
									MarginType.HARDWARE_MINIMUM);
		job = PrinterJob.createPrinterJob(printer);
		
		iv.setFitWidth(layout.getPrintableWidth());
		iv.setFitHeight(layout.getPrintableHeight());
		
		if(job != null) {
			
			boolean success = job.printPage(layout,iv);
			
			if(success) {
				
				job.endJob();
				
			}
			
		}
		
		
	}

}
