package problem_9_07;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class TestAccount {
	
	String classPath = "problem_9_07.Account";
	
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
		int numFields = 4;
		boolean hasId = false;
		boolean hasBalance = false;
		boolean hasInterestRate = false;
		boolean hasDate = false;
		
		Field[] fields = cls.getDeclaredFields();

		if(fields.length != numFields) {
			fail("Design your class with exactly " + numFields + " fields");
		} else {
			for(Field f : fields) {
				String name = f.getName();
				String type = f.getType().toString();
				
				switch(name) {
				case "id":
					if(!Modifier.isPrivate(f.getModifiers())) fail("id should be private");
					else hasId = true;
					if(!type.equals("int")) fail("id should be int type");
					break;
				case "balance":
					if(!Modifier.isPrivate(f.getModifiers())) fail("balance should be private");
					else hasBalance = true;
					if(!type.equals("double")) fail("balance should be double type");
					break;
				case "annualInterestRate":
					boolean isRateStatic = false;
					boolean isRatePrivate = false;
					if(!Modifier.isStatic(f.getModifiers())) fail("annualInterestRate should be static");
					else isRateStatic = true;
					if(!Modifier.isPrivate(f.getModifiers())) fail("annualInterestRate should be private");
					else isRatePrivate = true;
					if(isRateStatic && isRatePrivate) hasInterestRate = true;
					if(!type.equals("double")) fail("annualInterestRate should be double type");
					break;
				case "dateCreated":
					if(!Modifier.isPrivate(f.getModifiers())) fail("dateCreated should be private");
					else hasDate = true;
					if(!type.equals("class java.util.Date")) fail("dateCreated should be `class java.util.Date` type");					
					break;
				}
			}
			if(!(hasId && hasBalance && hasInterestRate && hasDate)) {
				fail("One of the fields is missing: id, balance, annualInterestRate, dateCreated");
			}
		}
	}
	
	@Test
	public void testConstructors() {
		int numConstructors = 2;
		
		Constructor<?>[] constructors = cls.getDeclaredConstructors();
		
		if(constructors.length != numConstructors) {
			fail("There should be exactly " + numConstructors + " constructors");
		} else {
			try {
				Constructor<?> constructor1 = cls.getDeclaredConstructor();
				Constructor<?> constructor2 = cls.getDeclaredConstructor(int.class, double.class);
				
				Date now = new Date();
				
				// after the first constructor is initialized, fields should be default zero, and date should be within a minute
				Object acct1 = constructor1.newInstance();
				Object acct2 = constructor2.newInstance(1122, 20000);
				
				Field id1 = acct1.getClass().getDeclaredField("id");
				Field id2 = acct2.getClass().getDeclaredField("id");
				Field date1 = acct1.getClass().getDeclaredField("dateCreated");
				Field date2 = acct2.getClass().getDeclaredField("dateCreated");
				Field balance1 = acct1.getClass().getDeclaredField("balance");
				Field balance2 = acct2.getClass().getDeclaredField("balance");
				Field interestRate = cls.getDeclaredField("annualInterestRate");
				
				id1.setAccessible(true);;
				id2.setAccessible(true);
				date1.setAccessible(true);
				date2.setAccessible(true);
				balance1.setAccessible(true);
				balance2.setAccessible(true);
				interestRate.setAccessible(true);
				
				assertEquals(0, id1.getInt(acct1));
				assertEquals(1122, id2.getInt(acct2));
				assertEquals(0, balance1.getDouble(acct1), 0.0);
				assertEquals(20000.0, balance2.getDouble(acct2), 0.0);
				assertEquals(0.0, interestRate.getDouble(acct1), 0.0);

				if(Math.abs(now.getTime() - ((Date)date1.get(acct1)).getTime()) > 60000){ // 1 minute
					fail("Dates are over a minute apart.");
				}
				if(Math.abs(now.getTime() - ((Date)date2.get(acct2)).getTime()) > 60000){ // 1 minute
					fail("Dates are over a minute apart.");
				}

				id1.setAccessible(false);
				id2.setAccessible(false);
				date1.setAccessible(false);
				date2.setAccessible(false);
				balance1.setAccessible(false);
				balance2.setAccessible(false);
				interestRate.setAccessible(false);
				
				if(!Modifier.isPublic(constructor1.getModifiers())) fail("Default constructor is not publicly accessible");
				if(!Modifier.isPublic(constructor2.getModifiers())) fail("Overloaded constructor is not publicly accessible");

			} catch(NoSuchMethodException ex) {
				fail("Unable to load one of your constructors. Is it defined? Is it public?");
			} catch(InvocationTargetException ex) {
				fail("Unable to instantiate an instance of Account class");
			} catch(IllegalAccessException ex) {
				fail("Unable to access Account class or one of its properties. Is it public? Are the constructors correct?");
			} catch(InstantiationException ex) {
				fail("Unable to instantiate an Account object.");
			} catch(NoSuchFieldException ex) {
				fail("Unable to access some fields after constructing the class.");
			}
		}
	}
	
	@Test
	public void testMethods() {
		int numMethods = 11;
		
		Method[] methods = cls.getDeclaredMethods();
		
		if(methods.length != numMethods) {
			fail("There should be exactly " + numMethods + " declared methods in this class");
		} else {
			boolean hasGetId = false;
			boolean hasGetBalance = false;
			boolean hasGetAnnualInterestRate = false;
			boolean hasGetDateCreated = false;
			boolean hasSetId = false;
			boolean hasSetBalance = false;
			boolean hasSetAnnualInterestRate = false;
			boolean hasGetMonthlyInterest = false;
			boolean hasGetMonthlyInterestRate = false;
			boolean hasWithdraw = false;
			boolean hasDeposit = false;
			
			try {
				Constructor<?> constructor1 = cls.getDeclaredConstructor();
				Constructor<?> constructor2 = cls.getDeclaredConstructor(int.class, double.class);
				
				Object acct1 = constructor1.newInstance();
				Object acct2 = constructor2.newInstance(1122, 20000);
				
				for(Method m : methods) {
					String name = m.getName();
					String returnType = m.getReturnType().getSimpleName();
					
					// all the methods should be public
					if(!Modifier.isPublic(m.getModifiers())) fail(name + " should be public");
					
					// methods may or may not have parameters
					Class<?>[] pTypes = m.getParameterTypes();
					
					switch(name) {
					case "getId":
						if(!returnType.equals("int")) fail(name + " should return int");
						else hasGetId = true;
						break;
					case "getBalance":
						if(!returnType.equals("double")) fail(name + " should return double");
						else hasGetBalance = true;
						break;
					case "getAnnualInterestRate":
						if(!Modifier.isStatic(m.getModifiers())) fail(name + " should be static");
						if(!returnType.equals("double")) fail(name + " should return double");
						else hasGetAnnualInterestRate = true;
						break;
					case "getDateCreated":
						if(!returnType.equals("Date")) fail(name + " should return Date");
						else hasGetDateCreated = true;
						break;
					case "setId":
						if(pTypes.length != 1) fail(name + " has exactly one parameter");
						if(!returnType.equals("void")) fail(name + " should return void");
						else hasSetId = true;
						break;
					case "setBalance":
						if(pTypes.length != 1) fail(name + " has exactly one parameter");
						if(!returnType.equals("void")) fail(name + " should return void");
						else hasSetBalance = true;
						break;
					case "setAnnualInterestRate":
						if(pTypes.length != 1) fail(name + " has exactly one parameter");
						if(!Modifier.isStatic(m.getModifiers())) fail(name + " should be static");
						if(!returnType.equals("void")) fail(name + " should return void");
						else hasSetAnnualInterestRate = true;
						break;
					case "getMonthlyInterest":
						if(!returnType.equals("double")) fail(name + " should return double");
						else hasGetMonthlyInterest = true;
						break;
					case "getMonthlyInterestRate":
						if(!returnType.equals("double")) fail(name + " should return double");
						else hasGetMonthlyInterestRate = true;
						break;
					case "withdraw":
						acct1 = constructor1.newInstance();
						acct2 = constructor2.newInstance(1122, 20000);
						Object balance1 = m.invoke(acct1, new Object[]{500});
						Object balance2 = m.invoke(acct2, new Object[]{500});
						assertEquals(0, (double)balance1, 0.0);
						assertEquals(19500, (double)balance2, 0.0);
						if(pTypes.length != 1) fail(name + " has exactly one parameter");
						if(!returnType.equals("double")) fail(name + " should return double");
						else hasWithdraw = true;
						break;
					case "deposit":
						acct1 = constructor1.newInstance();
						acct2 = constructor2.newInstance(1122, 20000);
						balance1 = m.invoke(acct1, new Object[]{500});
						balance2 = m.invoke(acct2, new Object[]{500});
						assertEquals(500, (double)balance1, 0.0);
						assertEquals(20500, (double)balance2, 0.0);
						if(pTypes.length != 1) fail(name + " has exactly one parameter");
						if(!returnType.equals("double")) fail(name + " should return double");
						else hasDeposit = true;
						break;
					default:
						fail(name + " is not an acceptable function");
						break;
					}
				}
			} catch(NoSuchMethodException ex) {
				fail("Unable to load one of your constructors. Is it defined? Is it public?");
			} catch(InvocationTargetException ex) {
				fail("Unable to instantiate an instance of Account class");
			} catch(IllegalAccessException ex) {
				fail("Unable to access Account class or one of its properties. Is it public? Are the constructors correct?");
			} catch(InstantiationException ex) {
				fail("Unable to instantiate an Account object.");
			}
			
			if(!(hasGetId && hasGetBalance && hasGetAnnualInterestRate && hasGetDateCreated && hasSetId && hasSetBalance && hasSetAnnualInterestRate && hasGetMonthlyInterest && hasGetMonthlyInterestRate && hasWithdraw && hasDeposit)) {
				fail("One of the functions is missing or incorrectly defined.");
			}
		}
	}
	
	@Test
	public void testGetAndSetId() {
		try {
			Constructor<?> constructor1 = cls.getDeclaredConstructor();
			Constructor<?> constructor2 = cls.getDeclaredConstructor(int.class, double.class);
		
			Object acct1 = constructor1.newInstance();
			Object acct2 = constructor2.newInstance(1122, 20000);
			
			Method setId = cls.getDeclaredMethod("setId", int.class);
			Method getId = cls.getDeclaredMethod("getId");
			
			setId.invoke(acct1, new Object[]{20});
			setId.invoke(acct2, new Object[]{30});
		
			Field idField = cls.getDeclaredField("id");
			idField.setAccessible(true);
			Object id1 = idField.getInt(acct1);
			Object id2 = idField.getInt(acct2);
			idField.setAccessible(false);

			Object getIdResult1 = getId.invoke(acct1);
			Object getIdResult2 = getId.invoke(acct2);
			
			assertEquals((int)id1, 20);
			assertEquals((int)id2, 30);
			assertEquals((int)getIdResult1, 20);
			assertEquals((int)getIdResult2, 30);
			
		} catch(NoSuchMethodException ex) {
			fail("Unable to load one of your constructors or methods. Is it defined? Is it public?");
		} catch(InvocationTargetException ex) {
			fail("Unable to invoke a constructor or method.");
		} catch(IllegalAccessException ex) {
			fail("Unable to access a constructor, method, or properties");
		} catch(InstantiationException ex) {
			fail("Unable to instantiate an Account object.");
		} catch(NoSuchFieldException ex) {
			fail("The id field does not exist.");
		}
	}
	
	@Test
	public void testGetAndSetBalance() {
		try {
			Constructor<?> constructor1 = cls.getDeclaredConstructor();
			Constructor<?> constructor2 = cls.getDeclaredConstructor(int.class, double.class);
		
			Object acct1 = constructor1.newInstance();
			Object acct2 = constructor2.newInstance(1122, 20000);
		
			Method setBalance = cls.getDeclaredMethod("setBalance", double.class);
			Method getBalance = cls.getDeclaredMethod("getBalance");
			
			setBalance.invoke(acct1, new Object[]{500});
			setBalance.invoke(acct2, new Object[]{700});
			
			Field balanceField = cls.getDeclaredField("balance");
			balanceField.setAccessible(true);
			Object balance1 = balanceField.getDouble(acct1);
			Object balance2 = balanceField.getDouble(acct2);
			balanceField.setAccessible(false);
			
			Object getBalanceResult1 = getBalance.invoke(acct1);
			Object getBalanceResult2 = getBalance.invoke(acct2);
			
			assertEquals((double)balance1, 500.0, 0.0);
			assertEquals((double)balance2, 700.0, 0.0);
			assertEquals((double)getBalanceResult1, 500, 0.0);
			assertEquals((double)getBalanceResult2, 700, 0.0);
			
		} catch(NoSuchMethodException ex) {
			fail("Unable to load one of your constructors or methods. Is it defined? Is it public?");
		} catch(InvocationTargetException ex) {
			fail("Unable to invoke a constructor or method.");
		} catch(IllegalAccessException ex) {
			fail("Unable to access a constructor, method, or properties");
		} catch(InstantiationException ex) {
			fail("Unable to instantiate an Account object.");
		} catch(NoSuchFieldException ex) {
			fail("The balance field does not exist.");
		}
	}
	
	@Test
	public void testGetAndSetInterestRates() {
		try {
			Constructor<?> constructor1 = cls.getDeclaredConstructor();
			Constructor<?> constructor2 = cls.getDeclaredConstructor(int.class, double.class);
		
			Object acct1 = constructor1.newInstance();
			Object acct2 = constructor2.newInstance(1122, 20000);
		
			Method setAnnualInterestRate = cls.getDeclaredMethod("setAnnualInterestRate", double.class);
			Method getAnnualInterestRate = cls.getDeclaredMethod("getAnnualInterestRate");
			Method getMonthlyInterestRate = cls.getDeclaredMethod("getMonthlyInterestRate");
			Method getMonthlyInterest = cls.getDeclaredMethod("getMonthlyInterest");			

			Field annualInterestRateField = cls.getDeclaredField("annualInterestRate");
			
			annualInterestRateField.setAccessible(true);
			
			setAnnualInterestRate.invoke(acct1, new Object[]{4.5});
			
			Object annualInterestRate1 = annualInterestRateField.getDouble(acct1);
			Object annualInterestRate2 = annualInterestRateField.getDouble(acct2);
			Object getAnnualInterestRateResult1 = getAnnualInterestRate.invoke(acct1);
			Object getAnnualInterestRateResult2 = getAnnualInterestRate.invoke(acct2);
			Object getMonthlyInterestRate1 = getMonthlyInterestRate.invoke(acct1);
			Object getMonthlyInterestRate2 = getMonthlyInterestRate.invoke(acct2);
			Object getMonthlyInterestResult1 = getMonthlyInterest.invoke(acct1);
			Object getMonthlyInterestResult2 = getMonthlyInterest.invoke(acct2);
			
			assertEquals((double)annualInterestRate1, 0.045, 0.0);
			assertEquals((double)annualInterestRate2, 0.045, 0.0);
			assertEquals((double)getAnnualInterestRateResult1, 0.045, 0.0);
			assertEquals((double)getAnnualInterestRateResult2, 0.045, 0.0);
			assertEquals((double)getMonthlyInterestRate1, 0.00375, 0.0001);
			assertEquals((double)getMonthlyInterestRate2, 0.00375, 0.0001);
			assertEquals((double)getMonthlyInterestResult1, 0, 0);
			assertEquals((double)getMonthlyInterestResult2, 75, 1.6); // too much discrepancy here
			
			setAnnualInterestRate.invoke(acct2, new Object[]{8});
			
			annualInterestRate1 = annualInterestRateField.getDouble(acct1);
			annualInterestRate2 = annualInterestRateField.getDouble(acct2);
			getAnnualInterestRateResult1 = getAnnualInterestRate.invoke(acct1);
			getAnnualInterestRateResult2 = getAnnualInterestRate.invoke(acct2);
			getMonthlyInterestResult1 = getMonthlyInterest.invoke(acct1);
			getMonthlyInterestResult2 = getMonthlyInterest.invoke(acct2);
			getMonthlyInterestRate1 = getMonthlyInterestRate.invoke(acct1);
			getMonthlyInterestRate2 = getMonthlyInterestRate.invoke(acct2);

			assertEquals((double)annualInterestRate1, 0.08, 0.0);
			assertEquals((double)annualInterestRate2, 0.08, 0.0);
			assertEquals((double)getAnnualInterestRateResult1, 0.08, 0.0);
			assertEquals((double)getAnnualInterestRateResult2, 0.08, 0.0);
			assertEquals((double)getMonthlyInterestRate1, 0.006, 0.0005);
			assertEquals((double)getMonthlyInterestRate2, 0.006, 0.0005);
			assertEquals((double)getMonthlyInterestResult1, 0, 0);
			assertEquals((double)getMonthlyInterestResult2, 120, 10); // too much discrepancy here
			
			annualInterestRateField.setAccessible(false);			
			
		} catch(NoSuchMethodException ex) {
			fail("Unable to load one of your constructors or methods. Is it defined? Is it public?");
		} catch(InvocationTargetException ex) {
			fail("Unable to invoke a constructor or method.");
		} catch(IllegalAccessException ex) {
			fail("Unable to access a constructor, method, or properties");
		} catch(InstantiationException ex) {
			fail("Unable to instantiate an Account object.");
		} catch(NoSuchFieldException ex) {
			fail("The annualInterestRate field does not exist.");
		}
	}
}
