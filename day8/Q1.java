package day8;

public class Q1 {
	public static void main(String[] args) {
		int a = 1;
		PassByRef pr = new PassByRef(1);
		System.out.println("Before changing a : "+ a+" pr :"+pr.a);
		Change.changing(pr, a);
		System.out.println("After changing a : "+ a+" pr :"+pr.a);
				
	}
}


class PassByRef{
	public int a;
	public PassByRef(int a) {
		this.a = a;
	}
}

class Change{
	public static void changing(PassByRef pr,int pv) {
		pr.a += 1;
		pv += 1;
	}
}