package day3and4;
import java.io.*;

public class Q1 {
	public static void main(String[] args) throws Exception {
		E e = new E();
		try {
			e.throwing(0);
		}
		catch (Exception ex){
			System.out.println(ex);
		}
		
	}
}


class E{
	public void throwing(int i) throws Exception {
		throw new IOException("device error");
	}
}