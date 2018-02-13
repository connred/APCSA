import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.Test;

public class TestMain {
	
	ByteArrayInputStream in;
	ByteArrayOutputStream out;	
	String ls = System.lineSeparator();
	
	@Test
	public void test_4_15() {
		char letter = 'A';
		in = new ByteArrayInputStream(String.valueOf(letter).getBytes());
		out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		Main.ex_4_15();
		assertEquals("Enter a letter: The corresponding number is 2", out.toString().trim());

		letter = 'b';
		in = new ByteArrayInputStream(String.valueOf(letter).getBytes());
		out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		Main.ex_4_15();
		assertEquals("Enter a letter: The corresponding number is 2", out.toString().trim());

		letter = 'c';
		in = new ByteArrayInputStream(String.valueOf(letter).getBytes());
		out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		Main.ex_4_15();
		assertEquals("Enter a letter: The corresponding number is 2", out.toString().trim());

		letter = 'D';
		in = new ByteArrayInputStream(String.valueOf(letter).getBytes());
		out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		Main.ex_4_15();
		assertEquals("Enter a letter: The corresponding number is 3", out.toString().trim());

		letter = 'e';
		in = new ByteArrayInputStream(String.valueOf(letter).getBytes());
		out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		Main.ex_4_15();
		assertEquals("Enter a letter: The corresponding number is 3", out.toString().trim());

		letter = 'f';
		in = new ByteArrayInputStream(String.valueOf(letter).getBytes());
		out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		Main.ex_4_15();
		assertEquals("Enter a letter: The corresponding number is 3", out.toString().trim());

		letter = 'g';
		in = new ByteArrayInputStream(String.valueOf(letter).getBytes());
		out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		Main.ex_4_15();
		assertEquals("Enter a letter: The corresponding number is 4", out.toString().trim());

		letter = 'h';
		in = new ByteArrayInputStream(String.valueOf(letter).getBytes());
		out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		Main.ex_4_15();
		assertEquals("Enter a letter: The corresponding number is 4", out.toString().trim());

		letter = 'i';
		in = new ByteArrayInputStream(String.valueOf(letter).getBytes());
		out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		Main.ex_4_15();
		assertEquals("Enter a letter: The corresponding number is 4", out.toString().trim());

		letter = 'j';
		in = new ByteArrayInputStream(String.valueOf(letter).getBytes());
		out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		Main.ex_4_15();
		assertEquals("Enter a letter: The corresponding number is 5", out.toString().trim());

		letter = 'K';
		in = new ByteArrayInputStream(String.valueOf(letter).getBytes());
		out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		Main.ex_4_15();
		assertEquals("Enter a letter: The corresponding number is 5", out.toString().trim());

		letter = 'l';
		in = new ByteArrayInputStream(String.valueOf(letter).getBytes());
		out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		Main.ex_4_15();
		assertEquals("Enter a letter: The corresponding number is 5", out.toString().trim());

		letter = 'm';
		in = new ByteArrayInputStream(String.valueOf(letter).getBytes());
		out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		Main.ex_4_15();
		assertEquals("Enter a letter: The corresponding number is 6", out.toString().trim());

		letter = 'n';
		in = new ByteArrayInputStream(String.valueOf(letter).getBytes());
		out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		Main.ex_4_15();
		assertEquals("Enter a letter: The corresponding number is 6", out.toString().trim());

		letter = 'o';
		in = new ByteArrayInputStream(String.valueOf(letter).getBytes());
		out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		Main.ex_4_15();
		assertEquals("Enter a letter: The corresponding number is 6", out.toString().trim());

		letter = 'p';
		in = new ByteArrayInputStream(String.valueOf(letter).getBytes());
		out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		Main.ex_4_15();
		assertEquals("Enter a letter: The corresponding number is 7", out.toString().trim());

		letter = 'q';
		in = new ByteArrayInputStream(String.valueOf(letter).getBytes());
		out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		Main.ex_4_15();
		assertEquals("Enter a letter: The corresponding number is 7", out.toString().trim());

		letter = 'r';
		in = new ByteArrayInputStream(String.valueOf(letter).getBytes());
		out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		Main.ex_4_15();
		assertEquals("Enter a letter: The corresponding number is 7", out.toString().trim());

		letter = 's';
		in = new ByteArrayInputStream(String.valueOf(letter).getBytes());
		out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		Main.ex_4_15();
		assertEquals("Enter a letter: The corresponding number is 7", out.toString().trim());

		letter = 'T';
		in = new ByteArrayInputStream(String.valueOf(letter).getBytes());
		out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		Main.ex_4_15();
		assertEquals("Enter a letter: The corresponding number is 8", out.toString().trim());

		letter = 'u';
		in = new ByteArrayInputStream(String.valueOf(letter).getBytes());
		out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		Main.ex_4_15();
		assertEquals("Enter a letter: The corresponding number is 8", out.toString().trim());

		letter = 'v';
		in = new ByteArrayInputStream(String.valueOf(letter).getBytes());
		out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		Main.ex_4_15();
		assertEquals("Enter a letter: The corresponding number is 8", out.toString().trim());

		letter = 'w';
		in = new ByteArrayInputStream(String.valueOf(letter).getBytes());
		out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		Main.ex_4_15();
		assertEquals("Enter a letter: The corresponding number is 9", out.toString().trim());

		letter = 'x';
		in = new ByteArrayInputStream(String.valueOf(letter).getBytes());
		out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		Main.ex_4_15();
		assertEquals("Enter a letter: The corresponding number is 9", out.toString().trim());

		letter = 'y';
		in = new ByteArrayInputStream(String.valueOf(letter).getBytes());
		out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		Main.ex_4_15();
		assertEquals("Enter a letter: The corresponding number is 9", out.toString().trim());

		letter = 'z';
		in = new ByteArrayInputStream(String.valueOf(letter).getBytes());
		out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		Main.ex_4_15();
		assertEquals("Enter a letter: The corresponding number is 9", out.toString().trim());
		
		letter = '+';
		in = new ByteArrayInputStream(String.valueOf(letter).getBytes());
		out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		Main.ex_4_15();
		assertEquals("Enter a letter: + is an invalid input", out.toString().trim());

		letter = '#';
		in = new ByteArrayInputStream(String.valueOf(letter).getBytes());
		out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		Main.ex_4_15();
		assertEquals("Enter a letter: # is an invalid input", out.toString().trim());
	}
	
	@Test
	public void test_4_20() {
		in = new ByteArrayInputStream("Hello World".getBytes());
		out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		Main.ex_4_20();
		assertEquals("Enter a String: Length = 11, Character = H", out.toString().trim());

		in = new ByteArrayInputStream("dog".getBytes());
		out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		Main.ex_4_20();
		assertEquals("Enter a String: Length = 3, Character = d", out.toString().trim());
	}
	
	@Test
	public void test_4_22() throws IOException {
		in = new ByteArrayInputStream(("1234asdf" + ls + "asdf").getBytes());
		out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		Main.ex_4_22();
		assertEquals("Enter String 1: Enter String 2: String 2 is a substring of String 1.", out.toString().trim());

		in = new ByteArrayInputStream(("1234asdf" + ls + "a123").getBytes());
		out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		Main.ex_4_22();
		assertEquals("Enter String 1: Enter String 2: String 2 is not a substring of String 1.", out.toString().trim());

		in = new ByteArrayInputStream(("ASDF" + ls + "asdf").getBytes());
		out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		Main.ex_4_22();
		assertEquals("Enter String 1: Enter String 2: String 2 is not a substring of String 1.", out.toString().trim());

		in = new ByteArrayInputStream(("1234" + ls + "12").getBytes());
		out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		Main.ex_4_22();
		assertEquals("Enter String 1: Enter String 2: String 2 is a substring of String 1.", out.toString().trim());
	}
	
	@Test
	public void test_4_23() {
		in = new ByteArrayInputStream(("Smith" + ls + "10" + ls + "9.75" + ls + "0.20" + ls + "0.09").getBytes());
		out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		Main.ex_4_23();
		assertEquals("Employee name: Hours worked this week: Hourly pay rate: Federal tax rate: State tax rate: " + ls + "Employee Name: Smith" + ls + "Hours Worked: 10.0" + ls + "Pay Rate: $9.75" + ls + "Gross Pay: $97.5" + ls + "Deductions:" + ls + "  Federal Withholding (20.0%): $19.5" + ls + "  State Withholding (9.0%): $8.775" + ls + "  Total Deduction: $28.275" + ls + "Net Pay: $69.225", out.toString().trim());

	}
	
	@Test
	public void test_4_26() {
		in = new ByteArrayInputStream("2.2".getBytes());
		out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		Main.ex_4_26();
		assertEquals("Enter a dollar amount in double, for example 11.56: 2 dollars, 2 cents", out.toString().trim());

		in = new ByteArrayInputStream("1".getBytes());
		out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		Main.ex_4_26();
		assertEquals("Enter a dollar amount in double, for example 11.56: 1 dollar", out.toString().trim());

		in = new ByteArrayInputStream("0.1".getBytes());
		out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		Main.ex_4_26();
		assertEquals("Enter a dollar amount in double, for example 11.56: 0 dollars, 1 cent", out.toString().trim());

		in = new ByteArrayInputStream("2".getBytes());
		out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		Main.ex_4_26();
		assertEquals("Enter a dollar amount in double, for example 11.56: 2 dollars", out.toString().trim());

		in = new ByteArrayInputStream("11.56".getBytes());
		out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		Main.ex_4_26();
		assertEquals("Enter a dollar amount in double, for example 11.56: 11 dollars, 56 cents", out.toString().trim());

	}
}
