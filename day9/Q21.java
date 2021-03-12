package day9;

public class Q21 {
	public static void main(String[] args) {
		boolean a,b,c,d,e,f,g;
		a = true ;b = false;
		c = a | b;
		d = a & b;
		e = a ^ b;
		f = (! a & b) | (a &! b);
		g =! a;
		System.out.println("Values of c,d,e,f,g respectively ...."+c+" "+d+" "+f+" "+"");
	}
}

