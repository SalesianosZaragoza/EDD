package es.salesianos;

public class Launcher2 {

	static int alturaTriangulo;
	static int base;
	static int resultado;

	public static void main(String[] args) {
		alturaTriangulo = 20;
		base = 10;
		resultado = (base * alturaTriangulo) / 2;
		System.out.println("La altura: " + alturaTriangulo);
		System.out.println("El area es: " + resultado);
		escribirfinprograma();
	}

	public static void escribirfinprograma() {
		System.out.println("escribiendo por consola. Fin del programa");
	}

}
