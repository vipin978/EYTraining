package day8;

public class Q6 {
	public static void main(String[] args) {
		StaticImpl si = new StaticImpl();
		si.method1();
	}
}

class StaticImpl{
	static {
		System.out.println("StaticCalled");
	}
	
	public void method1(){
		System.out.println("Method called");
	}
}