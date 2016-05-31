package es.salesianos.impl;

import es.salesianos.interfaz.Saludar;

public class SaludarIngles implements Saludar {

	public String sayHello(String name) {
		return "Hello  world " + name;
	}

}
