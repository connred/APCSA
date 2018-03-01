package problem_13_5;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.Before;
import org.junit.Test;

public class TestCircle {
	
	String classPath = "problem_13_5.Circle";
	String geometricObjectPath = "problem_13_5.GeometricObject";
	
	ClassLoader loader;
	Class<?> cls;
	Class<?> geo;
	
	@Before
	public void doesCircleClassExist() {
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
	public void testHasOneVariables() {
		Field[] fields = cls.getDeclaredFields();
		if(fields.length != 1) {
			fail("The Circle class has exactly 2 declared fields: radius, side2");
		}
	}
	
	@Test
	public void testNoStaticVariables() {
		Field[] fields = cls.getDeclaredFields();
		for(Field f : fields) {
			if(Modifier.isStatic(f.getModifiers()))
				fail("Circle has no static variables.");
		}
	}
	
	@Test
	public void testVariableDataTypes() {
		try {
			Field radius = cls.getDeclaredField("radius");
			boolean isDoubleradius = radius.getType().toString().equals("double");
			if(!(isDoubleradius)) {
				fail("The side variables should all be of type double.");
			}
		} catch (NoSuchFieldException ex) {
			fail("One of the side variables is missing or incorrectly named.");
		}
	}
	
	@Test
	public void testVariablesArePrivate() {
		try {
			Field radius = cls.getDeclaredField("radius");
			if(!Modifier.isPrivate(radius.getModifiers()))
				fail("radius should be private.");
		} catch (NoSuchFieldException ex) {
			fail("One of the side variables is missing or incorrectly named.");
		}
	}
	
	@Test
	public void testVariable_radius() {
		try {
			Field radius = cls.getDeclaredField("radius");
			if(!Modifier.isPrivate(radius.getModifiers())) { 
				fail("radius should be private");
			}
			if(!radius.getType().toString().equals("double")) {
				fail("radius should be double type");
			}
		} catch(NoSuchFieldException ex) {
			fail("radius variable not declared");
		}
	}
	
	@Test
	public void testInheritance() {
		// Circle (cls) inherits GeometricObject (geo)
		if(!geo.isAssignableFrom(cls)) {
			fail("Circle must inherit GeometricObject.");
		}
	}
	
	@SuppressWarnings("unused")
	@Test
	public void testNoDefaultConstructor() {
		try {
			Constructor<?> constructor = cls.getDeclaredConstructor();
			fail("Circle has no default constructor.");
		} catch (NoSuchMethodException ex) {
			// test passes - Triangle has no default constructor
		}
	}
	
	@SuppressWarnings("unused")
	@Test
	public void testConstructor_hasOneParam() {
		try {
			Constructor<?> constructor = cls.getDeclaredConstructor(double.class);
		} catch (NoSuchMethodException ex) {
			fail("Constructor signed `Circle(double)` is missing.");
		}
	}
	
	@Test
	public void testHasTwoMethods() {
		Method[] methods = cls.getDeclaredMethods();
		if(methods.length != 2) {
			fail("Circle has exactly two methods: getArea() and getPerimeter().");
		}
	}
	
	@Test
	public void testNoStaticMethods() {
		Method[] methods = cls.getDeclaredMethods();
		for(Method m : methods) {
			if(Modifier.isStatic(m.getModifiers()))
				fail("Circle has no static methods.");
		}
	}
	
	@Test
	public void testMethod_getArea() {
		try {
			Constructor<?> constructor = cls.getDeclaredConstructor(double.class);
			Object obj = constructor.newInstance(3);
			Method getArea = cls.getDeclaredMethod("getArea", new Class<?>[]{});
			Object result = getArea.invoke(obj, new Object[]{});
			assertEquals(28.274333882308138, (double)result, 0.1);
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
			Constructor<?> constructor = cls.getDeclaredConstructor(double.class);
			Object obj = constructor.newInstance(3);
			Method getPerimeter = cls.getDeclaredMethod("getPerimeter", new Class<?>[]{});
			Object result = getPerimeter.invoke(obj, new Object[]{});
			assertEquals(18.84955592153876, (double)result, 0.1);
			if(getPerimeter.getParameterCount() != 0)
				fail("getPerimeter() has no parameters.");
			if(!getPerimeter.getReturnType().toString().equals("double"))
				fail("getPerimeter() returns double.");
		} catch (Exception ex) {
			fail("Failed due to " + ex.getClass().getName());
		}
	}
}
