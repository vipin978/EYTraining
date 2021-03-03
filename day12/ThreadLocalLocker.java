package day12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalLocker {
	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(2);
		es.execute(() -> {
			Things th = School.getLocker("Me");
			Things th2 = School.getLocker("Me");
		});
		es.execute(() -> {
			Things th = School.getLocker("Me2");
		});
	}
}



class School{
	private static ThreadLocal locker=new ThreadLocal();
	public static Things getLocker(String name) {
		Things th = (Things)locker.get();
		if (th == null) {
			th = new Things(name);
			locker.set(th);
		}
		return th;
	}
}

class Things{
	String name;
	public Things(String name) {
		this.name = name;
		System.out.println("Object Created");
	}
	
	@Override
	public String toString() {
		return name;
	}
}