package day6;

public class KhaitanFan {
	
	State s;
	public void pull() {
		s.run();
	}
}



abstract class State{
	public static int state = -1;
	public static int finalState = 4;
	abstract void run();
	public static int getState() {
		State.state = (State.state + 1) % finalState;
		return state;
	}
}

class State0 extends State{
	@Override
	void run() {
		System.out.println("Running slowly");
	}
}


class State1 extends State{
	@Override
	void run() {
		System.out.println("Running little bit fast");
	}
}

class State2 extends State{
	@Override
	void run() {
		System.out.println("Running Medium fast");
	}
}

class State3 extends State{
	@Override
	void run() {
		System.out.println("Running faster");	
	}
}