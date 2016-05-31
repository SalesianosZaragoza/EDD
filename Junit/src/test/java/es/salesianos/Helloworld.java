package es.salesianos;

import org.springframework.stereotype.Service;

@Service
public class Helloworld {
	private String name;

	public void setName(String name) {
		this.name = name;
	}

	public void printHello() {
		System.out.println("Hello ! " + name);
	}
}