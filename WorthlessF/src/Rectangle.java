import java.util.*;
import java.math.*;
public class Rectangle {	
	private double l = 1;
	private double w = 1;
	public Rectangle() {}
	public Rectangle(double l, double w) {
		this.l = l;
		this.w = w;
	}
	public double getArea() {
		double a = l * w;
		return a;	
	}
	public double getPerimeter() {
		double p = (2* l) + (2*w);
		return p;
	}
	
}

