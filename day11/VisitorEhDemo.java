package day11;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.*;

public class VisitorEhDemo {
	public static void main(String[] args) throws Exception {
		Child ch  = new Child();
		Dog dg = new Dog();
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the item...");
		String itemClass = s.nextLine();
		Item item = (Item)Class.forName(itemClass).getConstructor().newInstance();
		System.out.println("Created");
		ch.play(dg, item);
		
	}
}


class Child{
	public void play(Dog dog,Item item) {
		try {
			dog.reaction(item);
			
		}
		catch(DogExceptions e) {
			e.visit();
		}
	}
}



class Dog{
	public void reaction(Item item) throws DogExceptions{
		item.execute();
	}
}

abstract class Item{
	public abstract void execute() throws DogExceptions;
}

class StoneItem extends Item{
	public StoneItem() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void execute() throws DogExceptions{
		throw new DogBarkException("Dont Use this Exception");
	}
}

class StickItem extends Item{
	public StickItem() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void execute() throws DogExceptions{
		throw new DogBiteException("Dont Use this Item too");
	}
}


abstract class DogExceptions extends Exception{
	
	public abstract void visit();
}

class DogBarkException extends DogExceptions{
	public String msg;
	public DogBarkException(String msg) {
		this.msg = msg;
	}
	@Override
	public String toString() {
		return this.msg;
	}
	@Override
	public void visit() {
		new HandlerIndia().handle(this);
	}
}

class DogBiteException extends DogExceptions{
	public String msg;
	public DogBiteException(String msg) {
		this.msg = msg;
	}
	@Override
	public String toString() {
		return this.msg;
	}
	@Override
	public void visit() {
		new HandlerIndia().handle(this);
	}
}

interface Handler911{
	public void handle(DogBarkException db);
	public void handle(DogBiteException de);
}

class HandlerIndia implements Handler911{
	@Override
	public void handle(DogBarkException db) {
		System.out.println("Dont worry he wont bark");
	}
	@Override
	public void handle(DogBiteException de) {
		System.out.println("Dont worry he wont bite");
	}
}

class Test{
	public void doCry() {
		System.out.println("Crying.....");
	}
}

class MyInvocationHandler implements InvocationHandler{
	Object[] obj;
	public MyInvocationHandler(Object[] obj) {
		this.obj = obj;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object returnObj = null;
		for(Object o:obj) {
			Method[] m = o.getClass().getMethods();
			for(Method me:m) {
				if(me.getName().equals(method.getName())) {
					returnObj = method.invoke(o, args);
				}
			}
		}
		return returnObj;
	}
}