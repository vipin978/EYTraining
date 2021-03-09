package day15Proj;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;   
import org.apache.poi.ss.usermodel.Workbook;


public class Demo {
	public static void main(String[] args) throws Exception   {
//	{   
//		Xls xl = new Xls("XLSheets.xls");
//
//		xl.creatRowHead(Arrays.asList("Sno","Name","age"));
//		xl.creatRow(Arrays.asList("1","Vipin","14"));
//		xl.create();
//		
//		System.out.println("Created succesfully");
//	}
}
}


//class Xls{
//	
//	Workbook wb = new HSSFWorkbook();
//	HSSFSheet sheet = (HSSFSheet)wb.createSheet("January");
//	
//	static int countRow;
//	int fixedRowLength;
//	String fileName;
//	public Xls(String fileName) throws Exception{
//		this.fileName = fileName;
//		this.fixedRowLength = 0;
//	}
//	
//	public void creatRowHead(List<String> al) {
//		HSSFRow rowhead = sheet.createRow((short)0);
//		int pos = 0;
//		
//		for(String s:al) {
//			rowhead.createCell(pos).setCellValue(s);
//			pos += 1;
//		}  
//		
//		this.fixedRowLength = pos;
//		countRow += 1;
//	}
//	
//	public void creatRow(List<String> al) {
//		HSSFRow row = sheet.createRow((short)countRow);
//		int pos = 0;
//		
//		if(al.size() > fixedRowLength) {
//			System.out.println("Inserting too much row");
//			return;
//		}
//		
//		for(String s:al) {
//			row.createCell(pos).setCellValue(s);
//			pos += 1;
//		}  
//		countRow += 1;
//	}
//	
//	public void create() throws Exception{
//		FileOutputStream fileOut = new FileOutputStream("src\\"+this.fileName);  
//		wb.write(fileOut); 
//	}
//	
//}