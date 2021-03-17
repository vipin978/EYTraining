package day15Proj;

import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

public class XlsCreationWorking {
	public static void main(String[] args) throws Exception   
	{   
		Xls xl = new Xls("XLSheets.xls");
//
//		xl.creatRowHead(Arrays.asList("Sno","Name","age"));
//		xl.creatRow(Arrays.asList("1","Vipin","14"));
		CustomerData p = LoadXml.setValues().load();
		System.out.println(p.items.get(0).size());
		xl.insertCustomerDetails(p);
		xl.insertRowHead(Arrays.asList("S.NO","Item","Unit","Price","qty"));
		xl.insertRows(p.items);
		xl.create();
		
		System.out.println("Created succesfully");
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
		rowhead.createCell(3).setCellValue(p.BillNo);
		rowhead.createCell(4).setCellValue("  ");
		rowhead.createCell(5).setCellValue(p.date);
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
	
	public void insertRows(List<List<String>> al) {
		
		for(List<String> ls:al) {
			HSSFRow row = sheet.createRow((short)countRow);
			int pos = 0;
			for(String s:ls) {
				row.createCell(pos).setCellValue(s);
				pos += 1;
			}
			countRow += 1;
		}
	}
	
	public void create() throws Exception{
		FileOutputStream fileOut = new FileOutputStream("src\\"+this.fileName);  
		wb.write(fileOut); 
	}
	
}