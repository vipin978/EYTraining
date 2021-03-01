package day10;

public class PrtOrClnForDecorator {
	public static void main(String[] args) throws Exception {
		Vanila ven = new Vanila();
		DryFruits dry = new DryFruits();
		IceCream iceCream = dry.getCloneObjParam(ven.getCloneObj()); 
		System.out.println(iceCream.cost());
	}
}


class CompositeOrDecorator {
	
}


abstract class IceCream implements Cloneable{
	public abstract int cost();
	public abstract IceCream getCloneObj() throws Exception;
	public abstract IceCream getCloneObjParam(IceCream ice) throws Exception;
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
	
	@Override
	public IceCream getCloneObj() throws Exception {
		IceCream cloned = (IceCream)super.clone();
		return cloned;
	}
	
	@Override
	public IceCream getCloneObjParam(IceCream ice) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}

class Strawberry extends IceCream {
	
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
	@Override
	public IceCream getCloneObj() throws Exception {
		// TODO Auto-generated method stub
		return (IceCream)super.clone();
	}
	@Override
	public IceCream getCloneObjParam(IceCream ice) throws Exception {
		// TODO Auto-generated method stub
		return null;
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
	@Override
	public IceCream getCloneObj() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public IceCream getCloneObjParam(IceCream ice) throws Exception {
		Nuts cloned = (Nuts)super.clone();
		cloned.iceCream = ice;
		return cloned;
	}
}


class DryFruits extends Ingridients{
	
	public DryFruits() {
		// TODO Auto-generated constructor stub
	}
	public IceCream iceCream;
	public DryFruits(IceCream iceCream) {
		this.iceCream = iceCream;
	}
	@Override
	public int cost() {
		return 10 + this.iceCream.cost();
	}
@Override
	public IceCream getCloneObj() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public IceCream getCloneObjParam(IceCream ice) throws Exception {
		DryFruits cloned = (DryFruits)super.clone();
		cloned.iceCream = ice;
		return cloned;
	}
}