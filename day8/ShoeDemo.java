package day8;

public class ShoeDemo {
	
}

// Factory code --------------------------------------------------------------------
interface ManuFacturer{
	
}

interface ShoeManufacturer extends ManuFacturer{
	public Shoe makeShoe();
}

abstract class ShoeFactory implements ShoeManufacturer{
	public boolean leatherShoe;
	public boolean sportShoe;
	public boolean slippers;
	public ShoeFactory(ShoeFactoryBuilder builder) {
		
	}
}

class ShoeFactoryBuilder{
	
	private boolean leatherShoe;
	private boolean sportShoe;
	private boolean slippers;
	
	public boolean isLeatherShoe() {
		return leatherShoe;
	}
	public ShoeFactoryBuilder setLeatherShoe(boolean leatherShoe) {
		this.leatherShoe = leatherShoe;
		return this;
	}
	public boolean isSportShoe() {
		return sportShoe;
	}
	public ShoeFactoryBuilder setSportShoe(boolean sportShoe) {
		this.sportShoe = sportShoe;
		return this;
	}
	public boolean isSlippers() {
		return slippers;
	}
	public ShoeFactoryBuilder setSlippers(boolean slippers) {
		this.slippers = slippers;
		return this;
	}
	public ShoeFactory build(String name) throws Exception{
		return (ShoeFactory)Class.forName(name).newInstance();
	}
}

class BataShoeFactory extends ShoeFactory{
	@Override
	public Shoe makeShoe() {
		// TODO Auto-generated method stub
		return new LeatherShoe("Bata");
	}
}

class LakhainShoeFactory extends ShoeFactory{
	@Override
	public Shoe makeShoe() {
		// TODO Auto-generated method stub
		return new SportShoe("Lakhain");
	}
}

// ShoeSeller------------------------------------------------------------------------------------------------
interface Seller{
	
}

interface ShoeSeller extends Seller{
	public Shoe sellShoe(Customer c);
}

abstract class ShoeShop implements ShoeSeller{
	private ShoeFactory sf;

	public ShoeFactory getSf() {
		return sf;
	}

	public void setSf(ShoeFactory sf) {
		this.sf = sf;
	}
	
	
}

class GokulShoeShop extends ShoeShop{
	@Override
	public Shoe sellShoe(Customer c) {
		// TODO Auto-generated method stub
		return getSf().makeShoe();
	}
}

// Shoe-----------------------------------------------------------------------------------------------------

abstract class Shoe{
	public String factoryName;

	public Shoe(String name) {
		this.factoryName = name;
	}
}

class LeatherShoe extends Shoe{
	public LeatherShoe(String name) {
		super(name);
		System.out.println("Sports Shoe made by "+this.factoryName);
	}
}

class SportShoe extends Shoe{
	
	public SportShoe(String name) {
		super(name);
		System.out.println("Sports Shoe made by "+this.factoryName);
	}
}

// ------------------------------------------------------------------------------------------------------

abstract class Customer{
	public String name;
	public Customer(String name) {
		this.name = name;
	}
}


class ShoeCustomer extends Customer{
	
	public ShoeCustomer(String s) {
		super(s);
	}
	
}



