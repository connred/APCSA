
public class Main {
	public static void main(String[] args) {
		Rectangle one = new Rectangle();
		Rectangle two = new Rectangle(5,5);
		Rectangle three = new Rectangle(10,50);
		
		System.out.println(one.getArea());
		System.out.println(one.getPerimeter());
		
		
		System.out.println(two.getArea());
		System.out.println(two.getPerimeter());
		
		System.out.println(three.getArea());
		System.out.println(three.getPerimeter());
		
		
	}
}
