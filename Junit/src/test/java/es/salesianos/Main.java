package es.salesianos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		Main p = context.getBean(Main.class);
		p.start();
	}

	@Autowired
	private MyBean myBean;

	private void start() {
		System.out.println("my beans method: " + myBean.getStr());
	}
}

