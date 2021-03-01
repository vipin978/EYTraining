package day10;
import java.lang.ref.*;

public class GcDemo {
	public static void main(String[] args) {
		Runtime r = Runtime.getRuntime();
		System.out.println(r.freeMemory());
		Occupy o = new Occupy();
		System.out.println(r.freeMemory());
//		WeakReference weakTatha=new WeakReference(o);
		SoftReference soft = new SoftReference(o);
		System.out.println(o);
		o = null;
		r.gc();
		o = (Occupy)soft.get();
		System.out.println(r.freeMemory() + "" + o);
		
	}
}



class Occupy{
	String space;
	public Occupy() {
		for(int i=0;i<10000;i++) {
			this.space += "  ";
		}
	}
	
	@Override
	protected void finalize() throws Throwable {
		System.out.println("Gold is....:called");
	}
}