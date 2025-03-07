package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class FetchDataFromPDF {

	public static void main(String[] args) throws Throwable {

		FileInputStream fis = new FileInputStream("C:\\workspaces\\8 Aug 24\\AdvanceSeleniumFW\\src\\test\\resources\\Nitish  - Offer Letter.pdf");
		PDDocument doc= PDDocument.load(fis);
		
		//to get the number of pages in pdf
		int pages = doc.getNumberOfPages();
		System.out.println(pages);
		
		//to fetch all pages pdf data
		PDFTextStripper pdfData = new PDFTextStripper();
		String readData = pdfData.getText(doc);
		System.out.println(readData);
		
		//to fetch data from specific page
		//pdfData.setStartPage(2);
		//pdfData.setEndPage(2);     //to fetch data of particular page
		//String readData = pdfData.getText(doc);
		//System.out.println(readData);

		
		//to fetch data of perticular one page
		
		
		
		
		
		
		
		
	}

}
