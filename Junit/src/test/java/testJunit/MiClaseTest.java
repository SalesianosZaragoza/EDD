package testJunit;

import javax.swing.JFrame;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MiClaseTest {

	private MiClase miclase;

	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
		System.out.println("setUpBeforeClass");
	}

	@AfterAll
	public static void tearDownAfterClass() throws Exception {
		System.out.println("tearDownAfterClass");
	}

	@BeforeEach
	public void setUp() throws Exception {
		miclase = new MiClase();
		System.out.println("setUp");
	}

	@AfterEach
	public void tearDown() throws Exception {
		System.out.println("tearDown");
		miclase.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	@Test
	public void testMiClaseIsVisible() {
		// logica de conectar a bbdd

		Assertions.assertTrue(miclase.isVisible());
		System.out.println("ejecutando test 1");

		// logica de cerrar conexio a bbdd
	}

	@Test
	public void testTittleIsCorrect() {
		Assertions.assertEquals("mi_ventana", miclase.getTitle());
		System.out.println("ejecutando test 1");
	}

	@Test
	public void testSumTwoNumbers() {
		Assertions.assertEquals(11, miclase.sumTwoNumbers(5, 6));
		System.out.println("ejecutando test 2");
	}

	@Test
	public void testSumTwoNumbers2() {
		try {
			miclase.sumTwoNumbers2(5, 6);
		} catch (Exception e) {
			Assertions.fail("nunca debe alcanzarse esta zona de codigo");
		}
		System.out.println("ejecutando test 2");
	}

	@Test
	public void testCheckException() {
		try {
			miclase.sumTwoNumbers2(null, null);
			Assertions.fail("nunca debe alcanzarse esta zona de codigo");
		} catch (Exception e) {
		}
		System.out.println("ejecutando test 2");
	}

	@Test
	public void testCheckExceptionWhenZero() {
		try {
			miclase.sumTwoNumbersIfTheyNotZero(0, 0);
			Assertions.fail("nunca debe alcanzarse esta zona de codigo");
		} catch (Exception e) {
		}
		System.out.println("ejecutando test 2");
	}

	@Test
	public void testCheckRuntimeException() {
		try {
			Assertions.assertEquals(11, miclase.sumTwoNumbers3(null, null));
			Assertions.fail("nunca debe alcanzarse esta zona de codigo");
		} catch (RuntimeException e) {
		}
	}

}
