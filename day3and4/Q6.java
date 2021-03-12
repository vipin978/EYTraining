package day3and4;

public class Q6 {

}


class Base{
	public int i;
	public Base() {
		this.i = 1/0;
	}
}


// this is not possible since super() statement should be the first statement
class Derived extends Base{
	public Derived() {
		try {
		super();
		}
		
	}
}