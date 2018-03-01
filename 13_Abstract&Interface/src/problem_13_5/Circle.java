package problem_13_5;

public class Circle extends GeometricObject{
	private double radius;
	public Circle(double radius) {
		this.radius = radius;
	}
	public double getArea() {
		// TODO Auto-generated method stub
		return (Math.PI) * (Math.pow(radius, 2));
	}
	public double getPerimeter() {
		// TODO Auto-generated method stub
		return (2)*(Math.PI)*(radius);
	}

}
