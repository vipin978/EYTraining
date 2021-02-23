package day6;

public class PizzaProblem {
	public static void main(String[] args) {
		
	}
}

abstract class Dominoz{
	final public void selectFlour(){
		System.out.println("Flour selected by Dominoz");
	}
	
	final public void selectIngridiens() {
		System.out.println("Ingridiens selected by Dominoz");
	}
	
	final public void pizzaBox() {
		System.out.println("Made by Dominoz");
	}
	
	public abstract void cook();
	public abstract void deliver();
}


class DominozSulurBranch extends Dominoz{
	@Override
	public void cook() {
		selectFlour();
		selectIngridiens();
		System.out.println("Cooking");
	}
	
	@Override
	public void deliver() {
		pizzaBox();
		System.out.println("The package will be delivered to the customer");
	}
}