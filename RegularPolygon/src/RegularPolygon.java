
public class RegularPolygon {
	//defaults
	private int nn = 3;
	private double nSide = 1, nx = 0, ny = 0;
	//constructors
	public RegularPolygon() {}
	public RegularPolygon(int n, double side) {
		this.nn = n;
		this.nSide = side;
	}
	public RegularPolygon(int n, double side, double x, double y) {
		this.nn =n;
		this.nSide = side;
		this.nx = x;
		this.ny = y;
	}
	//modify 
	public int getN() {return nn;}
	public void setN(int n) {nn = n;}
	public double getSide() {return nSide;}
	public void setSide(double side) {nSide = side;}
	public double getX() {return nx;}
	public void setX(int x) {nx = x;}
	public double getY() {return ny;}
	public void setY(int y) {ny = y;}
	// info
	public double getPerimeter() {
		return nn * nSide;
	}
	public double getArea() {
		return (nn * nSide * nSide) / (4.0 * Math.tan(Math.PI / nSide));
	}
}
