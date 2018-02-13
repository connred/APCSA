package problem_9_13;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.Before;
import org.junit.Test;

public class TestLocation {
	
	String classPath = "problem_9_13.Location";
	
	ClassLoader loader;
	Class<?> cls;
	
	@Before
	public void setup() {
		loader = this.getClass().getClassLoader();
		try {
			cls = loader.loadClass(classPath);
		} catch (ClassNotFoundException ex) {
			fail("Can't find or load " + classPath);
		}
	}

	@Test
	public void testFields() {
		int numFields = 3;
		boolean hasRow = false;
		boolean hasColumn = false;
		boolean hasMaxValue = false;
		
		Field[] fields = cls.getDeclaredFields();

		if(fields.length != numFields) {
			fail("Design your class with exactly " + numFields + " fields");
		} else {
			for(Field f : fields) {
				String name = f.getName();
				String type = f.getType().toString();
				
				switch(name) {
				case "row":
					if(!Modifier.isPublic(f.getModifiers())) fail("row should be public");
					else hasRow = true;
					if(!type.equals("int")) fail("row should be int type");
					break;
				case "column":
					if(!Modifier.isPublic(f.getModifiers())) fail("column should be public");
					else hasColumn = true;
					if(!type.equals("int")) fail("column should be int type");
					break;
				case "maxValue":
					if(!Modifier.isPublic(f.getModifiers())) fail("maxValue should be public");
					else hasMaxValue = true;
					if(!type.equals("double")) fail("maxValue should be double type");
					break;
				}
			}
			if(!(hasRow && hasColumn && hasMaxValue)) {
				fail("Missing row, column, or maxValue");
			}
		}
	}
	
	@Test
	public void testConstructors() {
		int numConstructors = 1;
		
		Constructor<?>[] constructors = cls.getDeclaredConstructors();
		
		if(constructors.length != numConstructors) {
			fail("There should be exactly " + numConstructors + " constructors");
		} else {
			Constructor<?> c = constructors[0];
			if(c.getParameterCount() != 0) fail("This class has only one default non parameterized constructor");
			if(!Modifier.isPublic(c.getModifiers())) fail("Constructor is not publicly accessible");
		}
	}
	
	@Test
	public void testMethods() {
		int numMethods = 1;
		
		Method[] methods = cls.getDeclaredMethods();
		
		if(methods.length != 1) {
			fail("There should be exactly " + numMethods + " declared methods in this class");
		} else {
			Method m = methods[0];
			Class<?>[] pTypes = m.getParameterTypes();
			
			if(!m.getName().equals("locateLargest")) fail("There must exist a method named 'locateLargest'");			
			if(!Modifier.isStatic(m.getModifiers())) fail("locateLargest must be static");
			if(!Modifier.isPublic(m.getModifiers())) fail("locateLargest must be public");
			if(pTypes.length != 1) fail("There is exactly one parameter");
			if(!pTypes[0].getSimpleName().equals("double[][]")) fail("Parameter must be double[][]");			
			if(!m.getReturnType().getSimpleName().equals("Location")) fail("The locateLargest method should return a Location object");
			
			double[][] array = {
				{1,2,3},
				{4,5,6},
				{9,8,0}
			};
			
			try {
				Object result = m.invoke(null, new Object[]{ array });
				Field maxValue = result.getClass().getDeclaredField("maxValue");
				Field row = result.getClass().getDeclaredField("row");
				Field column = result.getClass().getDeclaredField("column");
				assertEquals(9.0, maxValue.getDouble(result), 0.0);
				assertEquals(2, row.getInt(result));
				assertEquals(0, column.getInt(result));
			} catch (InvocationTargetException ex) {
				fail("Not able to invoke locateLargest b/c InvocationTargetException");
			} catch (IllegalAccessException ex) {
				fail("Not able to invoke locateLargest b/c IllegalAccessException");
			} catch(NoSuchFieldException ex) {
				fail("Can't find one row, column, or maxValue b/c NoSuchFieldException");
			}
		}
	}		
}
