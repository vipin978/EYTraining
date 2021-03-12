package day18;

public class MethodReferencingDemo {
	
	public static void main(String[] args) {
		//Printer p = new MethodReferencingDemo()::printImpl;
		Printer p = MethodReferencingDemo::printImpl;
		p.print("hhhh", 2);
	}
	
	public static void printImpl(String s,int num) {
		System.out.println("Hey "+s+" : "+num);
	}
}

interface Printer{
	public void print(String s,int num);
}
