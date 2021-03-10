package day17;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;


public class AnnotationDemo {
	public static void main(String[] args) throws Exception{
		Inject ij = Container.getInjectObject();
		ij.print();
	}
}

class Container{
	public static Inject getInjectObject() throws Exception {
		Inject ij = new Inject();
		Field f = ij.getClass().getDeclaredField("h");
		f.setAccessible(true);
//		System.out.println(f);
		Ano an = f.getAnnotation(Ano.class);
		if(an==null) {
			System.out.println("Sorry i wont create");
		}
		else {
			String className = an.paintClass();
			ij.h = (Hey)Class.forName(className).getConstructor().newInstance();
		}
		return ij;
	}
}

@Retention(RetentionPolicy.RUNTIME)
@interface Ano{
	String paintClass();
}

class Inject{
	@Ano(paintClass = "day17.Hey")
	Hey h;
	
	public void print() {
		System.out.println(h);
	}
}


class Hey{
	public Hey() {
		// TODO Auto-generated constructor stub
	}
}


