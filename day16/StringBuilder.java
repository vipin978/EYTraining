package day16;

import java.util.StringJoiner;

public class StringBuilder {
	public static void main(String[] args) {
		java.lang.StringBuilder sb = new java.lang.StringBuilder("Hey");
		System.out.println(sb);
		sb.append("  Hey");
		System.out.println(sb);
		
		StringJoiner sj = new StringJoiner("Hiiii");
		sj.add("hello");
		sj.add("hi");
		System.out.println(sj);
		
	}
}
