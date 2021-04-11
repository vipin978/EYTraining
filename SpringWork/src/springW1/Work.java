package springW1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Work {
	public static void main(String[] args) {
		System.out.println("sjshjh");
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		context.registerShutdownHook();
		Triangle triangle = (Triangle) context.getBean("triangle1");
		triangle.draw();
	}
}
