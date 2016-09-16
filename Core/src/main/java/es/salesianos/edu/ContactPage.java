package es.salesianos.edu;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ContactPage {

	private static final Map<String, RenderInteface> map = new HashMap<String, RenderInteface>();

	static {
		map.put("login", new RenderLogin());
		map.put("admin", new RenderAdmin());
	}

	public ContactPage() {
		iterateMap();
	}

	private void iterateMap() {
		Set<String> keySet = map.keySet();
		for (String key : keySet) {
			RenderInteface renderObject = map.get(key);
			String render = renderObject.render();
			System.out.println(render);
		}
	}

	public static void main(String[] args) {
		ContactPage contactPage;
		contactPage = new ContactPage();
	}
}
