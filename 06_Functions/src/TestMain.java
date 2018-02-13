import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.Test;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

public class TestMain {

	ByteArrayInputStream in;
	ByteArrayOutputStream out;	
	String ls = System.lineSeparator();
	
	@Test
	public void test_6_1() throws IOException {
		out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		Main.ex_6_1();
		String s2 = "	1	5	12	22	35	51	70	92	117	145	"
		+ ls + "		176	210	247	287	330	376	425	477	532	590"
		+ ls + "651	715	782	852	925	1001	1080	1162	1247	1335	"
		+ ls + "1426	1520	1617	1717	1820	1926	2035	2147	2262	2380	"
		+ ls + "2501	2625	2752	2882	3015	3151	3290	3432	3577	3725	"
		+ ls + "3876	4030	4187	4347	4510	4676	4845	5017	5192	5370	"
		+ ls + "5551	5735	5922	6112	6305	6501	6700	6902	7107	7315	"
		+ ls + "7526	7740	7957	8177	8400	8626	8855	9087	9322	9560	"
		+ ls + "9801	10045	10292	10542	10795	11051	11310	11572	11837	12105	"
		+ ls + "12376	12650	12927	13207	13490	13776	14065	14357	14652	14950	";
		assertEquals(out.toString().trim(), s2.trim());
	}
	
	@Test
	public void testGetPentagonalNumber() {
		assertEquals(0, Main.getPentagonalNumber(0));
		assertEquals(1, Main.getPentagonalNumber(1));
		assertEquals(5, Main.getPentagonalNumber(2));
		assertEquals(145, Main.getPentagonalNumber(10));
		assertEquals(590, Main.getPentagonalNumber(20));
		assertEquals(1617, Main.getPentagonalNumber(33));
		assertEquals(17120, Main.getPentagonalNumber(107));
	}
	
	@Test
	public void testSumDigits() {
		assertEquals(6, Main.sumDigits(123L));
		assertEquals(10, Main.sumDigits(1234L));
		assertEquals(0, Main.sumDigits(0));
		assertEquals(1, Main.sumDigits(1));
		assertEquals(9, Main.sumDigits(234L));
	}
	
	@Test
	public void testReverse() {
		assertEquals(321, Main.reverse(123));
		assertEquals(0, Main.reverse(0));
		assertEquals(1111, Main.reverse(1111));
		assertEquals(123456, Main.reverse(654321));
		assertEquals(-9876, Main.reverse(-6789));
	}
	
	@Test
	public void testIsPalindrome() {
		assertEquals(false, Main.isPalindrome(123));
		assertEquals(true, Main.isPalindrome(0));
		assertEquals(true, Main.isPalindrome(12321));
		assertEquals(true, Main.isPalindrome(123321));
		assertEquals(false, Main.isPalindrome(12));
		assertEquals(true, Main.isPalindrome(-12321));
		assertEquals(true, Main.isPalindrome(1111111111));
	}
	
	@Test
	public void testIsValidPassword() {
		assertEquals(true, Main.isValidPassword("asdf1234"));
		assertEquals(false, Main.isValidPassword("asdf"));
		assertEquals(false, Main.isValidPassword("╥sdf1234"));
		assertEquals(true, Main.isValidPassword("ìsdf1234"));
		assertEquals(true, Main.isValidPassword("ùsdf1234"));
		assertEquals(true, Main.isValidPassword("111111111"));
		assertEquals(false, Main.isValidPassword("asdf123"));
		assertEquals(false, Main.isValidPassword("aaaaaaaa1"));
		assertEquals(false, Main.isValidPassword("aaaaaaaa"));
		assertEquals(false, Main.isValidPassword("abcde23"));
	}
	
	@Test
	public void testIsValid() {
		assertEquals(true, Main.isValid(4388576018410707L));
		assertEquals(false, Main.isValid(4388576018402626L));
		assertEquals(true, Main.isValid(5105105105105100L));
		assertEquals(true, Main.isValid(4111111111111111L));
		assertEquals(true, Main.isValid(4012888888881881L));
		assertEquals(true, Main.isValid(4222222222222L));

		assertEquals(false, Main.isValid(4088576018410707L));
		assertEquals(false, Main.isValid(4088576018402626L));
		assertEquals(false, Main.isValid(5005105105105100L));
		assertEquals(false, Main.isValid(4011111111111111L));
		assertEquals(false, Main.isValid(4112888888881881L));
		assertEquals(false, Main.isValid(4322222222222L));
		
		assertEquals(false, Main.isValid(1388576018410707L));
		assertEquals(false, Main.isValid(2388576018402626L));
		assertEquals(false, Main.isValid(3105105105105100L));
		assertEquals(false, Main.isValid(7111111111111111L));
		assertEquals(false, Main.isValid(8012888888881881L));
	}
	
	@Test
	public void testSumOfDoubleEvenPlace() {
		assertEquals(1, Main.sumOfDoubleEvenPlace(50));
		assertEquals(8, Main.sumOfDoubleEvenPlace(2222));
		assertEquals(14, Main.sumOfDoubleEvenPlace(8888));
		assertEquals(0, Main.sumOfDoubleEvenPlace(0));
		assertEquals(2, Main.sumOfDoubleEvenPlace(11));
		assertEquals(2, Main.sumOfDoubleEvenPlace(111));
		assertEquals(37, Main.sumOfDoubleEvenPlace(4388576018402626L));
	}
	
	@Test
	public void testGetDigit() {
		assertEquals(8, Main.getDigit(8));
		assertEquals(7, Main.getDigit(16));
		assertEquals(1, Main.getDigit(10));
		assertEquals(0, Main.getDigit(0));
		assertEquals(3, Main.getDigit(3));
		assertEquals(9, Main.getDigit(18));
	}
	
	@Test
	public void testSumOfOddPlace() {
		assertEquals(2, Main.sumOfOddPlace(111));
		assertEquals(2, Main.sumOfOddPlace(1111));
		assertEquals(1, Main.sumOfOddPlace(1));
		assertEquals(38, Main.sumOfOddPlace(4388576018402626L));
		assertEquals(41, Main.sumOfOddPlace(4388576018410707L));
		assertEquals(15, Main.sumOfOddPlace(55555));
		assertEquals(0, Main.sumOfOddPlace(0));
		assertEquals(0, Main.sumOfOddPlace(10));
		assertEquals(15, Main.sumOfOddPlace(679));
		assertEquals(32, Main.sumOfOddPlace(88888888));
	}
	
	@Test
	public void testPrefixMatched() {
		assertEquals(true, Main.prefixMatched(371234, 37));
		assertEquals(false, Main.prefixMatched(3743742, 34));
	}
	
	@Test
	public void testGetSize() {
		assertEquals(16, Main.getSize(4388576018402626L));
		assertEquals(1, Main.getSize(1L));
		assertEquals(3, Main.getSize(421L));
		assertEquals(10, Main.getSize(1234567890L));
		assertEquals(0, Main.getSize(0));
	}
	
	@Test
	public void testGetPrefix() {
		assertEquals(1, Main.getPrefix(1234L, 1));
		assertEquals(37, Main.getPrefix(3746567L, 2));
		assertEquals(0, Main.getPrefix(1234, 0));
		assertEquals(1234, Main.getPrefix(12345661234L, 4));
		assertEquals(1234, Main.getPrefix(1234, 8));
	}
	
	@Test
	public void testArea() {
		double t1 = Main.area(5, 6.5);
		assertEquals(true, t1 > 72 && t1 < 73);
	}
	}
