package day13;

import java.util.PriorityQueue;

public class Q10 {
	public static void main(String[] args) {
		PriorityQueue<String> pq = new PriorityQueue<String>();
		pq.add("2");
		pq.add("4");
		System.out.println(pq.peek() + " ");
		pq.offer("1");
		pq.add("3");
		pq.remove("1");
		System.out.println(pq.poll() + " ");
		if(pq.remove("2")) System.out.println(pq.poll() + " "); 
		System.out.println(pq.poll() + " " + pq.peek());
	}
}
