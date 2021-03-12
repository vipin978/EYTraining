package day9;

public class Q24 {
	public static void main(String[] args) {
		Square sq = new Square(4);
		System.out.println("Area : "+sq.area()+" Perimeter : "+sq.perimeter());
	}
}

class Square{
	public int sideLength;
	public Square(int sideLenght) {
		this.sideLength = sideLenght;
	}
	public int area() {
		return sideLength * sideLength;
	}
	public int perimeter() {
		return 4 * sideLength;
	}
}