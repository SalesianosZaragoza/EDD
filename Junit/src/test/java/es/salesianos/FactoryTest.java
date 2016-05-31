package es.salesianos;

import static org.junit.Assert.fail;

import java.util.HashSet;
import java.util.List;

import org.junit.Test;

import es.salesianos.impl.Container;
import es.salesianos.impl.Factory;

public class FactoryTest {

	Factory factory = new Factory();

	@Test
	public void testCreateListaCorrecta() {
		List<Container> createLista = factory.createLista();
		HashSet<String> set = new HashSet<String>();
		for (Container container : createLista) {
			String property = container.getProperty();
			if (set.contains(property)) {
				fail("propiedad duplicada");
			} else {
				set.add(property);
			}
		}
	}

}
