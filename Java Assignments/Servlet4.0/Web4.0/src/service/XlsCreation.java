package service;

import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

import model.ShopDTO;


public class XlsCreation {
	
	public static void createXLS(CustomerData p) throws Exception{
		Xls xl = new Xls("XL12Sheets.xls");
//		CustomerData p = LoadDB.setValues().load(invID);
		xl.insertCustomerDetails(p);
		xl.insertRowHead(Arrays.asList("ItemNo","desc","price","qty"));
		xl.insertRows(p.items);	
		xl.create();
	}
	
	public static void main(String[] args) throws Exception   
	{   

	}
}



class Xls{
	
	Workbook wb = new HSSFWorkbook();
	HSSFSheet sheet = (HSSFSheet)wb.createSheet("January");
	
	static int countRow;
	int fixedRowLength;
	String fileName;
	public Xls(String fileName) throws Exception{
		this.fileName = fileName;
		this.fixedRowLength = 0;
	}
	
	public void insertCustomerDetails(CustomerData p) {
		HSSFRow rowhead = sheet.createRow((short)countRow);
		rowhead.createCell(0).setCellValue("  ");
		rowhead.createCell(1).setCellValue(p.name);
		rowhead.createCell(2).setCellValue("  ");
		rowhead.createCell(3).setCellValue(Integer.toString(p.BillNo));
		rowhead.createCell(4).setCellValue("  ");
		rowhead.createCell(5).setCellValue(p.date.toString());
		countRow += 1;
	}
	
	public void insertRowHead(List<String> al) {
		HSSFRow rowhead = sheet.createRow((short)countRow);
		int pos = 0;
		
		for(String s:al) {
			rowhead.createCell(pos).setCellValue(s);
			pos += 1;
		}  
		countRow += 1;
	}
	
	public void insertRows(List<ShopDTO> al) {
		
		for(ShopDTO ls:al) {
			HSSFRow row = sheet.createRow((short)countRow);
			row.createCell(0).setCellValue(ls.getItemNo());
			row.createCell(1).setCellValue(ls.getItemName());
			row.createCell(2).setCellValue(ls.getItemPrice());
			row.createCell(3).setCellValue(1);
			countRow += 1;
		}
	}
	
	public void create() throws Exception{
		FileOutputStream fileOut = new FileOutputStream("C:\\Users\\user\\eclipse-workspace\\eyWeb4.0\\src\\"+this.fileName);  
		wb.write(fileOut); 
	}
	
}