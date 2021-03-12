package day8;
import java.lang.reflect.Field;

public class ShoeDemo {
	
}

// Factory code --------------------------------------------------------------------
interface ManuFacturer{
	
}

interface ShoeManufacturer extends ManuFacturer{
	public Shoe makeShoe(String s) throws Exception;
}

abstract class ShoeFactory implements ShoeManufacturer{
	public boolean LeatherShoe;
	public boolean SportShoe;
	public boolean Slippers;
	public ShoeFactory(ShoeFactoryBuilder builder) {
		this.LeatherShoe = builder.isLeatherShoe();
		this.SportShoe = builder.isSportShoe();
		this.Slippers = builder.isSlippers();
	}
}

class ShoeFactoryBuilder{
	
	private boolean LeatherShoe;
	private boolean SportShoe;
	private boolean Slippers;
	
	public boolean isLeatherShoe() {
		return LeatherShoe;
	}
	public ShoeFactoryBuilder setLeatherShoe(boolean leatherShoe) {
		this.LeatherShoe = leatherShoe;
		return this;
	}
	public boolean isSportShoe() {
		return SportShoe;
	}
	public ShoeFactoryBuilder setSportShoe(boolean sportShoe) {
		this.SportShoe = sportShoe;
		return this;
	}
	public boolean isSlippers() {
		return Slippers;
	}
	public ShoeFactoryBuilder setSlippers(boolean slippers) {
		this.Slippers = slippers;
		return this;
	}
	public ShoeFactory build(String name) throws Exception{
		return (ShoeFactory)Class.forName(name).getConstructor(new Class[] {ShoeFactoryBuilder.class}).newInstance(this);
	}
}

class BataShoeFactory extends ShoeFactory{
	
	public BataShoeFactory(ShoeFactoryBuilder sfb) {
		super(sfb);
	}
	@Override
	public Shoe makeShoe(String shoeType) throws Exception {
		Class c=this.getClass();
		try {
			Field f=c.getField(shoeType);
			if((boolean)f.get(this)) {
				return (Shoe)Class.forName("day8."+shoeType).getConstructor(new Class[] {String.class}).newInstance("Lakhain");
			}
			else {
				return new NoShoe("Lakhin");
			}
			}
			catch(Exception e){
				return new NoShoe("Lakhin");
			}
	}
}

class LakhainShoeFactory extends ShoeFactory{
	
	public LakhainShoeFactory(ShoeFactoryBuilder sfb) {
		super(sfb);
	}
	@Override
	public Shoe makeShoe(String shoeType) throws Exception {
		Class c=this.getClass();
		try {
		Field f=c.getField(shoeType);
		if((boolean)f.get(this)) {
			return (Shoe)Class.forName("day8."+shoeType).getConstructor(new Class[] {String.class}).newInstance("Lakhain");
		}
		else {
			return new NoShoe("Lakhin");
		}
		}
		catch(Exception e){
			return new NoShoe("Lakhin");
		}
		// TODO Auto-generated method stub	
	}
}

// ShoeSeller------------------------------------------------------------------------------------------------
interface Seller{
	
}

interface ShoeSeller extends Seller{
	public Shoe sellShoe(Customer c,String shoeType) throws Exception;
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
	public Shoe sellShoe(Customer c,String shoeType) throws Exception{
		// TODO Auto-generated method stub
		return getSf().makeShoe(shoeType);
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
		System.out.println("Leather Shoe made by "+this.factoryName);
	}
}

class SportShoe extends Shoe{
	
	public SportShoe(String name) {
		super(name);
		System.out.println("Sports Shoe made by "+this.factoryName);
	}
}

class NoShoe extends Shoe{
	public NoShoe(String name) {
		super(name);
		System.out.println(this.factoryName + "Does not make this type of Shoe");
		// TODO Auto-generated constructor stub
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



