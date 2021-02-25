package day8;

public class Q11 {
	C1 c = new C1(1);
}



class A1{
	public int a;
	public A1(int a) {
		// TODO Auto-generated constructor stub
		System.out.println("A created with value "+this.a);
	}
}


class B1{
	public int a;
	public B1(int a) {
		// TODO Auto-generated constructor stub
		System.out.println("B created with value "+this.a);
	}
	
}

class C1 extends A1{
	public int a;
	public C1(int a){
		super(a);
		B1 b = new B1(3);
	}
}