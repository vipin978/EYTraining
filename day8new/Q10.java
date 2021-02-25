package day8;

public class Q10 {
	public static void main(String[] args) {
		C c = new C();
		
	}
}


class A{
	public A() {
		// TODO Auto-generated constructor stub
		System.out.println("A created");
	}
}


class B{
	public B() {
		// TODO Auto-generated constructor stub
		System.out.println("B created");
	}
}

class C extends A{
	B b = new B();
}