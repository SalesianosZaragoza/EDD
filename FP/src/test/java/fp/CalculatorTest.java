package fp;


import static fp.Calculator.checkIsPalindrome;
import static fp.Calculator.classTypeOf;
import static fp.Calculator.divisors;
import static fp.Calculator.fibonacci;
import static fp.Calculator.isLeapYear;
import static fp.Calculator.isValidDate;
import static fp.Calculator.speakToMe;
import static fp.Calculator.stepThisNumber;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;


public class CalculatorTest {


	@Test
	public void testClassType() {
		assertNotNull(classTypeOf(0));
		assertEquals(classTypeOf(Integer.valueOf(0)), Integer.class);
		assertEquals(classTypeOf(Double.valueOf(0.5)), Double.class);
		assertEquals(classTypeOf(Float.valueOf(5)), Float.class);
		assertEquals(classTypeOf("a"), String.class);

		System.out.println("1P");
	}

	@Test
	public void testStepThisNumber() {
		assertNotNull(stepThisNumber(0, 0));
		assertArrayEquals(stepThisNumber(5, 1), new int[] { 4, 3, 2, 1 });
		assertArrayEquals(stepThisNumber(5, 2), new int[] { 3, 1 });
		assertArrayEquals(stepThisNumber(12, 3), new int[] { 9, 6, 3 });
		System.out.println("1P");
	}

	@Test
	public void testDivisors() {
		assertNull(divisors(0));
		assertArrayEquals(divisors(1), new int[] { 1 });
		assertArrayEquals(divisors(12), new int[] { 12, 6, 4, 3, 2, 1 });
		assertArrayEquals(divisors(20), new int[] { 20, 10, 5, 4, 2, 1 });
		System.out.println("1P");
	}

	@Test
	public void testIsPalindrome() {
		assertNotNull(checkIsPalindrome(null));
		assertTrue(
checkIsPalindrome("No Mara, sometamos o matemos a Ramón."));
		assertTrue(
checkIsPalindrome("¿Acaso hubo búhos acá?"));
		assertTrue(
checkIsPalindrome("No lata, no: la totalidad arada dilato talón a talón."));
		assertTrue(
checkIsPalindrome("Allí, tieta Mercè, faci cafè, crema, te i til·la"));
		assertTrue(
checkIsPalindrome("No Mara, sometamos o matemos a Ramón."));
		assertFalse(
				checkIsPalindrome("Buena suerte con los Test"));
		assertFalse(
checkIsPalindrome("4ª ley de kepler: gazpacho y mochilo siempre van con pincho"));
		assertFalse(
checkIsPalindrome("No me guardéis rencor, al menos no mucho"));
		System.out.println("2P");
	}

	@Test
	public void testSpeakToMe() {
		assertNotNull(speakToMe(0));
		assertEquals(speakToMe(0), "Cero");
		assertEquals(speakToMe(10), "Diez");
		assertEquals(speakToMe(20), "Veinte");
		assertEquals(speakToMe(60), "Sesenta");
		assertEquals(speakToMe(61), "Sesenta y uno");
		assertEquals(speakToMe(90), "Noventa");
		assertEquals(speakToMe(93), "Noventa y tres");
		System.out.println("2P");
	}

	@Test
	public void testIsLeapYear() {
		assertNotNull(isLeapYear(""));
		assertTrue(isLeapYear("01-01-1904"));
		assertTrue(isLeapYear("01-01-1928"));
		assertFalse(isLeapYear("01-01-2100"));
		assertTrue(isLeapYear("01-01-2000"));
		System.out.println("1P");
	}

	@Test
	public void testIsValidDate() {
		assertNotNull(isValidDate(""));
		assertTrue(isValidDate("01-01-0001"));
		assertTrue(isValidDate("31-12-2015"));
		assertFalse(isValidDate(""));
		assertFalse(isValidDate("asdasd"));
		assertFalse(isValidDate("21-12"));
		assertFalse(isValidDate("12-2000"));
		assertFalse(isValidDate("00-12-2000"));
		assertFalse(isValidDate("32-12-2000"));
		assertFalse(isValidDate("31-13-2000"));
		assertFalse(isValidDate("01-00-2000"));
		assertFalse(isValidDate("01-01-0000"));
		System.out.println("1P");
	}


	@Test
	public void testFibonacci() {

		int numberOfElements = 5;
		List<Integer> expResult = Arrays.asList(1, 1, 2, 3, 5);
		List<Integer> result = fibonacci(numberOfElements);
		assertEquals(expResult, result);

		numberOfElements = 10;
		expResult = Arrays.asList(1, 1, 2, 3, 5, 8, 13, 21, 34, 55);
		result = fibonacci(numberOfElements);
		assertEquals(expResult, result);
		System.out.println("1P");
	}

}
