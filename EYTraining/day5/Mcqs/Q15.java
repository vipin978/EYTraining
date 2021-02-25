package day5;
import java.io.*;

public class Q15 {
	public static void main(String[] args) {
		Mine m=new Mine();
		System.out.println(m.amethod());
	}
}

class Mine {
 public int amethod() {
 try {
 FileInputStream dis=new FileInputStream("Hello.txt");
 }catch (FileNotFoundException fne) {
 System.out.println("No such file found");
 return -1;
 }catch(IOException ioe) {
 } finally{
 System.out.println("Doing finally");
 }
 return 0;
 }
}

// no such file found ,doing finally , -1