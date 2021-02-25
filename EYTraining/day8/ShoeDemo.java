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
		
	}

	class SportShoe extends Shoe{
		
	}
}

abstract class Shoe{
	
}

abstract class Customer{
	ShoeShop s;
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	public Customer(ShoeShop s) {
		this.s = s;
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
		return new LeatherShoe();
	}
}


class ShoeCustomer extends Customer{
	public ShoeCustomer(ShoeShop sf) {
		super(sf);
	}
	public ShoeCustomer(String s) {
		super();
		System.out.println("Shoe sold from"+this.sf);
	}
}



