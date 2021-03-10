package day17;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class InternationalizationDemo2 {
	public static void main(String[] args) {
		NumberFormat numberformet = NumberFormat.getCurrencyInstance(Locale.CHINA);
		int i = 100;
		System.out.println(numberformet.format(i));
		DateFormat dateFormat =  DateFormat.getDateInstance(DateFormat.SHORT,Locale.CHINA); 
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		
		DateTimeFormatter dtformat = DateTimeFormatter.ofPattern("MM-d-YYYY");
		String ld = LocalDate.now().format(dtformat);
		System.out.println(ld);
	}
}
