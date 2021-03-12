package day9;

public class Q3 {
	
	public static void main(String[] args) {
		String s = "Hey u";
		char[] c = s.toCharArray();
		for(int i=c.length-1;i>=0;i--) {
			System.out.println(c[i]);
		}
	}
	
}
