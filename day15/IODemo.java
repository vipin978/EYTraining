package day15;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class IODemo {
	public static void main(String[] args) {
		CopyCmd cc = new CopyCmd();
		cc.copy("src/re.properties");
	}
}


class CopyCmd{
	public void copy(String fileName) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		byte[] b = new byte[8];
		try {
			fis = new FileInputStream(fileName);
			fos = new FileOutputStream("wr.properties");
//			int letter;
			int noCharRead;
			while((noCharRead = fis.read(b)) != -1) {
				fos.
				System.out.println((char)noCharRead);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}