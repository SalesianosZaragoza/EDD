package testJunit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class Miclase2Test {

	MiClase clase;

	@BeforeEach
	public void antesdecadatest() {
		clase = new MiClase();
		System.out.println("hola mundo");
	}

	@BeforeAll
	public static void alprincipiodeltodo() {
		System.out.println("Inicio");
	}

	@AfterAll
	public static void alfinaldeltodo() {
		System.out.println("Final");
	}

	@AfterEach
	public void despuesdecadatest() {
		System.out.println("adios mundo");
	}

	@Test
	public void testSumTwoNumbers() {

		int sumTwoNumbers = clase.sumTwoNumbers(0, 1);
		System.out.println(sumTwoNumbers);
		assertEquals(1, sumTwoNumbers);

	}

	@Test
	public void testAsssertsame() {
		MiClase a = new MiClase();
		MiClase b = a;// new MiClase();
		assertSame(a, b);

	}

	@Test
	public void testSumTwoNumbersIfTheyNotZero() {
		int sumTwoNumbers = 0;
		try {
			sumTwoNumbers = clase.sumTwoNumbersIfTheyNotZero(3, 2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(5, sumTwoNumbers);
	}

	@Test
	public void testSumTwoNumbersIfTheyAreZero() {
		try {
			clase.sumTwoNumbersIfTheyNotZero(0, 0);
			fail();
		} catch (Exception e) {
		}
	}

	@Test
	public void testSumTwoNumbersIfTheyAreZeroUsingThrowsAssert() {
		assertThrows(Exception.class, () -> clase.sumTwoNumbersIfTheyNotZero(0, 0));
	}

}
