package day5;

abstract class MineBase{
	abstract void amethod();
	static int i;
}

public class Q11 extends MineBase {
	public static void main(String[] args) {
		int [] ar = new int[5];
		for(i=0;i<ar.length;i++) {
			System.out.println(ar[i]);
		}
	}
}

// Q11 should must implement the inherited abstract method