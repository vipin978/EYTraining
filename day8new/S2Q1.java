package day8;

public class S2Q1 {
	public static void main(String[] args) {
		TwoD d = new Circle(3);
		Calculate c = new Calculate();
		c.calcArea(d);
	}
}

interface Figures {
	public void calcArea(TwoD d);
	public void calacVolume(ThreeD d);
}

class Calculate implements Figures{
	@Override
	public void calcArea(TwoD d) {
		System.out.println(d.area());	
	}
	@Override
	public void calacVolume(ThreeD d) {
		// TODO Auto-generated method stub
		
	}
}

abstract class TwoD{
	public abstract float area();
	public abstract float perimeter();
}

abstract class ThreeD{
	
}

class Sq extends TwoD{	
	public float a;
	public Sq(float a) {
		super();
		this.a = a;
	}
	@Override
	public float area() {
		// TODO Auto-generated method stub
		return a*a;
	}
	@Override
	public float perimeter() {
		// TODO Auto-generated method stub
		return 4*a;
	}
}

class Triangle extends TwoD{	
	
	public float s1,s2,s3,h;
	public Triangle(float s1, float s2, float s3, float h) {
		super();
		this.s1 = s1;
		this.s2 = s2;
		this.s3 = s3;
		this.h = h;
	}
	@Override
	public float area() {
		// TODO Auto-generated method stub
		return (s2*h) * 0.5f;
	}
	@Override
	public float perimeter() {
		// TODO Auto-generated method stub
		return s1 + s2 + s3;
	}
}

class Circle extends TwoD{	
	
	public float pi = 3.14f;
	public float r;
	
	Circle(float r){
		super();
		this.r = r;
	}
	@Override
	public float area() {
		// TODO Auto-generated method stub
		return pi * r * r;
	}
	@Override
	public float perimeter() {
		// TODO Auto-generated method stub
		return 2 * pi * r;
	}
}

