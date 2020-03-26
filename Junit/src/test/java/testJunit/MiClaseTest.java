package testJunit;

import javax.swing.JFrame;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MiClaseTest {

	private MiClase miclase;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("setUpBeforeClass");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("tearDownAfterClass");
	}

	@Before
	public void setUp() throws Exception {
		miclase = new MiClase();
		System.out.println("setUp");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("tearDown");
		miclase.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	@Test
	public void testMiClaseIsVisible() {
		// logica de conectar a bbdd

		Assert.assertTrue(miclase.isVisible());
		System.out.println("ejecutando test 1");

		// logica de cerrar conexio a bbdd
	}

	@Test
	public void testTittleIsCorrect() {
		Assert.assertEquals("mi_ventana", miclase.getTitle());
		System.out.println("ejecutando test 1");
	}

	@Test
	public void testSumTwoNumbers() {
		Assert.assertEquals(11, miclase.sumTwoNumbers(5, 6));
		System.out.println("ejecutando test 2");
	}

	@Test
	public void testSumTwoNumbers2() {
		try {
			miclase.sumTwoNumbers2(5, 6);
		} catch (Exception e) {
			Assert.fail("nunca debe alcanzarse esta zona de codigo");
		}
		System.out.println("ejecutando test 2");
	}

	@Test
	public void testCheckException() {
		try {
			miclase.sumTwoNumbers2(null, null);
			Assert.fail("nunca debe alcanzarse esta zona de codigo");
		} catch (Exception e) {
		}
		System.out.println("ejecutando test 2");
	}

	@Test
	public void testCheckExceptionWhenZero() {
		try {
			miclase.sumTwoNumbers4(0, 0);
			Assert.fail("nunca debe alcanzarse esta zona de codigo");
		} catch (Exception e) {
		}
		System.out.println("ejecutando test 2");
	}

	@Test
	public void testCheckRuntimeException() {
		try {
			Assert.assertEquals(11, miclase.sumTwoNumbers3(null, null));
			Assert.fail("nunca debe alcanzarse esta zona de codigo");
		} catch (RuntimeException e) {
		}
	}




}
