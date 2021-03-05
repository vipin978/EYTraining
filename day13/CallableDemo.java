package day13;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo {
	public static void main(String[] args) throws Exception{
		ExecutorService es = Executors.newFixedThreadPool(1);
		Future<Integer> future = es.submit(() -> {System.out.println("Heyyy");return 100;});
		System.out.println("Running");
		int i = future.get();
		System.out.println(i);
		
	}
}


class MyThread implements Callable<Integer>{
	@Override
	public Integer call() throws Exception {
		try {Thread.sleep(10000);} catch(Exception e) {}
		System.out.println("Heyyy");
		return 101;
	}
}








//interface Chekin<T>{
//	public T justChekin();
//}
//
//class Ex implements Chekin<B>{
//	@Override
//	public B justChekin() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//}