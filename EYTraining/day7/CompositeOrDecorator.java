package day7;

public class CompositeOrDecorator {
	public static void main(String[] args) {
		IceCream iceCream = new DryFruits(new Vanila()); 
		System.out.println(iceCream.cost());
	}
}


abstract class IceCream{
	public abstract int cost();
}

abstract class Ingridients extends IceCream{}

class Vanila extends IceCream{
	
	public IceCream iceCream;
	public Vanila() {
		
	}
	public Vanila(IceCream iceCream) {
		this.iceCream = iceCream;
	}
	@Override
	public int cost() {
		if(iceCream == null) {
			return 10;
		}
		else {
			return 10 + this.iceCream.cost(); 
		}
	}
}

class Strawberry extends IceCream{
	
	public IceCream iceCream;
	public Strawberry() {
		
	}
	public Strawberry(IceCream iceCream) {
		this.iceCream = iceCream;
	}
	@Override
	public int cost() {
		if(iceCream == null) {
			return 10;
		}
		else {
			return 10 + this.iceCream.cost(); 
		}
	}
}

class Nuts extends Ingridients{
	
	public IceCream iceCream;
	public Nuts(IceCream iceCream) {
		this.iceCream = iceCream;
	}
	@Override
	public int cost() {
		return 10 + this.iceCream.cost();
	}
}


class DryFruits extends Ingridients{
	
	public IceCream iceCream;
	public DryFruits(IceCream iceCream) {
		this.iceCream = iceCream;
	}
	@Override
	public int cost() {
		return 10 + this.iceCream.cost();
	}
}