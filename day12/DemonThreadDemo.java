package day12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DemonThreadDemo {
	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(1);
		System.out.println("Creating");
		Dm d = new Dm();
		es.execute(() -> {
			d.method();
		});
		Thread.currentThread().setDaemon(true);
		System.exit(0);
	}
}


class Dm{
	public void method() {
		for(int i = 0;i<10;i++) {
			System.out.println("Child runing");
		}
	}
}