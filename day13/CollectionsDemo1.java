package day13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.ListIterator;

public class CollectionsDemo1 {
	public static void main(String[] args) {
		ArrayList<Employee> el = new ArrayList<Employee>();
		el.add(new Employee("Me"));
		el.add(new Employee("Me1"));
		el.add(new Employee("Me3"));
		
		for(Employee e:el) {
			System.out.println(e);
		}
		
		Iterator<Employee> iter = el.iterator();
		ListIterator<Employee> liter = el.listIterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		System.out.println("Special checking ....");
		while(liter.hasNext()) {
			System.out.println(liter.next());
		}
		while(liter.hasPrevious()) {
			System.out.println(liter.previous());
		}
		
		Collections.sort(el,(obj1,obj2) -> {return obj2.compareTo(obj1);});
		System.out.println(el);
		
	}
}


class Employee implements Comparable<Employee>{
	public String name;
	public Employee(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Name is  "+name ;
	}
	@Override
	public int compareTo(Employee o) {
		return this.name.compareTo(o.name);
	}
}

