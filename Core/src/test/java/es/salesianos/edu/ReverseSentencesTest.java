package es.salesianos.edu;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import es.salesianos.filter.ReverseSentences;

public class ReverseSentencesTest {

	@Test
	public void testReverseRecursive() {
		assertEquals("di adios ", ReverseSentences.reverseRecursive("adios di"));
	}

}
