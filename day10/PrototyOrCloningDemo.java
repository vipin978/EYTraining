package day10;

public class PrototyOrCloningDemo {
	public static void main(String[] args) throws Exception {
		Sheep sh = new Sheep();
		sh.i = 5;
		Sheep sh2 = sh.getClone();
		System.out.println(sh.i + "  " + sh2.i);
	}
}


class Sheep implements Cloneable{
	public int i;
	Sheep(){
		System.out.println("Sprrr");
	}
	public Sheep getClone() throws Exception {
		return (Sheep)super.clone();
	}
}