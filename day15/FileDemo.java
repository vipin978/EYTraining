package day15;

import java.io.File;
import java.io.FilenameFilter;

public class FileDemo {
	public static void main(String[] args) {
		File file = new File("Yes");
		System.out.println(file.exists());
		System.out.println(file.getAbsolutePath());
		System.out.println(file.isDirectory());
		File destFile = new File("Yep");
		file.renameTo(destFile);
		String s[] = destFile.list((dir,name)->{
			System.out.println("Dir....."+dir+" Name...."+name);
			return name.endsWith("properties");
		});
		for(String files:s) {
			System.out.println(files);
		}
		
		
	}
}


class MyFilter implements FilenameFilter{
	@Override
	public boolean accept(File dir, String name) {
		// TODO Auto-generated method stub
		return name.endsWith("html");
	}
}