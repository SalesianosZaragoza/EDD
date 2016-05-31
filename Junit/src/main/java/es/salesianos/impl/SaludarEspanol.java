package es.salesianos.impl;

import es.salesianos.interfaz.Saludar;

public class SaludarEspanol implements Saludar {

	public String sayHello(String name) {
		return "hola mundo " + name;
	}

}
