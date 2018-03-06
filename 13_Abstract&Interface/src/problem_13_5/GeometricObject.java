package problem_13_5;

public abstract class GeometricObject implements Comparable {
	private String color = "white";
	private boolean filled;
	private java.util.Date dateCreated;

	protected GeometricObject() {
		dateCreated = new java.util.Date();
	}

	protected GeometricObject(String color, boolean filled) {
		dateCreated = new java.util.Date();
		this.color = color;
		this.filled = filled;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isFilled() {
		return filled;
	}

	public java.util.Date getDateCreated() {
		return dateCreated;
	}

	@Override
	public String toString() {
		return "created on " + dateCreated + "\ncolor: " + color + " and filled: " + filled;
	}

	public abstract double getArea();

	public abstract double getPerimeter();

	public static GeometricObject max(GeometricObject a, GeometricObject b) {
		if (a.getArea() > b.getArea() && a.getPerimeter() > b.getPerimeter()) {
			return a;
		} else if (a.getArea() < b.getArea() && a.getPerimeter() < b.getPerimeter()) {
			return b;
		} else {
			return null;
		}
	}
	
	@Override
	public int compareTo(Object o) {
		if(((GeometricObject) o).getArea() > this.getArea()){
			return 1;
		} else if (((GeometricObject) o).getArea() < this.getArea()) {
			return -1;
		} else {
			return 0;
		}
		
	}

}