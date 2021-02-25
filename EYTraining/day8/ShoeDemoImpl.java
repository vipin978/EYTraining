package day8;

public class ShoeDemoImpl {
	public static void main(String[] args) {
		ShoeShop sf = Container.getShoeShop();
		sf.sellShoe(new ShoeCustomer("ramu"));
	}
}


class Container{
	public static ShoeShop getShoeShop() {
		ShoeFactory sf = new BataShoeFactory();
		ShoeShop ss = new GokulShoeShop(sf);
		return ss;
	}
}