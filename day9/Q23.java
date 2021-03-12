package day9;

public class Q23 {
	
	public static void main(String[] args) {
		Equations eq = new Equations();
		System.out.println(eq.area() + " " + eq.energy());
	}
	
	
}

class Equations{
	public float area() {
		float pi = 3.14f;
		float r = 3;
		float h = 4;
		
		return (pi* r * r) + 2 * (pi*r*h); 
		
	}
	
	public float energy() {
		float mass = 4;
		float acc = 3;
		float height = 8;
		float velocity = 3;
		return 	mass*(acc * height + (velocity*velocity)/2);
	}
}