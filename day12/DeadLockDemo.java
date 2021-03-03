package day12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DeadLockDemo {
	public static void main(String[] args) {
		Crane c = new Crane();
		Frog f = new Frog();
		ExecutorService es = Executors.newFixedThreadPool(2);
		es.execute(() -> {
			c.eatFrog(f);
		});
		es.execute(() -> {
//			System.out.println("                                         ");
			f.escape(c);
		});
		es.shutdown();
	}
}


class Crane{
	synchronized public void eatFrog(Frog frog) {
		System.out.println("Called crane");
		frog.leaveCrane();
	}
	
	synchronized public void spitFrog() {
		System.out.println("called spitFrog");
	}
}


class Frog{
	synchronized public void escape(Crane crane) {
		System.out.println("Called frog");
		crane.spitFrog();
	}
	
	synchronized public void leaveCrane() {
		System.out.println("called leaveCrane");
	}
}

