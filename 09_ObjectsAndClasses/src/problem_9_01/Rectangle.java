package problem_9_01;

class Rectangle {
	double width = 1, height = 1;
	
	Rectangle() {
		
	}
	
	Rectangle(double w, double h) {
		width = w;
		height = h;
	}
	
	double getArea() {
		return width * height;
	}
	
	double getPerimeter() {
		return width * 2 + height * 2;
	}
}
