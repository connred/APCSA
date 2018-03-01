package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TestAccount {
	
	String accountPath = "problem.Account";
	
	ClassLoader loader;
	Class<?> cls;
	
	@Before
	public void setup() {
		loader = this.getClass().getClassLoader();
		try {
			cls = loader.loadClass(accountPath);
		} catch (ClassNotFoundException ex) {
			fail("Can't find or load " + accountPath);
		}
	}

	@Test
	public void test01_CountVariables() {
		Field[] fields = cls.getDeclaredFields();
		if(fields.length != 6) {
			fail("The `Account` class has exactly 6 declared fields: id, balance, annualInterestRate, dateCreated, customer, transactions");
		}
	}
	
	@Test
	public void test02_PrivateVariables() {
		Field[] fields = cls.getDeclaredFields();
		for(Field f : fields) {
			if(!Modifier.isPrivate(f.getModifiers()))
				fail("`Account` has only private instance variables");
		}
	}
	
	@Test
	public void test03_AnnualInterestRateIsStatic() {
		try {
			Field rate = cls.getDeclaredField("annualInterestRate");
			if(!Modifier.isStatic(rate.getModifiers())) {
				fail("`annualInterestRate` must be static");
			}
		} catch(NoSuchFieldException ex) {
			fail("`annualInterestRate` variable does not exist");
		}
	}
	
	@Test
	public void test04_VariableDataTypesAndIdentifiers() {
		// id, balance, annualInterestRate, dateCreated, customer, transactions
		
		// id
		try {
			Field id = cls.getDeclaredField("id");
			boolean isIdInteger = id.getType().toString().equals("int");
			if(!isIdInteger) {
				fail("The `id` variable should be of type `int`");
			}
		} catch (NoSuchFieldException ex) {
			fail("`id` variable does not exist");
		}
		
		// balance
		try {
			Field balance = cls.getDeclaredField("balance");
			boolean isBalanceDouble = balance.getType().toString().equals("double");
			if(!isBalanceDouble) {
				fail("The `balance` variable should be of type `double`");
			}
		} catch (NoSuchFieldException ex) {
			fail("`balance` variable does not exist");
		}
		
		// annualInterestRate
		try {
			Field annualInterestRate = cls.getDeclaredField("balance");
			boolean isAnnualInterestRateDouble = annualInterestRate.getType().toString().equals("double");
			if(!isAnnualInterestRateDouble) {
				fail("The `annualInterestRate` variable should be of type `double`");
			}
		} catch (NoSuchFieldException ex) {
			fail("`annualInterestRate` variable does not exist");
		}
		
		// dateCreated
		try {
			Field dateCreated = cls.getDeclaredField("dateCreated");
			boolean isDateCreatedDate = dateCreated.getType().toString().equals("class java.util.Date");
			if(!isDateCreatedDate) {
				fail("The `dateCreated` variable should be of type `java.util.Date`");
			}
		} catch (NoSuchFieldException ex) {
			fail("`dateCreated` variable does not exist");
		}
		
		// customer
		try {
			Field customer = cls.getDeclaredField("customer");
			boolean isCustomerString = customer.getType().toString().equals("class java.lang.String");
			if(!isCustomerString) {
				fail("The `customer` variable should be of type `class java.lang.String`");
			}
		} catch (NoSuchFieldException ex) {
			fail("`customer` variable does not exist");
		}
		
		// transactions
		try {
			Field transactions = cls.getDeclaredField("transactions");
			boolean isTransactionsList = transactions.getType().toString().equals("interface java.util.List");
			if(!isTransactionsList) {
				fail("The `transactions` variable should be of type `interface java.util.List`");
			}
		} catch (NoSuchFieldException ex) {
			fail("`transactions` variable does not exist");
		}
	}
	
	@Test
	public void test_HasThreeConstructors() {
		Constructor<?>[] constructors = cls.getDeclaredConstructors();
		if(constructors.length != 3) {
			fail("There should be exactly 3 constructors");
		}
	}
	
	@Test
	public void test_DefaultConstructorAndInstanceFields() {
		// id = 0, balance = 0, annualInterestRate = 0, dateCreated = new Date(), transactions not null
		try {
			Constructor<?> constructor = cls.getDeclaredConstructor();
			if(!Modifier.isPublic(constructor.getModifiers())) fail("Default onstructor is not publicly accessible");
			
			Object obj = constructor.newInstance();
			
			Field id 					= cls.getDeclaredField("id");
			Field balance 				= cls.getDeclaredField("balance");
			Field annualInterestRate 	= cls.getDeclaredField("annualInterestRate");
			Field dateCreated			= cls.getDeclaredField("dateCreated");
			Field transactions			= cls.getDeclaredField("transactions");
			
			id.setAccessible(true);
			balance.setAccessible(true);
			annualInterestRate.setAccessible(true);
			dateCreated.setAccessible(true);
			transactions.setAccessible(true);
			
			int i = (int)id.get(obj); // value
			double b = (double)balance.get(obj);
			double a = (double)annualInterestRate.get(obj);
			Date d = (Date)dateCreated.get(obj);
			List<?> t = (List<?>)transactions.get(obj);
			
			Date now = new Date();
			
			if(i != 0) { fail("value of `id` is not default 0"); }
			if(b != 0) { fail("value of `balance` is not default 0"); }
			if(a != 0) { fail("value of `annualInterestRate` is not default 0"); }
			if(now.compareTo(d) < 0 || now.compareTo(d ) > 10) { fail("value of `dateCreated` is not current"); }
			if(t.size() != 0) fail("`transactions` list does not have size 0");
			
		} catch (Exception ex) {
			fail("Failed due to " + ex.getClass().getName());
		}
	}
	
	@Test
	public void test_ConstructorWithTwoParams() {
		// id = 0, balance = 0, annualInterestRate = 0, dateCreated = new Date(), transactions not null
		try {
			Constructor<?> constructor = cls.getDeclaredConstructor(int.class, double.class);
			if(!Modifier.isPublic(constructor.getModifiers())) fail("Two param onstructor is not publicly accessible");
			
			Object obj = constructor.newInstance(1, 100);
			
			Field id 					= cls.getDeclaredField("id");
			Field balance 				= cls.getDeclaredField("balance");
			Field annualInterestRate 	= cls.getDeclaredField("annualInterestRate");
			Field dateCreated			= cls.getDeclaredField("dateCreated");
			Field transactions			= cls.getDeclaredField("transactions");
			
			id.setAccessible(true);
			balance.setAccessible(true);
			annualInterestRate.setAccessible(true);
			dateCreated.setAccessible(true);
			transactions.setAccessible(true);
			
			int i = (int)id.get(obj); // value
			double b = (double)balance.get(obj);
			double a = (double)annualInterestRate.get(obj);
			Date d = (Date)dateCreated.get(obj);
			List<?> t = (List<?>)transactions.get(obj);
			
			Date now = new Date();
			
			if(i != 1) { fail("parameterized constructor should change value of `id`"); }
			if(b != 100) { fail("parameterized constructor should change value of `balance`"); }
			if(a != 0) { fail("value of `annualInterestRate` is not default 0"); }
			if(now.compareTo(d) < 0 || now.compareTo(d ) > 10) { fail("value of `dateCreated` is not current"); }
			if(t.size() != 0) fail("`transactions` list does not have size 0");
			
		} catch (Exception ex) {
			fail("Failed due to " + ex.getClass().getName());
		}
	}
	
	@Test
	public void test_ConstructorWithThreeParams() {
		// id = 0, balance = 0, annualInterestRate = 0, dateCreated = new Date(), transactions not null
		try {
			Constructor<?> constructor = cls.getDeclaredConstructor(String.class, int.class, double.class);
			if(!Modifier.isPublic(constructor.getModifiers())) fail("Three param onstructor is not publicly accessible");
			
			Object obj = constructor.newInstance("John", 1, 100);
			
			Field id 					= cls.getDeclaredField("id");
			Field balance 				= cls.getDeclaredField("balance");
			Field annualInterestRate 	= cls.getDeclaredField("annualInterestRate");
			Field dateCreated			= cls.getDeclaredField("dateCreated");
			Field transactions			= cls.getDeclaredField("transactions");
			Field customer				= cls.getDeclaredField("customer");
			
			id.setAccessible(true);
			balance.setAccessible(true);
			annualInterestRate.setAccessible(true);
			dateCreated.setAccessible(true);
			transactions.setAccessible(true);
			customer.setAccessible(true);
			
			int i = (int)id.get(obj); // value
			double b = (double)balance.get(obj);
			double a = (double)annualInterestRate.get(obj);
			Date d = (Date)dateCreated.get(obj);
			List<?> t = (List<?>)transactions.get(obj);
			String c = (String)customer.get(obj);
			
			Date now = new Date();
			
			if(i != 1) { fail("parameterized constructor should change value of `id`"); }
			if(b != 100) { fail("parameterized constructor should change value of `balance`"); }
			if(a != 0) { fail("value of `annualInterestRate` is not default 0"); }
			if(now.compareTo(d) < 0 || now.compareTo(d ) > 10) { fail("value of `dateCreated` is not current"); }
			if(t.size() != 0) { fail("`transactions` list does not have size 0"); }
			if(!c.equals("John")) { fail("parameterized constructor should change value of `customer`"); }
			
		} catch (Exception ex) {
			fail("Failed due to " + ex.getClass().getName());
		}		
	}
		
	
	
	@Test
	public void testMethods() {
		int numMethods = 14;
		
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
					case "toString":
						if(!returnType.equals("String")) fail(name + " should return String");
						//else hasGetMonthlyInterestRate = true;
						break;
					case "getCustomer":
						if(!returnType.equals("String")) fail(name + " should return String");
						break;
					case "getTransactions":
						if(!returnType.equals("List")) fail(name + " should return List");
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
			Constructor<?> constructor3 = cls.getDeclaredConstructor(String.class, int.class, double.class);
		
			Object acct1 = constructor1.newInstance();
			Object acct2 = constructor2.newInstance(1122, 20000);
			Object acct3 = constructor3.newInstance("John", 1, 100);
			
			Method setId = cls.getDeclaredMethod("setId", int.class);
			Method getId = cls.getDeclaredMethod("getId");
			
			setId.invoke(acct1, new Object[]{20});
			setId.invoke(acct2, new Object[]{30});
			setId.invoke(acct3, new Object[]{40});
		
			Field idField = cls.getDeclaredField("id");
			idField.setAccessible(true);
			Object id1 = idField.getInt(acct1);
			Object id2 = idField.getInt(acct2);
			Object id3 = idField.getInt(acct3);
			idField.setAccessible(false);

			Object getIdResult1 = getId.invoke(acct1);
			Object getIdResult2 = getId.invoke(acct2);
			Object getIdResult3 = getId.invoke(acct3);
			
			assertEquals((int)id1, 20);
			assertEquals((int)id2, 30);
			assertEquals((int)id3, 40);
			assertEquals((int)getIdResult1, 20);
			assertEquals((int)getIdResult2, 30);
			assertEquals((int)getIdResult3, 40);
			
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
			Constructor<?> constructor3 = cls.getDeclaredConstructor(String.class, int.class, double.class);
		
			Object acct1 = constructor1.newInstance();
			Object acct2 = constructor2.newInstance(1122, 20000);
			Object acct3 = constructor3.newInstance("John", 1, 100);
			
			Method setBalance = cls.getDeclaredMethod("setBalance", double.class);
			Method getBalance = cls.getDeclaredMethod("getBalance");
			
			setBalance.invoke(acct1, new Object[]{500});
			setBalance.invoke(acct2, new Object[]{700});
			setBalance.invoke(acct3, new Object[]{750});
			
			Field balanceField = cls.getDeclaredField("balance");
			balanceField.setAccessible(true);
			Object balance1 = balanceField.getDouble(acct1);
			Object balance2 = balanceField.getDouble(acct2);
			Object balance3 = balanceField.getDouble(acct3);
			balanceField.setAccessible(false);
			
			Object getBalanceResult1 = getBalance.invoke(acct1);
			Object getBalanceResult2 = getBalance.invoke(acct2);
			Object getBalanceResult3 = getBalance.invoke(acct3);
			
			assertEquals((double)balance1, 500.0, 0.0);
			assertEquals((double)balance2, 700.0, 0.0);
			assertEquals((double)balance3, 750.0, 0.0);
			assertEquals((double)getBalanceResult1, 500, 0.0);
			assertEquals((double)getBalanceResult2, 700, 0.0);
			assertEquals((double)getBalanceResult3, 750, 0.0);
			
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
			Constructor<?> constructor3 = cls.getDeclaredConstructor(String.class, int.class, double.class);
		
			Object acct1 = constructor1.newInstance();
			Object acct2 = constructor2.newInstance(2, 1000);
			Object acct3 = constructor3.newInstance("John", 1, 100);
		
			Method setAnnualInterestRate = cls.getDeclaredMethod("setAnnualInterestRate", double.class);
			Method getAnnualInterestRate = cls.getDeclaredMethod("getAnnualInterestRate");
			Method getMonthlyInterestRate = cls.getDeclaredMethod("getMonthlyInterestRate");
			Method getMonthlyInterest = cls.getDeclaredMethod("getMonthlyInterest");			

			Field annualInterestRateField = cls.getDeclaredField("annualInterestRate");
			
			annualInterestRateField.setAccessible(true);
			
			setAnnualInterestRate.invoke(acct1, new Object[]{10});
			
			Object annualInterestRate1 = annualInterestRateField.getDouble(acct1);
			Object annualInterestRate2 = annualInterestRateField.getDouble(acct2);
			Object annualInterestRate3 = annualInterestRateField.getDouble(acct3);
			Object getAnnualInterestRateResult1 = getAnnualInterestRate.invoke(acct1);
			Object getAnnualInterestRateResult2 = getAnnualInterestRate.invoke(acct2);
			Object getAnnualInterestRateResult3 = getAnnualInterestRate.invoke(acct3);
			Object getMonthlyInterestRate1 = getMonthlyInterestRate.invoke(acct1);
			Object getMonthlyInterestRate2 = getMonthlyInterestRate.invoke(acct2);
			Object getMonthlyInterestRate3 = getMonthlyInterestRate.invoke(acct3);
			Object getMonthlyInterestResult1 = getMonthlyInterest.invoke(acct1);
			Object getMonthlyInterestResult2 = getMonthlyInterest.invoke(acct2);
			Object getMonthlyInterestResult3 = getMonthlyInterest.invoke(acct3);
			
			assertEquals((double)annualInterestRate1, 10, 0.0);
			assertEquals((double)annualInterestRate2, 10, 0.0);
			assertEquals((double)annualInterestRate3, 10, 0.0);
			assertEquals((double)getAnnualInterestRateResult1, 0.1, 0.0);
			assertEquals((double)getAnnualInterestRateResult2, 0.1, 0.0);
			assertEquals((double)getAnnualInterestRateResult3, 0.1, 0.0);
			assertEquals((double)getMonthlyInterestRate1, 0.0083, 0.0001);
			assertEquals((double)getMonthlyInterestRate2, 0.0083, 0.0001);
			assertEquals((double)getMonthlyInterestRate3, 0.0083, 0.0001);
			assertEquals((double)getMonthlyInterestResult1, 0, 0);
			assertEquals((double)getMonthlyInterestResult2, 8.33, 0.01);
			assertEquals((double)getMonthlyInterestResult3, 0.83, 0.01);
			
			setAnnualInterestRate.invoke(acct2, new Object[]{20});
			
			annualInterestRate1 = annualInterestRateField.getDouble(acct1);
			annualInterestRate2 = annualInterestRateField.getDouble(acct2);
			annualInterestRate3 = annualInterestRateField.getDouble(acct3);
			getAnnualInterestRateResult1 = getAnnualInterestRate.invoke(acct1);
			getAnnualInterestRateResult2 = getAnnualInterestRate.invoke(acct2);
			getAnnualInterestRateResult3 = getAnnualInterestRate.invoke(acct3);
			getMonthlyInterestResult1 = getMonthlyInterest.invoke(acct1);
			getMonthlyInterestResult2 = getMonthlyInterest.invoke(acct2);
			getMonthlyInterestResult3 = getMonthlyInterest.invoke(acct3);
			getMonthlyInterestRate1 = getMonthlyInterestRate.invoke(acct1);
			getMonthlyInterestRate2 = getMonthlyInterestRate.invoke(acct2);
			getMonthlyInterestRate3 = getMonthlyInterestRate.invoke(acct3);

			assertEquals((double)annualInterestRate1, 20, 0.0);
			assertEquals((double)annualInterestRate2, 20, 0.0);
			assertEquals((double)annualInterestRate3, 20, 0.0);
			assertEquals((double)getAnnualInterestRateResult1, 0.2, 0.0);
			assertEquals((double)getAnnualInterestRateResult2, 0.2, 0.0);
			assertEquals((double)getAnnualInterestRateResult3, 0.2, 0.0);
			assertEquals((double)getMonthlyInterestRate1, 0.016, 0.001);
			assertEquals((double)getMonthlyInterestRate2, 0.016, 0.001);
			assertEquals((double)getMonthlyInterestRate3, 0.016, 0.001);
			assertEquals((double)getMonthlyInterestResult1, 0, 0);
			assertEquals((double)getMonthlyInterestResult2, 16.66, 0.01);
			assertEquals((double)getMonthlyInterestResult3, 1.66, 0.01);
			
			setAnnualInterestRate.invoke(acct2, new Object[]{0});
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
	
	@Test
	public void test_Deposit() {
		try {
			Constructor<?> constructor1 = cls.getDeclaredConstructor();
			Constructor<?> constructor2 = cls.getDeclaredConstructor(int.class, double.class);
			Constructor<?> constructor3 = cls.getDeclaredConstructor(String.class, int.class, double.class);
		
			Object acct1 = constructor1.newInstance();
			Object acct2 = constructor2.newInstance(2, 1000);
			Object acct3 = constructor3.newInstance("John", 1, 100);
		
			Method deposit = cls.getDeclaredMethod("deposit", double.class);	

			Field balance = cls.getDeclaredField("balance");
			Field transactions = cls.getDeclaredField("transactions");
			
			balance.setAccessible(true);
			transactions.setAccessible(true);
			
			deposit.invoke(acct1, new Object[]{100});
			deposit.invoke(acct2, new Object[]{1000});
			deposit.invoke(acct2, new Object[]{500});
			deposit.invoke(acct3, new Object[]{100});
			deposit.invoke(acct3, new Object[]{50});
			deposit.invoke(acct3, new Object[]{50});
			
			Object balance1 = balance.getDouble(acct1);
			Object balance2 = balance.getDouble(acct2);
			Object balance3 = balance.getDouble(acct3);
			
			List<?> t1 = (List<?>)transactions.get(acct1);
			List<?> t2 = (List<?>)transactions.get(acct2);
			List<?> t3 = (List<?>)transactions.get(acct3);
			assertEquals(t1.size(), 1);
			assertEquals(t2.size(), 2);
			assertEquals(t3.size(), 3);
			
			assertEquals((double)balance1, 100, 0.0);
			assertEquals((double)balance2, 2500, 0.0);
			assertEquals((double)balance3, 300, 0.0);		
			
			balance.setAccessible(false);
			transactions.setAccessible(false);
			
		} catch(NoSuchMethodException ex) {
			fail("Unable to load one of your constructors or methods. Is it defined? Is it public?");
		} catch(InvocationTargetException ex) {
			fail("Unable to invoke a constructor or method.");
		} catch(IllegalAccessException ex) {
			fail("Unable to access a constructor, method, or properties");
		} catch(InstantiationException ex) {
			fail("Unable to instantiate an Account object.");
		} catch(NoSuchFieldException ex) {
			fail("The balance or transactions field does not exist.");
		}
	}
	
	@Test
	public void test_Withdraw() {
		try {
			Constructor<?> constructor1 = cls.getDeclaredConstructor();
			Constructor<?> constructor2 = cls.getDeclaredConstructor(int.class, double.class);
			Constructor<?> constructor3 = cls.getDeclaredConstructor(String.class, int.class, double.class);
		
			Object acct1 = constructor1.newInstance();
			Object acct2 = constructor2.newInstance(2, 1000);
			Object acct3 = constructor3.newInstance("John", 1, 100);
		
			Method withdraw = cls.getDeclaredMethod("withdraw", double.class);	

			Field balance = cls.getDeclaredField("balance");
			Field transactions = cls.getDeclaredField("transactions");
			
			balance.setAccessible(true);
			transactions.setAccessible(true);
			
			withdraw.invoke(acct1, new Object[]{10});
			withdraw.invoke(acct2, new Object[]{10});
			withdraw.invoke(acct2, new Object[]{10});
			withdraw.invoke(acct3, new Object[]{10});
			withdraw.invoke(acct3, new Object[]{10});
			withdraw.invoke(acct3, new Object[]{10});
			
			Object balance1 = balance.getDouble(acct1);
			Object balance2 = balance.getDouble(acct2);
			Object balance3 = balance.getDouble(acct3);
			
			List<?> t1 = (List<?>)transactions.get(acct1);
			List<?> t2 = (List<?>)transactions.get(acct2);
			List<?> t3 = (List<?>)transactions.get(acct3);
			assertEquals(t1.size(), 0);
			assertEquals(t2.size(), 2);
			assertEquals(t3.size(), 3);
			
			assertEquals((double)balance1, 0, 0.0);
			assertEquals((double)balance2, 980, 0.0);
			assertEquals((double)balance3, 70, 0.0);		
			
			balance.setAccessible(false);
			transactions.setAccessible(false);
			
		} catch(NoSuchMethodException ex) {
			fail("Unable to load one of your constructors or methods. Is it defined? Is it public?");
		} catch(InvocationTargetException ex) {
			fail("Unable to invoke a constructor or method.");
		} catch(IllegalAccessException ex) {
			fail("Unable to access a constructor, method, or properties");
		} catch(InstantiationException ex) {
			fail("Unable to instantiate an Account object.");
		} catch(NoSuchFieldException ex) {
			fail("The balance or transactions field does not exist.");
		}
	}
	
	@Test
	public void test_ToString() {
		try {
			Constructor<?> constructor1 = cls.getDeclaredConstructor();
			Constructor<?> constructor2 = cls.getDeclaredConstructor(int.class, double.class);
			Constructor<?> constructor3 = cls.getDeclaredConstructor(String.class, int.class, double.class);
		
			Object acct1 = constructor1.newInstance();
			Object acct2 = constructor2.newInstance(2, 1000);
			Object acct3 = constructor3.newInstance("John", 1, 100);
		
			Method deposit = cls.getDeclaredMethod("deposit", double.class);	
			Method withdraw = cls.getDeclaredMethod("withdraw", double.class);	

			Field balance = cls.getDeclaredField("balance");
			Field transactions = cls.getDeclaredField("transactions");
			
			balance.setAccessible(true);
			transactions.setAccessible(true);
			
			deposit.invoke(acct1, new Object[]{100});
			deposit.invoke(acct2, new Object[]{1000});
			deposit.invoke(acct2, new Object[]{500});
			deposit.invoke(acct3, new Object[]{100});
			deposit.invoke(acct3, new Object[]{50});
			deposit.invoke(acct3, new Object[]{50});
			
			withdraw.invoke(acct1, new Object[]{10});
			withdraw.invoke(acct2, new Object[]{10});
			withdraw.invoke(acct2, new Object[]{10});
			withdraw.invoke(acct3, new Object[]{10});
			withdraw.invoke(acct3, new Object[]{10});
			withdraw.invoke(acct3, new Object[]{10});
			
			Date now = new Date();
			String s1 = "ID: 0\tName: null\tBalance: $90.0";
			s1 += "\n" + now + "\tType: D\tAmount: $100.0\tBalance: $100.0\tDescription: Deposit $100.0";
			s1 += "\n" + now + "\tType: W\tAmount: $10.0\tBalance: $90.0\tDescription: Withdraw $10.0";
			
			String s2 = "ID: 2\tName: null\tBalance: $2480.0";
			s2 += "\n" + now + "\tType: D\tAmount: $1000.0\tBalance: $2000.0\tDescription: Deposit $1000.0";
			s2 += "\n" + now + "\tType: D\tAmount: $500.0\tBalance: $2500.0\tDescription: Deposit $500.0";
			s2 += "\n" + now + "\tType: W\tAmount: $10.0\tBalance: $2490.0\tDescription: Withdraw $10.0";
			s2 += "\n" + now + "\tType: W\tAmount: $10.0\tBalance: $2480.0\tDescription: Withdraw $10.0";
			
			String s3 = "ID: 1\tName: John\tBalance: $270.0";
			s3 += "\n" + now + "\tType: D\tAmount: $100.0\tBalance: $200.0\tDescription: Deposit $100.0";
			s3 += "\n" + now + "\tType: D\tAmount: $50.0\tBalance: $250.0\tDescription: Deposit $50.0";
			s3 += "\n" + now + "\tType: D\tAmount: $50.0\tBalance: $300.0\tDescription: Deposit $50.0";
			s3 += "\n" + now + "\tType: W\tAmount: $10.0\tBalance: $290.0\tDescription: Withdraw $10.0";
			s3 += "\n" + now + "\tType: W\tAmount: $10.0\tBalance: $280.0\tDescription: Withdraw $10.0";
			s3 += "\n" + now + "\tType: W\tAmount: $10.0\tBalance: $270.0\tDescription: Withdraw $10.0";
			
			System.out.println(acct1.toString());
			assertEquals(acct1.toString(), s1);
			assertEquals(acct2.toString(), s2);
			assertEquals(acct3.toString(), s3);
						
			balance.setAccessible(false);
			transactions.setAccessible(false);
			
		} catch(NoSuchMethodException ex) {
			fail("Unable to load one of your constructors or methods. Is it defined? Is it public?");
		} catch(InvocationTargetException ex) {
			fail("Unable to invoke a constructor or method.");
		} catch(IllegalAccessException ex) {
			fail("Unable to access a constructor, method, or properties");
		} catch(InstantiationException ex) {
			fail("Unable to instantiate an Account object.");
		} catch(NoSuchFieldException ex) {
			fail("The balance or transactions field does not exist.");
		}
	}
}
