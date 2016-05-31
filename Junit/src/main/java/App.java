import es.salesianos.impl.SaludarEspanol;
import es.salesianos.impl.SaludarIngles;
import es.salesianos.interfaz.Saludar;

public class App {

	public static void main(String[] args) {

		Saludar saludarEspanol = new SaludarEspanol();
		imprimirMsg(saludarEspanol, "nacho");
		Saludar saludaringles = new SaludarIngles();
		imprimirMsg(saludaringles, "nacho");
	}

	public static void imprimirMsg(Saludar saludo, String name) {
		System.out.println(saludo.sayHello(name));
	}

}
