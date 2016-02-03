package fp;

import static fp.Calculator.checkMyBet;
import static fp.Calculator.divisors;
import static fp.Calculator.isLeapYear;
import static fp.Calculator.isValidDate;
import static fp.Calculator.sin;
import static fp.Calculator.speakToMe;
import static fp.Calculator.stepThisNumber;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void testSin() {
		assertNotNull(sin(0));
		assertEquals(sin(30), Double.valueOf(0.5));
		assertEquals(sin(90), Double.valueOf(1));
		assertEquals(sin(270), Double.valueOf(-1));
		assertEquals(sin(810), Double.valueOf(1));
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
	public void testCheckMyBet() {
		assertNotNull(checkMyBet(null, null));
		assertEquals(
				checkMyBet(Arrays.asList(1, 2, 3, 4, 5, 6),
						Arrays.asList(1, 2, 3, 4, 5, 6)), Integer.valueOf(6));
		assertEquals(
				checkMyBet(Arrays.asList(2, 1, 4, 3, 6, 5),
						Arrays.asList(1, 2, 3, 4, 5, 6)), Integer.valueOf(0));
		assertEquals(
				checkMyBet(Arrays.asList(1, 2, 3, 4, 5, 6),
						Arrays.asList(5, 5, 5, 5, 5, 5)), Integer.valueOf(1));
		assertEquals(
				checkMyBet(Arrays.asList(1, 2, 3, 4, 7, 6),
						Arrays.asList(5, 5, 5, 5, 5, 5)), Integer.valueOf(0));
		assertEquals(
				checkMyBet(Arrays.asList(1, 1, 2, 2, 3, 3),
						Arrays.asList(6, 6, 2, 5, 3, 5)), Integer.valueOf(2));
		System.out.println("1P");
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
		System.out.println("2P");
	}

}
