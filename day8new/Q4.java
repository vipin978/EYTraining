package day8;
import java.util.*;

public class Q4 {
	Stack<Integer> stack = new Stack<Integer>();
	
	public static void main(String[] args) {
		Q4 s = new Q4();
		s.stack.push(1);
		s.stack.push(22);
		System.out.println("Top element in stack "+s.stack.peek());
		
	}
}
