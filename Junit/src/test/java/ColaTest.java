import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ColaTest {

	private Cola<String> cola;

	@Before
	public void setUp() throws Exception {
		cola = new Cola<String>();
	}


	@Test
	public void testSampleCola() throws ColaVaciaException {
		Assert.assertEquals(0, cola.numElementos());
		cola.encolar("primero");
		Assert.assertEquals(1, cola.numElementos());
		cola.encolar("segundo");
		Assert.assertEquals(2, cola.numElementos());
		cola.desencolar();
		Assert.assertEquals(1, cola.numElementos());
		cola.desencolar();
		Assert.assertEquals(0, cola.numElementos());

	}

	@Test
	public void testIsFifo() throws ColaVaciaException {
		String primero = "primero";
		String segundo = "segundo";

		Assert.assertEquals(0, cola.numElementos());
		cola.encolar(primero);
		Assert.assertEquals(1, cola.numElementos());
		cola.encolar(segundo);
		Assert.assertEquals(2, cola.numElementos());

		String desencolar1 = cola.desencolar();
		Assert.assertEquals(1, cola.numElementos());
		Assert.assertEquals(primero, desencolar1);
		Assert.assertSame(primero, desencolar1);

		String desencolar2 = cola.desencolar();
		Assert.assertEquals(0, cola.numElementos());
		Assert.assertEquals(segundo, desencolar2);
		Assert.assertSame(segundo, desencolar2);

	}

	@Test
	public void testOnEmptyCola() {
		try {
			cola.desencolar();
			Assert.fail();
		} catch (ColaVaciaException e) {
		}
	}

}
