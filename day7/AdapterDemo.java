package day7;

public class AdapterDemo {
	public static void main(String[] args) {
		IndianSocket is = new JaiElectronics();
		IndianPlug ip = new IndianAdapter(new JasElectronics());
		is.roundPinHole(ip);
	}
}

class IndianAdapter extends IndianPlug{
	
	AmericanPlug ap;
	public IndianAdapter(AmericanPlug ap){
		this.ap = ap;
	}
	@Override
	public void roundPin() {
		ap.slabPin();
	}
}

abstract class IndianPlug{
	public abstract void roundPin();
}

abstract class IndianSocket{
	public abstract void roundPinHole(IndianPlug ip);
}
abstract class AmericanPlug{
	public abstract void slabPin();
}

abstract class AmericanSocket{
	public abstract void slabpinHole();
}

class JaiElectronics extends IndianSocket{
	@Override
	public void roundPinHole(IndianPlug ip) {
			ip.roundPin();
	}
}

class JasElectronics extends AmericanPlug{
	@Override
	public void slabPin() {
		System.out.println("Slab pin working");
	}
}