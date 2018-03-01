package problem_13_1;

public class Triangle extends GeometricObject{
	private double side1;
	private double side2;
	private double side3;
	public Triangle(double side1, double side2, double side3) {
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}
	public Triangle(double side1, double side2, double side3, String color, boolean filled) {
		super(color, filled);
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;	
	}
	public boolean isValid() {
		if ((side1 + side2) > side3 && (side1 + side3) > side2 && (side2 + side3) > side1) {
			return true;
		} else {
			return false;	
		}
	}
	public String toString() {
		if (isValid() == true) {
			return "Triangle: Area = " + getArea() + ", Color = " + getColor() + ", Filled = " + isFilled() + "";
		} else {
			return "Fails the Triangle Inequality Theorem.";
		}
		
	}
	public double getArea() {
		double s = (side1 + side2 +side3 ) / 2;
		return Math.sqrt(s*(s-side1)*(s-side2)*(s-side3));
	}
	public double getPerimeter() {
		return side1 + side2 + side3;
	}
	

}
