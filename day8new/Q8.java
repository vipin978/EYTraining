package day8;


public class Q8 {
	//Singleton s = new Singleton(); -- this will give error
	Singleton s = 	Singleton.s;
}


class Singleton{
	public static Singleton s = new Singleton();
	private Singleton() {
		
	}
	
}