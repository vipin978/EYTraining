package day8;

public class Q9 {
public static void main(String[] args) {
	Sub s = new Sub();
	s.analyze();
}
}


class Base{
	private int a = 1;
	public int b = 1;
	protected int c = 1;
	
	
}


class Sub extends Base{
	public int n =1;
	public void analyze() {
	//	System.out.println(a); --- this will give an error
		System.out.println(b);
		System.out.println(c);
		System.out.println(n);
	}
}