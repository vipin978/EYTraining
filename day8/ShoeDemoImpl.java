package day8;

public class ShoeDemoImpl {
	public static void main(String[] args)throws Exception {
		ShoeShop sf = Container.getShoeShop();
		sf.sellShoe(new ShoeCustomer("ramu"),"SportShoe");
	}
}


class Container{
	public static ShoeShop getShoeShop() throws Exception{
		ShoeFactory sf = new ShoeFactoryBuilder().setLeatherShoe(true).setSportShoe(true).build("day8.BataShoeFactory");
		ShoeShop ss = new GokulShoeShop();
		ss.setSf(sf);
		return ss;
	}
}