package day18;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalDemo {
	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(4);
		es.execute(() -> {
			try {
				Resource m = ResourceManagement.getResource("abc");
				FileOutputStream fs = m.getStream();
				fs.write("Hey....".getBytes());
				Resource m2 = ResourceManagement.getResource("abc");
				FileOutputStream f = m2.getStream();
				f.write("fdfs".getBytes());
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		es.execute(() -> {
			try {
				Resource m = ResourceManagement.getResource("abc2");
				FileOutputStream fs = m.getStream();
				fs.write("Hey....".getBytes());
				Resource m2 = ResourceManagement.getResource("abc");
				FileOutputStream f = m2.getStream();
				f.write("fdfs".getBytes());
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}
}


class ResourceManagement{
	static ThreadLocal<Resource> tlocal = new ThreadLocal<Resource>();
	public static Resource getResource(String name) {
		Resource r = tlocal.get();
		if(r==null) {
			r = new Resource(name);
			tlocal.set(r);
		}
		return r;
	}
}

class Resource{
	
	FileOutputStream file;
	public Resource(String name) {
		try {
		this.file =new FileOutputStream(name,true);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	 public FileOutputStream getStream() {
		 return this.file;
	 }
}