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
<<<<<<< HEAD

	public void setSf(ShoeFactory sf) {
		this.sf = sf;
=======
	class LeatherShoe extends Shoe{
		public String owner;
		public LeatherShoe(String name) {
			this.owner = name;
			System.out.println("Leather Shoe sold to "+owner);
		}
>>>>>>> ff5051ed76e5c378fd65f2abde11b9f3ea9ede96
	}
	
	
}

<<<<<<< HEAD
class GokulShoeShop extends ShoeShop{
	@Override
	public Shoe sellShoe(Customer c) {
		// TODO Auto-generated method stub
		return getSf().makeShoe();
=======
	class SportShoe extends Shoe{
		public String owner;
		public SportShoe(String name) {
			this.owner = name;
			System.out.println("Sports Shoe sold to "+owner);
		}
>>>>>>> ff5051ed76e5c378fd65f2abde11b9f3ea9ede96
	}
}

// Shoe-----------------------------------------------------------------------------------------------------

abstract class Shoe{
	public String factoryName;

<<<<<<< HEAD
	public Shoe(String name) {
		this.factoryName = name;
=======
abstract class Customer{
	public ShoeShop s;
	public String name;
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	public Customer(String name) {
		this.name = name;
>>>>>>> ff5051ed76e5c378fd65f2abde11b9f3ea9ede96
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

<<<<<<< HEAD
abstract class Customer{
	public String name;
	public Customer(String name) {
		this.name = name;
=======
class GokulShoeShop extends ShoeShop{
	public GokulShoeShop(ShoeFactory sf) {
		super(sf);
	}
	@Override
	public Shoe sellShoe(Customer c) {
		// TODO Auto-generated method stub
		return new LeatherShoe(c.name);
>>>>>>> ff5051ed76e5c378fd65f2abde11b9f3ea9ede96
	}
}


class ShoeCustomer extends Customer{
	
	public ShoeCustomer(String s) {
		super(s);
<<<<<<< HEAD
=======
	}
	public ShoeCustomer() {
		super();
>>>>>>> ff5051ed76e5c378fd65f2abde11b9f3ea9ede96
	}
	
}







