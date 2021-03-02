package day3and4;


// Q2 and Q3
public class Q2 {
	public static void main(String[] args) {
		Sample s = new Sample();
		s.mth1();
	}
}


class Sample{
	public void mth1() {
		mt2();
		System.out.println("Caller");
	}
	public void mt2() {
		try {
			
			System.exit(0);
			return;
		}
		catch(Exception e) {
			System.out.println("Mth2 catched");
		}
		finally {
			System.out.println("Called");
		}
	}
}