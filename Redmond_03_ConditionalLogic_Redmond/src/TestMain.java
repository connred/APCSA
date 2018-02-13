import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class TestMain {
	
	ByteArrayInputStream in;
	ByteArrayOutputStream out;	
	String ls = System.lineSeparator();

	@Test
	public void test_3_1() {
		// DECIMALS OFF BY A VERY SMALL AMOUNT
		in = new ByteArrayInputStream("1.0 3 1".getBytes());
		out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		Main.ex_3_1();
		assertEquals("Enter a, b, c: The equation has two roots -0.3819660112501051 and -2.618033988749895", out.toString().trim());
		
		in = new ByteArrayInputStream("1 2.0 1".getBytes());
		out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		Main.ex_3_1();
		assertEquals("Enter a, b, c: The equation has one root -1.0", out.toString().trim());
		
		in = new ByteArrayInputStream("1 2 3".getBytes());
		out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		Main.ex_3_1();
		assertEquals("Enter a, b, c: The equation has no real roots", out.toString().trim());
	}
	
	@Test
	public void test_3_9() {
		// DECIMALS OFF BY A VERY SMALL AMOUNT
		in = new ByteArrayInputStream("013601267".getBytes());
		out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		Main.ex_3_9();
		assertEquals("Enter the first 9 ISBN digits: 0136012671", out.toString().trim());
		
		in = new ByteArrayInputStream("013031997".getBytes());
		out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		Main.ex_3_9();
		assertEquals("Enter the first 9 ISBN digits: 013031997X", out.toString().trim());
	}

	@Test
	public void test_3_11() { 
		in = new ByteArrayInputStream(("2" + ls + "2000").getBytes());
		out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		Main.ex_3_11();
		assertEquals("Enter the month: Enter the year: There are 29 days in that month on that year.", out.toString().trim());
		
		in = new ByteArrayInputStream(("2" + ls + "2100").getBytes());
		out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		Main.ex_3_11();
		assertEquals("Enter the month: Enter the year: There are 28 days in that month on that year.", out.toString().trim());

		in = new ByteArrayInputStream(("2" + ls + "2400").getBytes());
		out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		Main.ex_3_11();
		assertEquals("Enter the month: Enter the year: There are 29 days in that month on that year.", out.toString().trim());

		in = new ByteArrayInputStream(("2" + ls + "2012").getBytes());
		out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		Main.ex_3_11();
		assertEquals("Enter the month: Enter the year: There are 29 days in that month on that year.", out.toString().trim());

		in = new ByteArrayInputStream(("1" + ls + "2012").getBytes());
		out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		Main.ex_3_11();
		assertEquals("Enter the month: Enter the year: There are 31 days in that month on that year.", out.toString().trim());

		in = new ByteArrayInputStream(("3" + ls + "2010").getBytes());
		out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		Main.ex_3_11();
		assertEquals("Enter the month: Enter the year: There are 31 days in that month on that year.", out.toString().trim());

		in = new ByteArrayInputStream(("4" + ls + "2010").getBytes());
		out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		Main.ex_3_11();
		assertEquals("Enter the month: Enter the year: There are 30 days in that month on that year.", out.toString().trim());

		in = new ByteArrayInputStream(("5" + ls + "2010").getBytes());
		out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		Main.ex_3_11();
		assertEquals("Enter the month: Enter the year: There are 31 days in that month on that year.", out.toString().trim());

		in = new ByteArrayInputStream(("6" + ls + "2010").getBytes());
		out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		Main.ex_3_11();
		assertEquals("Enter the month: Enter the year: There are 30 days in that month on that year.", out.toString().trim());

		in = new ByteArrayInputStream(("7" + ls + "2010").getBytes());
		out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		Main.ex_3_11();
		assertEquals("Enter the month: Enter the year: There are 31 days in that month on that year.", out.toString().trim());

		in = new ByteArrayInputStream(("8" + ls + "2010").getBytes());
		out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		Main.ex_3_11();
		assertEquals("Enter the month: Enter the year: There are 31 days in that month on that year.", out.toString().trim());

		in = new ByteArrayInputStream(("9" + ls + "2010").getBytes());
		out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		Main.ex_3_11();
		assertEquals("Enter the month: Enter the year: There are 30 days in that month on that year.", out.toString().trim());

		in = new ByteArrayInputStream(("10" + ls + "2010").getBytes());
		out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		Main.ex_3_11();
		assertEquals("Enter the month: Enter the year: There are 31 days in that month on that year.", out.toString().trim());

		in = new ByteArrayInputStream(("11" + ls + "2010").getBytes());
		out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		Main.ex_3_11();
		assertEquals("Enter the month: Enter the year: There are 30 days in that month on that year.", out.toString().trim());

		in = new ByteArrayInputStream(("12" + ls + "2010").getBytes());
		out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		Main.ex_3_11();
		assertEquals("Enter the month: Enter the year: There are 31 days in that month on that year.", out.toString().trim());

	}
}
