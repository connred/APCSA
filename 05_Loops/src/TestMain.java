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
	public void test_5_1() {
		in = new ByteArrayInputStream("1 2 -1 3 0".getBytes());
		out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		Main.ex_5_1();
		String console = "Enter an integer, the input ends if it is 0: " 
				+ "The number of positives is 3"
				+ ls + "The number of negatives is 1"
				+ ls + "The total is 5.0"
				+ ls + "The average is 1.25";
		assertEquals(console, out.toString().trim());
		
		in = new ByteArrayInputStream("1 2 -1 -2 -3 1 1 0".getBytes());
		out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		Main.ex_5_1();
		console = "Enter an integer, the input ends if it is 0: " 
				+ "The number of positives is 4"
				+ ls + "The number of negatives is 3"
				+ ls + "The total is -1.0"
				+ ls + "The average is -0.14285714285714285";
		assertEquals(console, out.toString().trim());
		
		in = new ByteArrayInputStream("0".getBytes());
		out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		Main.ex_5_1();
		console = "Enter an integer, the input ends if it is 0: " 
				+ "No numbers are entered except 0";
		assertEquals(console, out.toString().trim());
	}
	
	@Test
	public void test_5_7() {
		out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		Main.ex_5_7();
		String console = "Tuition after 10 years = 16288.946267774414" 
				+ ls + "Tuition cost for years 11, 12, 13, and 14 = 73717.76425901074";
		assertEquals(console, out.toString().trim());
	}

	@Test
	public void test_5_10() {
		out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		Main.ex_5_10();
		String console = 
				"120 150 180 210 240 270 300 330 360 390 " + ls +
				"420 450 480 510 540 570 600 630 660 690 " + ls +
				"720 750 780 810 840 870 900 930 960 990";
		assertEquals(console, out.toString().trim());
	}
	
	@Test
	public void test_5_12() {
		out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		Main.ex_5_12();
		String console = "110 x 110 = 12100";
		assertEquals(console, out.toString().trim());
	}
	
	@Test
	public void test_5_13() {
		out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		Main.ex_5_13();
		String console = "22 x 22 x 22 = 10648";
		assertEquals(console, out.toString().trim());
	}
	
	@Test
	public void test_5_30() {
		in = new ByteArrayInputStream("100 0.05 3".getBytes());
		out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		Main.ex_5_30();
		String console = 
				"Recurring investment: " +
				"Annual interest rate: " +
				"Number of months: " +
				"Compound savings = 302.50695167824074";
		assertEquals(console, out.toString().trim());
		
		in = new ByteArrayInputStream("50 0.08 24".getBytes());
		out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		Main.ex_5_30();
		console = 
				"Recurring investment: " +
				"Annual interest rate: " +
				"Number of months: " +
				"Compound savings = 1305.3038846771008";
		assertEquals(console, out.toString().trim());
	}

	@Test
	public void test_5_41() {
		in = new ByteArrayInputStream("3 5 2 5 5 5 0".getBytes());
		out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		Main.ex_5_41();
		String console = 
				"Enter numbers: " +
			    "The largest number is 5" + ls +
			    "The occurrence count of the largest number is 4";
		assertEquals(console, out.toString().trim());
		
		in = new ByteArrayInputStream("4 3 2 1 4 3 2 1 4 4 1 1 1 1 1 1 0".getBytes());
		out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		Main.ex_5_41();
		console = 
				"Enter numbers: " +
			    "The largest number is 4" + ls +
			    "The occurrence count of the largest number is 4";
		assertEquals(console, out.toString().trim());
		
	}

	@Test
	public void test_5_43() {
		in = new ByteArrayInputStream("3 5 2 5 5 5 0".getBytes());
		out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		Main.ex_5_43();
		String console = 
				"1 2" + ls +
				"1 3" + ls +
				"1 4" + ls +
				"1 5" + ls +
				"1 6" + ls +
				"1 7" + ls +
				"2 3" + ls +
				"2 4" + ls +
				"2 5" + ls +
				"2 6" + ls +
				"2 7" + ls +
				"3 4" + ls +
				"3 5" + ls +
				"3 6" + ls +
				"3 7" + ls +
				"4 5" + ls +
				"4 6" + ls +
				"4 7" + ls +
				"5 6" + ls +
				"5 7" + ls +
				"6 7" + ls +
				"The total number of all is 21";
		assertEquals(console, out.toString().trim());
	}
}
