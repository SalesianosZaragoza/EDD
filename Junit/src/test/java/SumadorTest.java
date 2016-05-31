import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import jdk.nashorn.internal.ir.annotations.Ignore;

public class SumadorTest {

	private Sumador sumador;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		sumador = new Sumador();
	}

	@Ignore
	@Test
	public void testSumar() {
		Assert.assertEquals(7, sumador.sumar(2, 3, 2));
		Assert.assertNotNull(sumador.sumar(2, 3, 2));
		Assert.assertEquals(7, sumador.sumar(2, 3, 2));

	}

	@Test
	public void testAssertEquals() {
		String s1 = new String("Hola");
		String s2 = new String("Hola");
		Assert.assertEquals(s1, s2);
	}

	@Test
	public void testAssertSame() {
		String s1 = new String("Hola");
		String s2 = new String("Hola");
		s2 = s1;
		Assert.assertSame(s1, s2);
	}

	@Ignore
	@Test
	public void testSumarWhenNull() {
		try {
			sumador.sumar(null, null, null);
		} catch (Exception e) {
			Assert.fail("Nunca se deberia ejecutar este codigo");
		}
	}

	@After
	public void tearDown() throws Exception {
	}


}
