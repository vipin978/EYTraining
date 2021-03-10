package day17;

import java.util.Locale;
import java.util.ResourceBundle;

public class Internationalization {
	public static void main(String[] args) {
		Locale.setDefault(new Locale("ta"));
		Locale local = Locale.getDefault();
		System.out.println(local);
		
		ResourceBundle rb = ResourceBundle.getBundle("day17.Dictionary",local);
		System.out.println(rb.getString("Hi"));
	}
}
