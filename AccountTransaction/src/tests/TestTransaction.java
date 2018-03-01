package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class TestTransaction {
	
	String transactionPath = "problem.Transaction";
	
	ClassLoader loader;
	Class<?> cls;
	
	@Before
	public void doesTransactionClassExist() {
		loader = this.getClass().getClassLoader();
		try {
			cls = loader.loadClass(transactionPath);
		} catch (ClassNotFoundException ex) {
			fail("Before running tests, can't load " + transactionPath);
		}
	}
	
	// VARIABLES
	
	@Test
	public void test01_CountVariables() {
		Field[] fields = cls.getDeclaredFields();
		if(fields.length != 5) {
			fail("The `Transaction` class has exactly 5 declared fields: date, type, amount, balance, description");
		}
	}
	
	@Test
	public void test02_PrivateVariables() {
		Field[] fields = cls.getDeclaredFields();
		for(Field f : fields) {
			if(!Modifier.isPrivate(f.getModifiers()))
				fail("`Transaction` has only private instance variables");
		}
	}
	
	@Test
	public void test03_NoStaticVariables() {
		Field[] fields = cls.getDeclaredFields();
		for(Field f : fields) {
			if(Modifier.isStatic(f.getModifiers()))
				fail("`Transaction` has no static variables");
		}		
	}
	
	@Test
	public void test04_VariableDataTypesAndIdentifiers() {
		// date, type, amount, balance, description
		
		// date
		try {
			Field date = cls.getDeclaredField("date");
			boolean isDateDate = date.getType().toString().equals("class java.util.Date");
			if(!(isDateDate)) {
				fail("The `date` variable should be of type `java.util.Date`");
			}
		} catch (NoSuchFieldException ex) {
			fail("`date` variable does not exist");
		}
		
		// type
		try {
			Field type = cls.getDeclaredField("type");
			boolean isTypeChar = type.getType().toString().equals("char");
			if(!(isTypeChar)) {
				fail("The `type` variable should be of type `char`");
			}
		} catch (NoSuchFieldException ex) {
			fail("`type` variable does not exist");
		}
		
		// amount
		try {
			Field amount = cls.getDeclaredField("amount");
			boolean isAmountDouble = amount.getType().toString().equals("double");
			if(!(isAmountDouble)) {
				fail("The `amount` variable should be of type `double`");
			}
		} catch (NoSuchFieldException ex) {
			fail("`amount` variable does not exist");
		}
		
		// balance
		try {
			Field balance = cls.getDeclaredField("balance");
			boolean isBalanceDouble = balance.getType().toString().equals("double");
			if(!(isBalanceDouble)) {
				fail("The `balance` variable should be of type `double`");
			}
		} catch (NoSuchFieldException ex) {
			fail("`balance` variable does not exist");
		}
		
		// description
		try {
			Field description = cls.getDeclaredField("description");
			boolean isDescriptionString = description.getType().toString().equals("class java.lang.String");
			if(!(isDescriptionString)) {
				fail("The `description` variable should be of type `String`");
			}
		} catch (NoSuchFieldException ex) {
			fail("`description` variable does not exist");
		}
	}
	
	// CONSTRUCTORS
	
	@SuppressWarnings("unused")
	@Test
	public void test05_NoDefaultConstructor() {
		try {
			Constructor<?> constructor = cls.getDeclaredConstructor();
			fail("`Transaction` has no default constructor.");
		} catch (NoSuchMethodException ex) {
			// test passes - `Transaction` has no default constructor
		}
	}

	@SuppressWarnings("unused")
	@Test
	public void test06_ConstructorHasFourParams() {
		try {
			Constructor<?> constructor = cls.getDeclaredConstructor(char.class, double.class, double.class, String.class);
		} catch (NoSuchMethodException ex) {
			fail("Constructor signed `Transaction(char, double, double, String)` is missing.");
		}
	}
	
	@Test
	public void test07_ConstructorSetsPrivateVariable_Type() {
		try {
			Constructor<?> constructor = cls.getDeclaredConstructor(char.class, double.class, double.class, String.class);
			Object obj = constructor.newInstance('D', 100, 200, "Test description");
			
			Field type = cls.getDeclaredField("type");
			type.setAccessible(true);
			char c = (char)type.get(obj); // value
			if(c != 'D') {
				fail("value of `type` was not correctly set during instantiation");
			}			
		} catch (Exception ex) {
			fail("Failed due to " + ex.getClass().getName());
		}
	}
	
	@Test
	public void test08_ConstructorSetsPrivateVariable_Amount() {
		try {
			Constructor<?> constructor = cls.getDeclaredConstructor(char.class, double.class, double.class, String.class);
			Object obj = constructor.newInstance('D', 100, 200, "Test description");
			
			Field amount = cls.getDeclaredField("amount");
			amount.setAccessible(true);
			double d = (double)amount.get(obj); // value
			if(d != 100) {
				fail("value of `amount` was not correctly set during instantiation");
			}			
		} catch (Exception ex) {
			fail("Failed due to " + ex.getClass().getName());
		}
	}
	
	@Test
	public void test09_ConstructorSetsPrivateVariable_Balance() {
		try {
			Constructor<?> constructor = cls.getDeclaredConstructor(char.class, double.class, double.class, String.class);
			Object obj = constructor.newInstance('D', 100, 200, "Test description");
			
			Field balance = cls.getDeclaredField("balance");
			balance.setAccessible(true);
			double d = (double)balance.get(obj); // value
			if(d != 200) {
				fail("value of `balance` was not correctly set during instantiation");
			}			
		} catch (Exception ex) {
			fail("Failed due to " + ex.getClass().getName());
		}
	}
	
	@Test
	public void test10_ConstructorSetsPrivateVariable_Description() {
		try {
			Constructor<?> constructor = cls.getDeclaredConstructor(char.class, double.class, double.class, String.class);
			Object obj = constructor.newInstance('D', 100, 200, "Test description");
			
			Field description = cls.getDeclaredField("description");
			description.setAccessible(true);
			String s = (String)description.get(obj); // value
			if(!s.equals("Test description")) {
				fail("value of `description` was not correctly set during instantiation");
			}			
		} catch (Exception ex) {
			fail("Failed due to " + ex.getClass().getName());
		}
	}
	
	@Test
	public void test11_ConstructorSetsPrivateVariable_Date() {
		try {
			Constructor<?> constructor = cls.getDeclaredConstructor(char.class, double.class, double.class, String.class);
			Object obj = constructor.newInstance('D', 100, 200, "Test description");
			
			Field date = cls.getDeclaredField("date");
			date.setAccessible(true);
			Date d = (Date)date.get(obj); // value
			Date now = new Date();
			if(now.compareTo(d) < 0 || now.compareTo(d) > 10) {
				fail("value of `date` was not correctly set during instantiation");
			}			
		} catch (Exception ex) {
			fail("Failed due to " + ex.getClass().getName());
		}
	}
	
	// FUNCTIONS
	
	@Test
	public void test12_ToString() {
		try {
			Constructor<?> constructor = cls.getDeclaredConstructor(char.class, double.class, double.class, String.class);
			Object obj = constructor.newInstance('D', 100, 200, "Test description");
			Method toString = cls.getDeclaredMethod("toString", new Class<?>[]{});
			Object result = toString.invoke(obj, new Object[]{});
			String test = new Date() + "\tType: D\tAmount: $100.0\tBalance: $200.0\tDescription: Test description";
			assertEquals(true, result.equals(test));
		} catch (Exception ex) {
			fail("Failed due to " + ex.getClass().getName());
		}
	}
}
