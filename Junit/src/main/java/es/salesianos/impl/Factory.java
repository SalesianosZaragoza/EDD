package es.salesianos.impl;


import java.util.ArrayList;
import java.util.List;

public class Factory {

	public List<Container> createLista() {
		ArrayList<Container> arrayList = new ArrayList<Container>();
		Container container1 = new Container();
		container1.setProperty("azul");
		arrayList.add(container1);

		Container container2 = new Container();
		container2.setProperty("azul");
		arrayList.add(container2);
		
		// TODO
		return arrayList;
	};

}
