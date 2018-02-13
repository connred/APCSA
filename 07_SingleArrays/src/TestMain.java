import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.text.DecimalFormat;
import java.util.Arrays;

import org.junit.Test;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

public class TestMain {

	ByteArrayInputStream in;
	ByteArrayOutputStream out;
	String ls = System.lineSeparator();
	
	@Test // 7.0
	public void test_randomDigitArray() {
		int[] a = Main.randomDigitArray(10);
		int[] b = Main.randomDigitArray(10);
		assertEquals(false, Arrays.equals(a, b));
		boolean allSingles = true;
		for(int i = 0; i < a.length; i++) {
			if(a[i] > 9)
				allSingles = false;
			else if (a[i] < -9)
				allSingles = false;
		}
		assertEquals(true, allSingles);
	}

	@Test // 7.1
	public void test_linearSearch() {
		int[] e = { 0, 1, 2, 1, 0, 4, 5, 4, -2, 7, 8, 0, 2, 2 };
		assertEquals(0, Main.linearSearch(e, 0));
		assertEquals(5, Main.linearSearch(e, 4));
		assertEquals(1, Main.linearSearch(e, 1));
		assertEquals(2, Main.linearSearch(e, 2));
		assertEquals(10, Main.linearSearch(e, 8));
		assertEquals(-1, Main.linearSearch(e, -1));
		assertEquals(-1, Main.linearSearch(e, 9));
		assertEquals(-1, Main.linearSearch(e, 10));
	}

	@Test // 7.2
	public void test_sum() {
		int[] a = {};
		int[] b = { 1 };
		int[] c = { 0 };
		int[] d = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int[] e = { -1, -2, 0, -88, -101, 1001 };
		int[] f = { 0, 1, -4, 04 };
		int[] g = { -1, 0, 1 };
		assertEquals(Main.sum(a), 0);
		assertEquals(Main.sum(b), 1);
		assertEquals(Main.sum(c), 0);
		assertEquals(Main.sum(d), 45);
		assertEquals(Main.sum(e), 809);
		assertEquals(Main.sum(f), 1);
		assertEquals(Main.sum(g), 0);
	}

	@Test // 7.3
	public void test_reverse() {
		int[] a1 = { 0 };
		int[] a2 = { 0 };
		int[] b1 = { 1, 2 };
		int[] b2 = { 2, 1 };
		int[] c1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int[] c2 = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		
		Main.reverse(a1);
		assertEquals(true, Arrays.equals(a1, a2));
		Main.reverse(b1);
		assertEquals(true, Arrays.equals(b1, b2));
		Main.reverse(c1);
		assertEquals(true, Arrays.equals(c1, c2));
		Main.reverse(c2);
	}

	@Test // 7.4
	public void test_mostFrequentElement() {
		int[] a = { 1, 2, 2, 3, 3, 3, 4, 4, 4, 4 };
		int[] b = { 0, 0, 0, 0, 0, 1, 1, 1, 1, 1 };
		int[] c = { 0, 0, 0, 1, 1 };
		int[] d = { 9, 9, 8, 7, 4, 4, 4, 2 };
		int[] e = { 0, 1, 2, 1, 0, 4, 5, 4, 2, 7, 8, 0, 2, 2 };
		assertEquals(4, Main.mostFrequentElement(a));
		assertEquals(0, Main.mostFrequentElement(b));
		assertEquals(0, Main.mostFrequentElement(c));
		assertEquals(4, Main.mostFrequentElement(d));
		assertEquals(2, Main.mostFrequentElement(e));
	}

	/*@Test // 7.5
	public void test_distinctNumbers() throws IOException {
		in = new ByteArrayInputStream(("100 1001 208 5986 43065 1001 208 100 1001 5986").getBytes());
		out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		Main.distinctNumbers();
		String s = Files.toString(new File("distinctNumbers1.txt"), Charsets.UTF_8);
		assertEquals(s.trim(), out.toString().trim());

		in = new ByteArrayInputStream(("1 2 3 2 1 6 3 4 5 2").getBytes());
		out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		Main.distinctNumbers();
		s = Files.toString(new File("distinctNumbers2.txt"), Charsets.UTF_8);
		assertEquals(s.trim(), out.toString().trim());
	}*/

	@Test // 7.6a
	public void test_ex_7_6() throws IOException {
		in = new ByteArrayInputStream(("00011115").getBytes());
		out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		Main.ex_7_6();
		String s = Files.toString(new File("singleDigitCounts1.txt"), Charsets.UTF_8);
		assertEquals(s.trim(), out.toString().trim());
		
		in = new ByteArrayInputStream(("1223334444").getBytes());
		out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		Main.ex_7_6();
		s = Files.toString(new File("singleDigitCounts2.txt"), Charsets.UTF_8);
		assertEquals(s.trim(), out.toString().trim());
	}

	@Test // 7.6b
	public void test_countSingleDigits() {
		int n = 1223334444;
		int[] na = new int[] { 0, 1, 2, 3, 4, 0, 0, 0, 0, 0 };
		int m = 234234001;
		int[] ma = new int[] { 2, 1, 2, 2, 2, 0, 0, 0, 0, 0 };
		assertEquals(true, Arrays.equals(na, Main.countSingleDigits(n)));
		assertEquals(true, Arrays.equals(ma, Main.countSingleDigits(m)));
	}
	
	@Test // 7.7a
	public void test_deviance() {
		double[] x = new double[]{1.9,2.5,3.7,2,1,6,3,4,5,2};
		double dev = Main.deviation(x);
		DecimalFormat df = new DecimalFormat("#0.###");
		assertEquals("1.557", df.format(dev));
		
		x = new double[]{13,23,12,44,55};
		dev = Main.deviation(x);
		assertEquals("19.243", df.format(dev));
	}
	
	@Test // 7.7b
	public void test_mean() {
		double[] x = new double[]{1.9,2.5,3.7,2,1,6,3,4,5,2};
		double mean = Main.mean(x);
		DecimalFormat df = new DecimalFormat("#0.###");
		assertEquals("3.11", df.format(mean));
		
		x = new double[]{13,23,12,44,55};
		mean = Main.mean(x);
		assertEquals("29.4", df.format(mean));
	}

	@Test // 7.8
	public void test_sortStudentsByTestScore() {
		String[] stu1 = { "John", "Mary", "Paul", "Francis" };
		double[] sco1 = { 44, 88, 92, 77 };
		Main.sortStudentsByTestScore(stu1, sco1);
		String[] stu1sorted = { "Paul", "Mary", "Francis", "John" };
		double[] sco1sorted = { 92, 88, 77, 44 };
		assertEquals(true, Arrays.equals(stu1, stu1sorted));
		assertEquals(true, Arrays.equals(sco1, sco1sorted));
		
		String[] stu2 = { "Bill", "Blaire", "Bob", "Bishop" };
		double[] sco2 = { 70, 80, 60, 90 };
		Main.sortStudentsByTestScore(stu2, sco2);
		String[] stu2sorted = { "Bishop", "Blaire", "Bill", "Bob" };
		double[] sco2sorted = { 90, 80, 70, 60 };
		assertEquals(true, Arrays.equals(stu2, stu2sorted));
		assertEquals(true, Arrays.equals(sco2, sco2sorted));
		
		String[] stu3 = { "Beth", "Betty", "Bless", "Barb" };
		double[] sco3 = { 70, 70, 80, 80 };
		Main.sortStudentsByTestScore(stu3, sco3);
		String[] stu3sorted = { "Bless", "Barb", "Beth", "Betty" };
		double[] sco3sorted = { 80, 80, 70, 70 };
		assertEquals(true, Arrays.equals(stu3, stu3sorted));
		assertEquals(true, Arrays.equals(sco3, sco3sorted));
	}

	@Test // 7.9
	public void test_isDescending() {
		int[] a = { 9, 8, 7, 6 };
		int[] b = { 6, 7, 8, 9 };
		int[] c = { 8, 8, 8, 7 };
		int[] d = new int[0];
		int[] e = { -1, -1, -1 };
		int[] f = { -1 };
		assertEquals(true, Main.isDescending(a));
		assertEquals(false, Main.isDescending(b));
		assertEquals(true, Main.isDescending(c));
		assertEquals(true, Main.isDescending(d));
		assertEquals(true, Main.isDescending(e));
		assertEquals(true, Main.isDescending(f));
	}

	@Test // 7.9
	public void test_isAscending() {
		int[] a = { 6, 7, 8, 9 };
		int[] b = { 9, 8, 7, 6 };
		int[] c = { 8, 8, 8, 9 };
		int[] d = new int[0];
		int[] e = { -1, -1, -1 };
		int[] f = { -1 };
		int[] g = { 0 };
		int[] h = {};
		assertEquals(true, Main.isAscending(a));
		assertEquals(false, Main.isAscending(b));
		assertEquals(true, Main.isAscending(c));
		assertEquals(true, Main.isAscending(d));
		assertEquals(true, Main.isAscending(e));
		assertEquals(true, Main.isAscending(f));
		assertEquals(true, Main.isAscending(g));
		assertEquals(true, Main.isAscending(h));
	}

	@Test // 7.9
	public void test_isSorted() {
		int[] a = { 9, 8, 7, 6 };
		int[] b = { 6, 7, 8, 9 };
		assertEquals(true, Main.isSorted(a));
		assertEquals(true, Main.isSorted(b));
	}

	/*@Test // 7.10
	public void test_ex_7_10() throws IOException {
		in = new ByteArrayInputStream(("2 5 6 5 4 3 23 43 2 0").getBytes());
		out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		Main.ex_7_10();
		String s = Files.toString(new File("ex_7_10.txt"), Charsets.UTF_8);
		assertEquals(s.trim(), out.toString().trim());
		
		in = new ByteArrayInputStream(("1 15 26 25 34 43 23 43 100 0").getBytes());
		out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		Main.ex_7_10();
		s = Files.toString(new File("ex_7_10a.txt"), Charsets.UTF_8);
		assertEquals(s.trim(), out.toString().trim());
	}*/
	
	@Test // 7.11a
	public void test_indexOfSmallestElement() {
		assertEquals(1, Main.indexOfSmallestElement(new double[] { 2, 1, 2, 3, 4, 5, 6 }));
		assertEquals(0, Main.indexOfSmallestElement(new double[] { 0, 1, 2 }));
		assertEquals(9, Main.indexOfSmallestElement(new double[] { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 }));
		assertEquals(1, Main.indexOfSmallestElement(new double[] { 4, 1, 2, 1, 4 }));
	}
	
	@Test // 7.11b
	public void test_removeSmallestElement() {
		double[] before1 = { 2, 1, 2, 3, 4, 5, 6 };
		double[] after1  = { 2, 2, 3, 4, 5, 6 };
		double[] removed = Main.removeSmallestElement(before1);
		assertEquals(true, Arrays.equals(after1, removed));
		
		before1 = new double[]{ 0, 1, 2 };
		after1 = new double[]{ 1, 2 };
		removed = Main.removeSmallestElement(before1);
		assertEquals(true, Arrays.equals(after1, removed));
		
		before1 = new double[]{ 1, 2, 0 };
		after1 = new double[]{ 1, 2 };
		removed = Main.removeSmallestElement(before1);
		assertEquals(true, Arrays.equals(after1, removed));
		
		before1 = new double[]{1};
		after1 = new double[]{};
		removed = Main.removeSmallestElement(before1);
		assertEquals(true, Arrays.equals(after1, removed));
		
	}

	@Test // 7.12
	public void test_sumsOnSides() {
		int[] a = {1,2,3,9,3,2,1};
		int[] b = {0,2,3,9,3,2,1};
		int[] c = {1,1,1,1,1,9,2,3};
		assertEquals(3, Main.indexOfBalancedSums(a));
		assertEquals(-1, Main.indexOfBalancedSums(b));
		assertEquals(5, Main.indexOfBalancedSums(c));
	}
	
	@Test // 7.13
	public void test_zip() {
		int[] a = {1,2,3};
		int[] b = {4,5,6};
		int[] ab = {1,4,2,5,3,6};
		assertEquals(true, Arrays.equals(ab, Main.zip(a, b)));
		int[] bab = {4,1,5,4,6,2,5,3,6};
		assertEquals(true, Arrays.equals(bab, Main.zip(b, ab)));
		int[] zero1 = new int[0];
		int[] zero2 = new int[0];
		assertEquals(true, Arrays.equals(new int[0], Main.zip(zero1, zero2)));
		assertEquals(false, Arrays.equals(a,Main.zip(a, b)));
		int[] one1 = {1};
		assertEquals(true, Arrays.equals(one1, Main.zip(zero1, one1)));
		assertEquals(true, Arrays.equals(one1, Main.zip(one1, zero2)));
	}
}
