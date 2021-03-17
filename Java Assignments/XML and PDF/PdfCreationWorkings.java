package day15Proj;

import java.io.FileOutputStream;
import java.util.List;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import day19.ItemsInfoDTO;

public class PdfCreationWorkings {
	
	public static void createPdf(CustomerData data) throws Exception{
		PdfGenerator pg = new PdfGenerator("Invoice.pdf");
//		CustomerData data = LoadDB.setValues().load(invId);
		pg.create(data);
	}
	
	
	public static void main(String[] args) {
		try {
//			PdfGenerator pg = new PdfGenerator("Invoice.pdf");
//			CustomerData data = LoadDB.setValues().load(invId);
//			pg.create(data);
			
//			PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream("First.pdf"));
//			doc.open();
//			doc.add(new Paragraph("Heyyyyy"));
//			PdfPTable table = new PdfPTable(2);
//			table.addCell("dfsdd");
//			table.addCell("dfsdd");
//			table.addCell("dfsdd");
//			doc.add(table);
//			doc.close();
//			writer.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}


class PdfGenerator{
	PdfWriter writer;
	Document doc = new Document();
	public PdfGenerator(String name) throws Exception{
		this.writer = PdfWriter.getInstance(doc, new FileOutputStream(name));
	}
	
	public Paragraph insertBasicCustomerDetails(CustomerData data) {
		String s = String.format("   Name: %s      BillNo:%d      BillDate:%s", data.name,data.BillNo,data.date.toString());		
		return new Paragraph(s);
	}
	
	public PdfPTable insertInvoiceDetails(CustomerData data) {
		PdfPTable table = new PdfPTable(4);
		table.getDefaultCell().setBorder(0);
		PdfPCell cell = new PdfPCell(this.insertBasicCustomerDetails(data));
		cell.setColspan(5);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setBackgroundColor(BaseColor.GREEN);
		table.addCell(cell);
		table.addCell("Item");
		table.addCell("Qty");
		table.addCell("Unit");
		table.addCell("Price");
		List<ItemsInfoDTO> li = data.items;
		for(ItemsInfoDTO l : li) {
				table.addCell(Integer.toString(l.getItem_no()));
				table.addCell(l.getItem_desp());
				table.addCell(Integer.toString(l.getItem_price()));
				table.addCell(Integer.toString(l.getItem_qty()));
		}
		return table;
	}
	
	public void create(CustomerData data) throws Exception{
		doc.open();
		doc.add(this.insertInvoiceDetails(data));
		doc.close();
		this.writer.close();
	}

}


