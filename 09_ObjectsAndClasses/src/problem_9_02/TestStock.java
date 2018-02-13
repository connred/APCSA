package problem_9_02;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.Test;

public class TestStock {
	
	ClassLoader loader;
	Class<?> cls;
	
	@Before
	public void setup() {
		loader = this.getClass().getClassLoader();
		try {
			cls = loader.loadClass("problem_9_02.Stock");
		} catch (ClassNotFoundException ex) {
			fail("Can't load the problem_9_02.Stock");
		}
	}
	
	@Test
	public void testFields() {
		
		boolean hasSymbol = false;
		boolean hasName = false;
		boolean hasPrevious = false;
		boolean hasCurrent = false;
		int numStringFields = 0;
		int numDoubleFields = 0;
		
		Field[] fields =  cls.getDeclaredFields();
		
		if(fields.length != 4) {
			fail("The Stock class should declare exactly 4 variables");
		} else {
			for(Field f : fields) {
				if(f.getType().toString().equals("class java.lang.String"))
					numStringFields++;
				else if(f.getType().toString().equals("double"))
					numDoubleFields++;
				
				switch(f.getName()) {
				case "symbol":
					hasSymbol = true;
					break;
				case "name":
					hasName = true;
					break;
				case "previousClosingPrice":
					hasPrevious = true;
					break;
				case "currentPrice":
					hasCurrent = true;
					break;
				}
			}
			assertEquals(2, numStringFields);
			assertEquals(2, numDoubleFields);
			if(!(hasSymbol && hasName && hasPrevious && hasCurrent))
				fail("At least one of the variables is incorrectly named or is completely missing");
		}
	}

	@Test
	public void testConstructors() {
		Constructor<?>[] constructors = cls.getDeclaredConstructors();
		
		if(constructors.length != 1) {
			fail("There should be only one parameterized constructor. Did you implement a default?");
		} else {
			Class<?>[] pTypes = constructors[0].getParameterTypes();
			if(pTypes.length != 2) {
				fail("There should only be two constructor parameters");
			} else {
				for(Class<?> c : pTypes) {
					if(!c.getSimpleName().equals("String")) {
						fail("The constructor parameters are not String types");
					}
				}
			}
		}
	}
	
	@Test
	public void testMethods() {
		Method[] methods = cls.getDeclaredMethods();
		if(methods.length != 1) {
			fail("There should be only 1 method in the Stock class");
		} else {
			if(!methods[0].getName().equals("getChangePercent"))
				fail("You must implement a method named `getChangePercent`");
			if(methods[0].getParameterCount() != 0)
				fail("Stock smethod `getChangePercent` should not have parameters");
		}
	}
	
	@Test
	public void testGetChangePercent() {
		try {
			Constructor<?> constructor = cls.getDeclaredConstructor(String.class, String.class);
			Object obj = constructor.newInstance("ORCL", "Oracle Corporation");
			
			Field previousPrice = cls.getDeclaredField("previousClosingPrice");
			Field currentPrice = cls.getDeclaredField("currentPrice");

			previousPrice.setDouble(obj, 100);
			currentPrice.setDouble(obj, 150);
			
			Method m = cls.getDeclaredMethod("getChangePercent", new Class<?>[]{});
			Object result = m.invoke(obj, new Object[]{});
			
			assertEquals(0.5, (double)result, 0.00000001);

		} catch (NoSuchMethodException ex) {
			fail("Stock constructor is incorrect.");
		} catch (InvocationTargetException ex) {
			fail("A constructor or function couldn't be invoked");
		} catch (IllegalAccessException ex) {
			fail("Stock constructor isn't accessible");
		} catch (InstantiationException ex) {
			fail("Can't create a Stock object");
		} catch (NoSuchFieldException ex) {
			fail("Check your variable names");
		}
	}
}
