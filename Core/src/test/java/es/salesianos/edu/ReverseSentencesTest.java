package es.salesianos.edu;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ReverseSentencesTest {

	@Test
	public void testReverseRecursive() {
		assertEquals("di adios ", ReverseSentences.reverseRecursive("adios di"));
	}

}
