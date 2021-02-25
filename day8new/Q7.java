package day8;

public class Q7 {
	
	public static void main(String[] args) {
		State s = new State(1);
		s.changeValue(0);
		System.out.println(s.a);
	}
	
	
}


class State{
	public int a;
	public State(int a) {
		// TODO Auto-generated constructor stub
		this.a =a;
	}
	public void changeValue(int a) {
		this.a = a;
	}
}