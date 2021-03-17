package day15Proj;

import java.io.FileOutputStream;

import java.util.Arrays;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
//import day17.*;
import day19.ItemsInfoDTO;

public class XlsCreationWorking {
	
	public static void createXLS(CustomerData p) throws Exception{
		Xls xl = new Xls("XL11Sheets.xls");
//		CustomerData p = LoadDB.setValues().load(invID);
		xl.insertCustomerDetails(p);
		xl.insertRowHead(Arrays.asList("Item","desc","price","qty"));
		xl.insertRows(p.items);	
		xl.create();
	}
	
	public static void main(String[] args) throws Exception   
	{   
//		Xls xl = new Xls("XLSheets.xls");
//
//		xl.creatRowHead(Arrays.asList("Sno","Name","age"));
//		xl.creatRow(Arrays.asList("1","Vipin","14"));
//		CustomerData p = LoadXml.setValues().load();
//		System.out.println(p.items.get(0).size());
//		
//		System.out.println("Created succesfully");
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
	
	public void insertRows(List<ItemsInfoDTO> al) {
		
		for(ItemsInfoDTO ls:al) {
			HSSFRow row = sheet.createRow((short)countRow);
			row.createCell(0).setCellValue(ls.getItem_no());
			row.createCell(1).setCellValue(ls.getItem_desp());
			row.createCell(2).setCellValue(ls.getItem_price());
			row.createCell(3).setCellValue(ls.getItem_qty());
			countRow += 1;
		}
	}
	
	public void create() throws Exception{
		FileOutputStream fileOut = new FileOutputStream("src\\"+this.fileName);  
		wb.write(fileOut); 
	}
	
}