package es.salesianos;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring-module.xml");

		Helloworld obj;

		obj = (Helloworld) context.getBean("helloBean1h");
		obj.printHello();

		obj = (Helloworld) context.getBean("helloBean2h");
		obj.printHello();

	}
}