package day13;

import java.util.ArrayList;

public class GenericsDemo {
	public static void main(String[] args) {
		Generic<Integer> gn = new Generic<>();
		gn.setObj(3);
		System.out.println(gn.getObj());
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("Hii");
		String i = arr.get(0);
		System.out.println(i);
	}
}


class Generic<T>{
	T obj;
	
	public T getObj() {
		return obj;
	}
	
	public void setObj(T obj) {
		this.obj = obj;
	}
}