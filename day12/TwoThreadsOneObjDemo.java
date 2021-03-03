package day12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class TwoThreadsOneObjDemo {
	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(2);
		TrainReservation tr = new TrainReservation();
		es.execute(() -> {
			Thread th = Thread.currentThread();
			th.setName("Me");
			synchronized (tr) {
				tr.bookTicket(1000);
				tr.giveChange();
			}
		});
		es.execute(() -> {
			Thread th = Thread.currentThread();
			th.setName("Another Guy");
			synchronized (tr) {
				tr.bookTicket(500);
				tr.giveChange();
			}
		});
		
	}
}



class TrainReservation{
	int amt;
//	synchronized 
	public void bookTicket(int amt) {
		this.amt = amt;
		Thread th = Thread.currentThread();
		String name = th.getName();
		System.out.println("Ticket booked for ...."+name +" "+ amt);
//		try {Thread.sleep(1000);} catch(Exception e) {}
	}
	//synchronized 
	public void giveChange() {
		System.out.println("Change given ....  "+ (amt-100));
	}
}