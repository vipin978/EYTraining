package day3and4;
import java.util.*;


// Q8 and Q9
public class Q8 {
	public static void main(String[] args) {
		Avg sg = new Avg();
		sg.calculateAvg();
	}
}

class Avg{
	
	public void calculateAvg() {
		int sums = 0;
		int count = 0;
		int value;
		Scanner s = new Scanner(System.in);
		for(int i=1;i<=4;i++) {
			System.out.println("Enter the mark of student "+ i);
			value = s.nextInt();
			try {
				Handle.isOkay(value);
				sums += value;
				count += 1;
			}
			catch(Exception e) {
				System.out.println(e);
			}	
		}
		System.out.println("Avg is for  " + count + " Students is " + sums/count);
	}
}

class Handle{
	public static void isOkay(int i) throws Exception{
		if (i<0 || i>100) {
			throw new NotToEnterException();
		}
	}
}

class NotToEnterException extends Exception{
	
}