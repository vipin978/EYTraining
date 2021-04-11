package springW1;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;


public class Triangle implements BeanNameAware{
	
	Point pointA;
	Point pointB;
	Point pointC;

	@Override
	public void setBeanName(String arg0) {
		System.out.println("Bean Name is "+arg0);
	}
	
	public Point getPointA() {
		return pointA;
	}



	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}



	public Point getPointB() {
		return pointB;
	}



	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}



	public Point getPointC() {
		return pointC;
	}



	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}



	public void draw() {
		System.out.println(pointA);
		System.out.println(pointB);
		System.out.println(pointC);
	}
	
//	public void init() {
//		System.out.println("init method called");
//	}
//	
//	public void cleanUp() {
//		System.out.println("Clean up method called");
//	}
}

//public class Triangle implements BeanNameAware,InitializingBean,DisposableBean{
//	
//	Point pointA;
//	Point pointB;
//	Point pointC;
//
//	@Override
//	public void setBeanName(String arg0) {
//		System.out.println("Bean Name is "+arg0);
//	}
//	
//	public Point getPointA() {
//		return pointA;
//	}
//
//
//
//	public void setPointA(Point pointA) {
//		this.pointA = pointA;
//	}
//
//
//
//	public Point getPointB() {
//		return pointB;
//	}
//
//
//
//	public void setPointB(Point pointB) {
//		this.pointB = pointB;
//	}
//
//
//
//	public Point getPointC() {
//		return pointC;
//	}
//
//
//
//	public void setPointC(Point pointC) {
//		this.pointC = pointC;
//	}
//
//
//
//	public void draw() {
//		System.out.println(pointA);
//		System.out.println(pointB);
//		System.out.println(pointC);
//	}
//
//	@Override
//	public void destroy() throws Exception {
//		System.out.println("Destroy method called");
//	}
//
//	@Override
//	public void afterPropertiesSet() throws Exception {
//		System.out.println("init method called");
//	}
//	
//	
//	
//}

//public class Triangle {
//	
//	List<Point> points = new ArrayList<Point>();
//
//	
//	public List<Point> getPoints() {
//		return points;
//	}
//
//
//	public void setPoints(List<Point> points) {
//		this.points = points;
//	}
//
//
//	public void draw() {
//		for(Point p:points) {
//			System.out.println("Point : " +p);
//		}
//	}
//	
//}
