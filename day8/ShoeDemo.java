package day8;

public class ShoeDemo {
	
}

interface ManuFacturer{
	
}

interface ShoeManufacturer extends ManuFacturer{
	public Shoe makeShoe();
}

abstract class ShoeFactory implements ShoeManufacturer{
	class LeatherShoe extends Shoe{
		
	}

	class SportShoe extends Shoe{
		
	}
}

interface Seller{
	
}

interface ShoeSeller extends Seller{
	public Shoe sellShoe(Customer c);
}

abstract class ShoeShop implements ShoeSeller{
	ShoeFactory sf;
	public ShoeShop(ShoeFactory sf) {
		this.sf = sf; 
	}
	class LeatherShoe extends Shoe{
		public String owner;
		public LeatherShoe(String name) {
			this.owner = name;
			System.out.println("Leather Shoe sold to "+owner);
		}
	}

	class SportShoe extends Shoe{
		public String owner;
		public SportShoe(String name) {
			this.owner = name;
			System.out.println("Sports Shoe sold to "+owner);
		}
	}
}

abstract class Shoe{
	
}

abstract class Customer{
	public ShoeShop s;
	public String name;
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	public Customer(String name) {
		this.name = name;
	}
}

class BataShoeFactory extends ShoeFactory{
	@Override
	public Shoe makeShoe() {
		// TODO Auto-generated method stub
		return new LeatherShoe();
	}
}

class LakhainShoeFactory extends ShoeFactory{
	@Override
	public Shoe makeShoe() {
		// TODO Auto-generated method stub
		return new SportShoe();
	}
}


class GokulShoeShop extends ShoeShop{
	public GokulShoeShop(ShoeFactory sf) {
		super(sf);
	}
	@Override
	public Shoe sellShoe(Customer c) {
		// TODO Auto-generated method stub
		return new LeatherShoe(c.name);
	}
}


class ShoeCustomer extends Customer{
	
	public ShoeCustomer(String s) {
		super(s);
	}
	public ShoeCustomer() {
		super();
	}
}







