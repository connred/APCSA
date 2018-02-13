package problem_9_01;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.Test;

public class TestRectangle {
	
	ClassLoader loader;
	Class<?> rect;
	
	@Before
	public void setup() {
		loader = this.getClass().getClassLoader();
		try {
			rect = loader.loadClass("problem_9_01.Rectangle");
		} catch (ClassNotFoundException ex) {
			fail("Can't load the problem_9_01.Rectangle");
		}
	}

	@Test
	public void testFields() {
		boolean hasWidth = false;
		boolean hasHeight = false;

		Field[] fields = rect.getDeclaredFields();

		if(fields.length != 2) {
			fail("The Rectangle class has exactly 2 fields");
		} else {
			for(Field f : fields) {
				switch(f.getName()) {
				case "width":
					hasWidth = true;
					break;
				case "height":
					hasHeight = true;
					break;
				}
				if(!f.getType().toString().equals("double")) {
					fail("The width and height variables should be of type double");
				}
			}
			if(!hasWidth)
				fail("Rectangle.width is missing or incorrectly spelled");
			if(!hasHeight)
				fail("Rectangle.height is missing or incorrectly spelled");
		}
	}
	
	@Test
	public void testConstructors() {
		Constructor<?>[] constructors = rect.getDeclaredConstructors();
		
		if(constructors.length != 2) {
			fail("There should be two Rectangle constructors");
		} else {
			for(Constructor<?> c : constructors) {
				// one has width and height params
				if(c.getParameterCount() == 2) {
					Class<?>[] paramTypes = c.getParameterTypes();
					for(Class<?> cls : paramTypes) {
						if(!cls.getSimpleName().equals("double"))
							fail("The overloaded Rectangle constructor takes two double types");
					}
				}
				// one has none
			}
		}
	}
	
	@Test
	public void testMethods() {
		boolean hasPerimeter = false;
		boolean hasArea = false;
		
		Method[] methods = rect.getDeclaredMethods();
		if(methods.length != 2) {
			fail("There should be exactly 2 methods in the Rectangle class");
		} else {
			for(Method m : methods) {
				switch(m.getName()) {
				case "getPerimeter":
					hasPerimeter = true;
					break;
				case "getArea":
					hasArea = true;
					break;
				}
				if(m.getParameterCount() != 0)
					fail("Rectangle methods don't take parameters at this time");
			}
		}
		if(!(hasPerimeter && hasArea)) {
			fail("Missing paremter or area functions");
		}
	}
	
	@Test
	public void testGetArea() {
		try {
			// this test checks the default constructor
			Constructor<?> constructor = rect.getDeclaredConstructor();
			Object obj = constructor.newInstance();
			
			Field width = rect.getDeclaredField("width");
			Field height = rect.getDeclaredField("height");
			
			width.setDouble(obj, 6);
			height.setDouble(obj, 3);
			
			Method m = rect.getDeclaredMethod("getArea", new Class<?>[]{});
			Object result = m.invoke(obj, new Object[]{});
			
			assertEquals(18.0, (double)result, 0.00000001);
			
		} catch (NoSuchMethodException ex) {
			fail("Stock constructor is incorrect.");
		} catch (InvocationTargetException ex) {
			fail("A constructor or function couldn't be invoked");
		} catch (IllegalAccessException ex) {
			fail("You may be accessing fields which are set to private and should be public.");
		} catch (InstantiationException ex) {
			fail("Can't create a Stock object");
		} catch (NoSuchFieldException ex) {
			fail("Check your variable names");
		}
	}
	
	@Test
	public void testGetPerimeter() {
		try {
			// this test checks the overloaded constructor
			Constructor<?> constructor = rect.getDeclaredConstructor(double.class, double.class);
			Object obj = constructor.newInstance(5, 5);
			
			Method m = rect.getDeclaredMethod("getPerimeter", new Class<?>[]{});
			Object result = m.invoke(obj, new Object[]{});
			
			assertEquals(20.0, (double)result, 0.00000001);
			
		} catch (NoSuchMethodException ex) {
			fail("Stock constructor is incorrect.");
		} catch (InvocationTargetException ex) {
			fail("A constructor or function couldn't be invoked");
		} catch (IllegalAccessException ex) {
			fail("Stock constructor isn't accessible");
		} catch (InstantiationException ex) {
			fail("Can't create a Stock object");
		}
	}			
}
