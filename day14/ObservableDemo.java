package day14;

import java.util.Enumeration;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ObservableDemo {
	public static void main(String[] args) {
		Observe o = new Observe();
		Student s = new Student();
		Teaacher t = new Teaacher();
		
		o.addObserver(t);
		o.addObserver(s);
		
		o.setAlarm();
		
		TS.shutDown();
	}
}

class MultiThreadedObservable extends Observable{
	Vector<Observer> v = new Vector<>();
	@Override
	public void addObserver(Observer o) {
		v.add(o);
//		super.addObserver(o);
	}
	@Override
	public void notifyObservers() {	
		ExecutorService es = Executors.newFixedThreadPool(v.size());
		Enumeration<Observer> e = v.elements();
		while(e.hasMoreElements()) {
			Observer ob = e.nextElement();
			ob.update(this,null);
		}
//		super.notifyObservers();
	}
}

class Observe extends MultiThreadedObservable{
	public void setAlarm() {
		setChanged();
		notifyObservers();
	}
}

class TS{
	public static ExecutorService es = Executors.newFixedThreadPool(2);
	public static void shutDown() {
		es.shutdown();
	}
}

class Student implements Observer{
	public void run() {
		System.out.println("Running");
//		try{Thread.sleep(10000);}catch(Exception e) {}
		System.out.println("Student Running ........");
	}
	public void runs() {
	}
	@Override
	public void update(Observable o, Object arg) {
//		TS.es.execute(() -> {run();});
		run();
	}
}

class Teaacher implements Observer{
	ExecutorService es = Executors.newFixedThreadPool(1);
	public void run() {
//		try{System.out.println("Running");Thread.sleep(10000);}catch(Exception e) {}
		System.out.println("Teacher Running ........");	
	}
	public void runs() {
	}
	
	@Override
	public void update(Observable o, Object arg) {
//		TS.es.execute(() -> {run();});	
		run();
	}
}