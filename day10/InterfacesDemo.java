package day10;

import java.lang.reflect.Proxy;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class InterfacesDemo {
	public static void main(String[] args) {
		Mc medic = new Mc();
		FlightClass flight = new FlightClass();
		Object me;
		
		me = Proxy.newProxyInstance(Human.class.getClassLoader(),new Class[] {Doctor.class},new MyInvocationHandler(medic));
		Doctor medicMe = (Doctor)me;
		medicMe.doCure();
	}
	
}


class Human{
	public void doCry() {
		System.out.println("Crying.....");
	}
}

class MyInvocationHandler implements InvocationHandler{
	Object obj;
	public MyInvocationHandler(Object obj) {
		this.obj = obj;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object o=method.invoke(obj, args);
		return o;
	}
}

interface Doctor{
	public void doCure();
}

interface Pilot{
	public void doFly();
}

class FlightClass implements Pilot{
	@Override
	public void doFly() {
		System.out.println("Thought by FlightClass");
	}
}

class Mc implements Doctor{
	@Override
	public void doCure() {
		System.out.println("Thought by Mc");
	}
}

