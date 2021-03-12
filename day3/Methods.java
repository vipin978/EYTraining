package day3;

public class Methods {
	
	public static void main(String[] args) {
		Methods obj=new Methods();
		obj.met(1,2,3,4,5,6,7);
		String s=obj.met2("world");
		System.out.println(s);
		obj.met(4,3);
	}
	public void met(int... i) {
		//public void aaa() {} - this is not permitted
		class A{ //- Local inner class
			public void aaa() {}  //this is permitted
		}
		for(int x:i) {//latest for loop
			System.out.println(x);
		}
	}
	
	public int met(int i) {
		System.out.println("met with ordinary param..:"+i);
		return 1;
	}
	public int met1(String s) {
		System.out.println("met with string...:"+s);
		return 1;
	}
	
	public String met2(String s) {
		return "hello.."+s;
	}
	public Hello met3() {
		return new Hello();
	}
}

class Hello{
	
}
