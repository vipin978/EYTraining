package day15;

import java.io.ByteArrayInputStream;
import java.io.PushbackInputStream;

public class IODemo4 {
	public static void main(String[] args) throws Exception{
		String s = "Hello ";
		PushbackInputStream pbi = new PushbackInputStream(new ByteArrayInputStream(s.getBytes()));
		
		int c = 0;
		while((c = pbi.read()) != -1) {
			if ((char)c == 'h') {
				pbi.unread('H');
			}
			else {
				System.out.println((char)c);
			}
		}
	}
}

