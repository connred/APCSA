package problem_13_5;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.Before;
import org.junit.Test;

public class TestRectangle {
	
	String classPath = "problem_13_5.Rectangle";
	String geometricObjectPath = "problem_13_5.GeometricObject";
	
	ClassLoader loader;
	Class<?> cls;
	Class<?> geo;
	
	@Before
	public void doesRectangleClassExist() {
		loader = this.getClass().getClassLoader();
		try {
			cls = loader.loadClass(classPath);
		} catch (ClassNotFoundException ex) {
			fail("Before running tests, can't load " + classPath);
		}
		try {
			geo = loader.loadClass(geometricObjectPath);
		} catch (ClassNotFoundException ex) {
			fail("Before running tests, can't load " + geometricObjectPath);
		}
	}
	
	@Test
	public void testHasTwoVariables() {
		Field[] fields = cls.getDeclaredFields();
		if(fields.length != 2) {
			fail("The Rectangle class has exactly 2 declared fields: side1, side2");
		}
	}
	
	@Test
	public void testNoStaticVariables() {
		Field[] fields = cls.getDeclaredFields();
		for(Field f : fields) {
			if(Modifier.isStatic(f.getModifiers()))
				fail("Rectangle has no static variables.");
		}
	}
	
	@Test
	public void testVariableDataTypes() {
		try {
			Field side1 = cls.getDeclaredField("side1");
			Field side2 = cls.getDeclaredField("side2");
			boolean isDoubleSide1 = side1.getType().toString().equals("double");
			boolean isDoubleSide2 = side2.getType().toString().equals("double");
			if(!(isDoubleSide1 && isDoubleSide2)) {
				fail("The side variables should all be of type double.");
			}
		} catch (NoSuchFieldException ex) {
			fail("One of the side variables is missing or incorrectly named.");
		}
	}
	
	@Test
	public void testVariablesArePrivate() {
		try {
			Field side1 = cls.getDeclaredField("side1");
			Field side2 = cls.getDeclaredField("side2");
			if(!Modifier.isPrivate(side1.getModifiers()))
				fail("side1 should be private.");
			if(!Modifier.isPrivate(side2.getModifiers()))
				fail("side2 should be private.");
		} catch (NoSuchFieldException ex) {
			fail("One of the side variables is missing or incorrectly named.");
		}
	}
	
	@Test
	public void testVariable_side1() {
		try {
			Field side1 = cls.getDeclaredField("side1");
			if(!Modifier.isPrivate(side1.getModifiers())) { 
				fail("side1 should be private");
			}
			if(!side1.getType().toString().equals("double")) {
				fail("side1 should be double type");
			}
		} catch(NoSuchFieldException ex) {
			fail("side1 variable not declared");
		}
	}
	
	@Test
	public void testVariable_side2() {
		try {
			Field side2 = cls.getDeclaredField("side2");
			if(!Modifier.isPrivate(side2.getModifiers())) { 
				fail("side2 should be private");
			}
			if(!side2.getType().toString().equals("double")) {
				fail("side2 should be double type");
			}
		} catch(NoSuchFieldException ex) {
			fail("side2 variable not declared");
		}
	}
	
	@Test
	public void testInheritance() {
		// Rectangle (cls) inherits GeometricObject (geo)
		if(!geo.isAssignableFrom(cls)) {
			fail("Rectangle must inherit GeometricObject.");
		}
	}
	
	@SuppressWarnings("unused")
	@Test
	public void testNoDefaultConstructor() {
		try {
			Constructor<?> constructor = cls.getDeclaredConstructor();
			fail("Rectangle has no default constructor.");
		} catch (NoSuchMethodException ex) {
			// test passes - Triangle has no default constructor
		}
	}
	
	@SuppressWarnings("unused")
	@Test
	public void testConstructor_hasTwoParams() {
		try {
			Constructor<?> constructor = cls.getDeclaredConstructor(double.class, double.class);
		} catch (NoSuchMethodException ex) {
			fail("Constructor signed `Rectangle(double, double)` is missing.");
		}
	}
	
	@Test
	public void testHasTwoMethods() {
		Method[] methods = cls.getDeclaredMethods();
		if(methods.length != 2) {
			fail("Rectangle has exactly two methods: getArea() and getPerimeter().");
		}
	}
	
	@Test
	public void testNoStaticMethods() {
		Method[] methods = cls.getDeclaredMethods();
		for(Method m : methods) {
			if(Modifier.isStatic(m.getModifiers()))
				fail("Rectangle has no static methods.");
		}
	}
	
	@Test
	public void testMethod_getArea() {
		try {
			Constructor<?> constructor = cls.getDeclaredConstructor(double.class, double.class);
			Object obj = constructor.newInstance(3,4);
			Method getArea = cls.getDeclaredMethod("getArea", new Class<?>[]{});
			Object result = getArea.invoke(obj, new Object[]{});
			assertEquals(12.0, (double)result, 0.0);
			if(getArea.getParameterCount() != 0)
				fail("getArea() has no parameters.");
			if(!getArea.getReturnType().toString().equals("double"))
				fail("getArea() returns double.");
		} catch (Exception ex) {
			fail("Failed due to " + ex.getClass().getName());
		}
	}
	
	@Test
	public void testMethod_getPerimeter() {
		try {
			Constructor<?> constructor = cls.getDeclaredConstructor(double.class, double.class);
			Object obj = constructor.newInstance(3,4);
			Method getPerimeter = cls.getDeclaredMethod("getPerimeter", new Class<?>[]{});
			Object result = getPerimeter.invoke(obj, new Object[]{});
			assertEquals(14.0, (double)result, 0.0);
			if(getPerimeter.getParameterCount() != 0)
				fail("getPerimeter() has no parameters.");
			if(!getPerimeter.getReturnType().toString().equals("double"))
				fail("getPerimeter() returns double.");
		} catch (Exception ex) {
			fail("Failed due to " + ex.getClass().getName());
		}
	}
}
