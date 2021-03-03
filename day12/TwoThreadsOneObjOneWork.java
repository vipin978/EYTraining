package day12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TwoThreadsOneObjOneWork {
	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(2);
		Gun g = new Gun();
		es.execute(() -> {
			for(int i=0;i<5;i++) {
				g.loadGun();
			}
		});
		es.execute(() -> {
			for(int i=0;i<5;i++) {
				g.shootGun();
			}
		});
		es.shutdown();
	}
}


class Gun{
	boolean flag;
	synchronized public void loadGun() {
		if(flag) {
			try{wait();}catch(Exception e) {}
		}
		System.out.println("Loading the gun.....");
		flag = true;
		notify();
	}
	
	synchronized public void shootGun() {
		if(!flag) {
			try{wait();}catch(Exception e) {}
		}
		System.out.println("Shooting the gun.....");
		flag = false;
		notify();
	}
	
}

