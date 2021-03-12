package day13;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.*;


public class ForkJoinDemo {
	public static void main(String[] args) throws Exception {
		String[] msa = {"yep","yes","no","yess","yass","no","yeah"};
		int finalResult = 0;
		ForkJoinPool fjPool = ForkJoinPool.commonPool();
		List<Future<Integer>> result = fjPool.invokeAll(Arrays.asList(new Task(0,3,msa,"no"),new Task(3,5,msa,"no"),new Task(5,6,msa,"no")));
		for(Future<Integer> res:result) {
			finalResult += res.get();
		}
		System.out.println(finalResult);
	}
}


class Task implements Callable<Integer>{
	public int startPos;
	public int endPos;
	public String[] arr;
	public String searchElement;
	
	public Task() {
	}
	public Task(int startPos, int endPos, String[] arr, String searchElement) {
		super();
		this.startPos = startPos;
		this.endPos = endPos;
		this.arr = arr;
		this.searchElement = searchElement;
		System.out.println("Called " + startPos);
	}
	@Override
	public Integer call() throws Exception {
		
		int count = 0;
		for(int i =startPos;i<=endPos;i++) {
			if(arr[i].equals(searchElement)) {
				count += 1;
			}
		}
		return count;
	}
}