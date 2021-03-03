package day12;

public class LambdaDemo {
	public static void main(String[] args) {
		Impl im = new Impl();
		im.giveInt(() -> {System.out.println("Interface met method");});
	}
}


interface Lamb{
	public void met();
}



class Impl{
	public void giveInt(Lamb lb) {
		lb.met();
	}
}