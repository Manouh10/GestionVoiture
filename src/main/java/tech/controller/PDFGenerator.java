/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tech.controller;

//import com.example.Trinome.trajet.Carnetdebord;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import tech.model.Trajet;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Manou
 */
public class PDFGenerator {
	List<Trajet> listTrajet;
	public PDFGenerator() {
		 
	}
	public static String getSingleVehicule(List<Trajet> t)
	{
		return ""+t.get(0).getVehc().getMarq().getNom_marque()+" "+t.get(0).getVehc().getNumero()+"" ;
	}
	public PDFGenerator(List<Trajet> listTrajet) {
		super();
		this.listTrajet = listTrajet;
	}
	public List<Trajet> getListTrajet() {
		return listTrajet;
	} 
	public void setListTrajet(List<Trajet> listTrajet) {
		this.listTrajet = listTrajet;
	}


	public void generate(HttpServletResponse response) throws DocumentException, IOException {

		// Creating the Object of Document
		Document document = new Document(PageSize.A4);

		// Getting instance of PdfWriter
		PdfWriter.getInstance(document, response.getOutputStream());

		// Opening the created document to modify it
		document.open();

		// Creating font
		// Setting font style and size
		Font fontTiltle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		fontTiltle.setSize(20);

		// Creating paragraph
		Paragraph paragraph = new Paragraph("Liste des trajets :" +getSingleVehicule(listTrajet)  , fontTiltle);

		// Aligning the paragraph in document
		paragraph.setAlignment(Paragraph.ALIGN_CENTER);

		// Adding the created paragraph in document
		document.add(paragraph);

		// Creating a table of 3 columns
		PdfPTable table = new PdfPTable(3);

		// Setting width of table, its columns and spacing
		table.setWidthPercentage(100f);
		table.setWidths(new int[] { 3, 3, 3 });
		table.setSpacingBefore(5);

		// Create Table Cells for table header
		PdfPCell cell = new PdfPCell();

		// Setting the background color and padding
		cell.setBackgroundColor(CMYKColor.DARK_GRAY);
		cell.setPadding(5);

		// Creating font
		// Setting font style and size
		Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		font.setColor(CMYKColor.WHITE);

		// Adding headings in the created table cell/ header
		// Adding Cell to table
		cell.setPhrase(new Phrase("Depart", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Arrivee", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Chauffeur", font));
		table.addCell(cell);
		for (Trajet list : listTrajet) {
			 
			table.addCell(list.getLieu_depart());	
			table.addCell(list.getLieu_arrivee());
			table.addCell(list.getChauff().getNom_chauffeur()); 
			} 
		cell.setPhrase(new Phrase("Kilometrage", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Consommation", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Motif", font));
		table.addCell(cell); 

		 
		for (Trajet list : listTrajet) { 
		table.addCell(""+list.getKilometrage_arrivee()+"")	;
		table.addCell(""+list.getQuantite()+" L")	;
		table.addCell(list.getMotif());
		 
		}
		// Adding the created table to document
		document.add(table);
	 
		// Closing the document
		document.close();

	}
}
