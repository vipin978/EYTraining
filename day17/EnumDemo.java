package day17;

public class EnumDemo {
	public static void main(String[] args) {
		Colors c = Colors.GREEN;
		System.out.println(c);
	}
}


enum Colors{
	RED("1"),BLUE("2"),GREEN("3");
	String color;
	private Colors(String colors) {
		this.color = colors;
	}
}
