package problem_13_1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.Before;
import org.junit.Test;

public class TestTriangle {
	
	String classPath = "problem_13_1.Triangle";
	String geometricObjectPath = "problem_13_1.GeometricObject";
	
	ClassLoader loader;
	Class<?> cls;
	Class<?> geo;
	
	@Before
	public void doesTriangleClassExist() {
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
	public void testHasThreeVariables() {
		Field[] fields = cls.getDeclaredFields();
		if(fields.length != 3) {
			fail("The Triangle class has exactly 3 declared fields: side1, side2, side3");
		}
	}
	
	@Test
	public void testNoStaticVariables() {
		Field[] fields = cls.getDeclaredFields();
		for(Field f : fields) {
			if(Modifier.isStatic(f.getModifiers()))
				fail("Triangle has no static variables.");
		}
	}
	
	@Test
	public void testVariableDataTypes() {
		try {
			Field side1 = cls.getDeclaredField("side1");
			Field side2 = cls.getDeclaredField("side2");
			Field side3 = cls.getDeclaredField("side3");
			boolean isDoubleSide1 = side1.getType().toString().equals("double");
			boolean isDoubleSide2 = side2.getType().toString().equals("double");
			boolean isDoubleSide3 = side3.getType().toString().equals("double");
			if(!(isDoubleSide1 && isDoubleSide2 && isDoubleSide3)) {
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
			Field side3 = cls.getDeclaredField("side3");
			if(!Modifier.isPrivate(side1.getModifiers()))
				fail("side1 should be private.");
			if(!Modifier.isPrivate(side2.getModifiers()))
				fail("side2 should be private.");
			if(!Modifier.isPrivate(side3.getModifiers()))
				fail("side3 should be private.");
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
	public void testVariable_side3() {
		try {
			Field side3 = cls.getDeclaredField("side3");
			if(!Modifier.isPrivate(side3.getModifiers())) { 
				fail("side3 should be private");
			}
			if(!side3.getType().toString().equals("double")) {
				fail("side3 should be double type");
			}
		} catch(NoSuchFieldException ex) {
			fail("side3 variable not declared");
		}
	}
	
	@Test
	public void testInheritance() {
		// Triangle (cls) inherits GeometricObject (geo)
		if(!geo.isAssignableFrom(cls)) {
			fail("Triangle must inherit GeometricObject.");
		}
	}
	
	@SuppressWarnings("unused")
	@Test
	public void testNoDefaultConstructor() {
		try {
			Constructor<?> constructor = cls.getDeclaredConstructor();
			fail("Triangle has no default constructor.");
		} catch (NoSuchMethodException ex) {
			// test passes - Triangle has no default constructor
		}
	}
	
	@Test
	public void testHasTwoConstructors() {
		Constructor<?>[] constructors = cls.getDeclaredConstructors();
		if(constructors.length != 2) {
			fail("There should be two constructors.");
		}
	}
	
	@SuppressWarnings("unused")
	@Test
	public void testConstructor_hasThreeParams() {
		try {
			Constructor<?> constructor = cls.getDeclaredConstructor(double.class, double.class, double.class);
		} catch (NoSuchMethodException ex) {
			fail("Constructor signed `Triangle(double, double, double)` is missing.");
		}
	}
	
	@SuppressWarnings("unused")
	@Test
	public void testConstructor_hasFiveParams() {
		try {
			Constructor<?> constructor = cls.getDeclaredConstructor(double.class, double.class, double.class, String.class, boolean.class);
		} catch (NoSuchMethodException ex) {
			fail("Constructor signed `Triangle(double, double, double, String, boolean)` is missing.");
		}		
	}
	
	@Test
	public void testHasFourMethods() {
		Method[] methods = cls.getDeclaredMethods();
		if(methods.length != 4) {
			fail("Triangle has exactly four methods.");
		}
	}
	
	@Test
	public void testNoStaticMethods() {
		Method[] methods = cls.getDeclaredMethods();
		for(Method m : methods) {
			if(Modifier.isStatic(m.getModifiers()))
				fail("Triangle has no static methods.");
		}
	}
	
	@Test
	public void testMethod_getArea() {
		try {
			Constructor<?> constructor = cls.getDeclaredConstructor(double.class, double.class, double.class);
			Object triangle = constructor.newInstance(3,4,5);
			Method getArea = cls.getDeclaredMethod("getArea", new Class<?>[]{});
			Object result = getArea.invoke(triangle, new Object[]{});
			assertEquals(6.0, (double)result, 0.0);
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
			Constructor<?> constructor = cls.getDeclaredConstructor(double.class, double.class, double.class);
			Object triangle = constructor.newInstance(3,4,5);
			Method getPerimeter = cls.getDeclaredMethod("getPerimeter", new Class<?>[]{});
			Object result = getPerimeter.invoke(triangle, new Object[]{});
			assertEquals(12.0, (double)result, 0.0);
			if(getPerimeter.getParameterCount() != 0)
				fail("getPerimeter() has no parameters.");
			if(!getPerimeter.getReturnType().toString().equals("double"))
				fail("getPerimeter() returns double.");
		} catch (Exception ex) {
			fail("Failed due to " + ex.getClass().getName());
		}
	}
	
	@Test
	public void testMethod_isValid() {
		try {
			// valid triangle
			Constructor<?> constructor = cls.getDeclaredConstructor(double.class, double.class, double.class);
			Object triangle1 = constructor.newInstance(3,4,5);
			Method isValid = cls.getDeclaredMethod("isValid", new Class<?>[]{});
			Object result = isValid.invoke(triangle1, new Object[]{});
			assertEquals(true, (boolean)result);
			// invalid triangle
			Object triangle2 = constructor.newInstance(10,20,30);
			result = isValid.invoke(triangle2, new Object[]{});
			assertEquals(false, (boolean)result);
			if(isValid.getParameterCount() != 0)
				fail("isValid() has no parameters.");
			if(!isValid.getReturnType().toString().equals("boolean"))
				fail("isValid() returns boolean.");
		} catch (Exception ex) {
			fail("Failed due to " + ex.getClass().getName());
		}
	}
	
	@Test
	public void testMethod_toString() {
		try {
			// valid triangle, default color, no fill
			Constructor<?> constructor = cls.getDeclaredConstructor(double.class, double.class, double.class);
			Object triangle1 = constructor.newInstance(3,4,5);
			Method toString = cls.getDeclaredMethod("toString", new Class<?>[]{});
			Object result = toString.invoke(triangle1, new Object[]{});
			assertEquals("Triangle: Area = 6.0, Color = white, Filled = false", (String)result);
			// invalid triangle
			Object triangle2 = constructor.newInstance(1,2,3);
			result = toString.invoke(triangle2, new Object[]{});
			assertEquals("Fails the Triangle Inequality Theorem.", (String)result);
			// filled with color
			Constructor<?> constructor2 = cls.getDeclaredConstructor(double.class, double.class, double.class, String.class, boolean.class);
			Object triangle3 = constructor2.newInstance(3,4,5,"Blue",true);
			result = toString.invoke(triangle3, new Object[]{});
			assertEquals("Triangle: Area = 6.0, Color = Blue, Filled = true", (String)result);
			if(toString.getParameterCount() != 0)
				fail("toString() has no parameters.");
			if(!toString.getReturnType().toString().equals("class java.lang.String"))
				fail("toString() returns type String");
		} catch (Exception ex) {
			fail("Failed due to " + ex.getClass().getName());
		}
	}
	
	@Test
	public void testInheritedMethod_isFilled() {
		try {
			// not filled
			Constructor<?> constructor1 = cls.getDeclaredConstructor(double.class, double.class, double.class);
			Object triangle1 = constructor1.newInstance(3,4,5);
			Method isFilled = geo.getDeclaredMethod("isFilled", new Class<?>[]{});
			Object result = isFilled.invoke(triangle1, new Object[]{});
			assertEquals(false, (boolean)result);
			// filled
			Constructor<?> constructor2 = cls.getDeclaredConstructor(double.class, double.class, double.class, String.class, boolean.class);
			Object triangle2 = constructor2.newInstance(3,4,5,"Blue",true);
			result = isFilled.invoke(triangle2, new Object[]{});
			assertEquals(true, (boolean)result);
		} catch (Exception ex) {
			fail("Failed due to " + ex.getClass().getName());
		}
	}
	
	@Test
	public void testInheritedMethod_getColor() {
		try {
			// not filled
			Constructor<?> constructor1 = cls.getDeclaredConstructor(double.class, double.class, double.class);
			Object triangle1 = constructor1.newInstance(3,4,5);
			Method getColor = geo.getDeclaredMethod("getColor", new Class<?>[]{});
			Object result = getColor.invoke(triangle1, new Object[]{});
			assertEquals("white", (String)result);
			// filled
			Constructor<?> constructor2 = cls.getDeclaredConstructor(double.class, double.class, double.class, String.class, boolean.class);
			Object triangle2 = constructor2.newInstance(3,4,5,"blue",true);
			result = getColor.invoke(triangle2, new Object[]{});
			assertEquals("blue", (String)result);
		} catch (Exception ex) {
			fail("Failed due to " + ex.getClass().getName());
		}
	}
}
