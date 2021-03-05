package day13;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Q9 {
	public static void main(String[] args) {
		Object o = new Object();
//		TreeSet s = new TreeSet(); 
		LinkedHashSet s = new LinkedHashSet();
		s.add("o");
		s.add(o);
		System.out.println(s);
}
}

