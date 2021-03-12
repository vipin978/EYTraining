package day15;

import java.io.ByteArrayInputStream;
import java.io.SequenceInputStream;
import java.io.StringBufferInputStream;

public class IODemo5 {
	public static void main(String[] args) throws Exception{
		ByteArrayInputStream bis = new ByteArrayInputStream("Hello   ".getBytes());
		StringBufferInputStream sbis = new StringBufferInputStream("Haiii  ");
		
		SequenceInputStream si = new SequenceInputStream(bis,sbis);
		int c = 0;
		while((c = si.read()) != -1) {
			System.out.println((char)c);
		}
	}
}

