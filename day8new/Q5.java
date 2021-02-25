package day8;

public class Q5 {
	public static void main(String[] args) {
		Counter c1 = new Counter();
		Counter c2 = new Counter();
		System.out.println("No of obj created are "+Counter.count+c1+c2);
		
	}
}

class Counter{
	public static int count = 0;
	public Counter() {
		// TODO Auto-generated constructor stub
		count += 1;
	}
}