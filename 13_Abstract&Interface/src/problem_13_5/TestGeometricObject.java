package problem_13_5;

import static org.junit.Assert.fail;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.Test;

public class TestGeometricObject {

	String geometricObjectPath 	= "problem_13_5.GeometricObject";
	String circleObjectPath 	= "problem_13_5.Circle";
	String rectangleObjectPath 	= "problem_13_5.Rectangle";
	
	ClassLoader loader;
	Class<?> geo, circ, rect;
	
	@Before
	public void setup() {
		loader = this.getClass().getClassLoader();
		try {
			geo = loader.loadClass(geometricObjectPath);
			circ = loader.loadClass(circleObjectPath);
			rect = loader.loadClass(rectangleObjectPath);
		} catch (ClassNotFoundException ex) {
			fail("Before running tests, not able to load one or more of GeometricObject, Circle, and Rectangle.");
		}
	}
	
	@Test
	public void testImplementsComparableInterface() {
		Class<?>[] comparable = geo.getInterfaces();
		if(!comparable[0].toString().equals("interface java.lang.Comparable")) {
			fail("GeometricObject must implement the Comparable interface.");
		}
	}
	
	@Test
	public void testMethod_max() {
		try {
			Constructor<?> circleConstructor = circ.getDeclaredConstructor(double.class);
			Constructor<?> rectangleConstructor = rect.getDeclaredConstructor(double.class, double.class);
			Method max = geo.getDeclaredMethod("max", GeometricObject.class, GeometricObject.class);
			Object circle = circleConstructor.newInstance(3);			
			Object rectangle = rectangleConstructor.newInstance(3,4);			
			Object result = max.invoke(geo, rectangle, circle);
			
			if(result != circle) {
				fail("GeometricObject.max must return the object of largest area.");
			}
		} catch (Exception ex) {
			fail("Failed due to " + ex.getClass().getName());
		}
	}
}
