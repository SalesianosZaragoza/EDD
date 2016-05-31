package es.salesianos.filter;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class IpRangeFilterTest {

	@Spy
	private IpRangeFilter filter = new IpRangeFilter();

	@Mock
	private HttpServletResponse response;

	@Mock
	private HttpServletRequest request;

	@Mock
	private FilterChain chain;

	@Test
	public void testInvalidIpRangeDoFilter() throws IOException, ServletException {
		when(request.getRemoteAddr()).thenReturn("123.123.123.123");
		when(filter.getValidIpRange()).thenReturn("192.168");
		filter.doFilter(request, response, chain);
		verify(chain, times(0)).doFilter(request, response);
	}

	@Test
	public void testValidIpRangeDoFilter() throws IOException, ServletException {
		when(request.getRemoteAddr()).thenReturn("192.168.0.0");
		when(filter.getValidIpRange()).thenReturn("192.168");
		filter.doFilter(request, response, chain);
		verify(chain, times(1)).doFilter(request, response);
	}

	@Test
	public void testEmptyIpRangeDoFilter() throws IOException, ServletException {
		when(request.getRemoteAddr()).thenReturn("192.168.0.0");
		when(filter.getValidIpRange()).thenReturn("");
		filter.doFilter(request, response, chain);
		verify(chain, times(1)).doFilter(request, response);
	}

	@Mock
	List<String> mockedList;

	@Test
	public void whenUseMockAnnotation_thenMockIsInjected() {
		mockedList.add("one");
		Mockito.verify(mockedList).add("one");
		assertEquals(0, mockedList.size());

		Mockito.when(mockedList.size()).thenReturn(100);
		assertEquals(100, mockedList.size());
	}

	@Spy
	List<String> spiedList = new ArrayList<String>();

	@Test
	public void whenUseSpyAnnotation_thenSpyIsInjected() {
		spiedList.add("one");
		spiedList.add("two");

		Mockito.verify(spiedList).add("one");
		Mockito.verify(spiedList).add("two");

		assertEquals(2, spiedList.size());

		Mockito.doReturn(100).when(spiedList).size();
		assertEquals(100, spiedList.size());
	}

	@Mock
	Map<String, String> wordMap;

	@InjectMocks
	MyDictionary dic = new MyDictionary();

	@Test
	public void whenUseInjectMocksAnnotation_thenCorrect() {
		Mockito.when(wordMap.get("aWord")).thenReturn("aMeaning");

		assertEquals("aMeaning", dic.getMeaning("aWord"));
	}

	class MyDictionary {
		Map<String, String> wordMap;

		public MyDictionary() {
			wordMap = new HashMap<String, String>();
		}

		public void add(final String word, final String meaning) {
			wordMap.put(word, meaning);
		}

		public String getMeaning(final String word) {
			return wordMap.get(word);
		}
	}

}