package day8;

public class Q15 {
	public static void main(String[] args) {
		Door d = new Door();
		Window w = new Window();
		House h = new House(d,w);
		h.provideCost();
		System.out.println(d.cost+"  "+ w.cost);
	}
}

class House{
	public int areaOfConstructingDoor = 100;
	public int areaOfConstructingWindow = 400;
	Door d;
	Window w;
	public House(Door d,Window w) {
		this.d = d;
		this.w = w;
	}
	
	
	public void provideCost() {
		d.cost = areaOfConstructingDoor * 2;
		w.cost = areaOfConstructingWindow * 3;
	}
}

class Door{
	public int cost; 
	
}

class Window{
	public int cost;
	
}
