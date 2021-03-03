package day12;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ThreadDemo {
	public static void main(String[] args) {
		Thread th = Thread.currentThread();
//		Thread th2 = new Thread(new ThreadTest());
//		th2.start();
		ExecutorService es = Executors.newFixedThreadPool(1);
		es.execute(() -> {System.out.println("Work given");});
		
		
		System.out.println(th);
	}
}


class ThreadTest implements Runnable{
	@Override
	public void run() {
		System.out.println("Work given to thread");	
	}
}