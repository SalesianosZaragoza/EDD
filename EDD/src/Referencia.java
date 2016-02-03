
public class Referencia {

	public static void main(String[] args) {
		Imagen miclase = new Imagen();
		int primitivo = 16;
		referenciaObj(miclase);
		// referenciaPrimitive(primitivo);
		System.out.println("Salida despues del metodo");
		System.out.println(miclase);
	}

	public static void referenciaObj(Imagen objParametro) {
		Imagen nuevoObjeto1 = new Imagen();
		Imagen nuevoObjeto2 = new Imagen();
		objParametro = nuevoObjeto1;
		// objParametro.valor = nuevoObjeto1.valor;
		// objParametro = nuevoObjeto1;
		nuevoObjeto1.valor = 3;
		// System.out.println(objParametro.valor);
		// System.out.println(nuevoObjeto1.valor);
		// System.out.println(nuevoObjeto2.valor);
		// System.out.println("====================");
		// nuevoObjeto1.valor=5;
		// System.out.println(objParametro.valor);
		// System.out.println(nuevoObjeto1.valor);
		// System.out.println(nuevoObjeto2.valor);
		// System.out.println("====================");
		// nuevoObjeto1 = nuevoObjeto2;
		// nuevoObjeto2.valor=8;
		System.out.println(objParametro.valor);
		System.out.println(nuevoObjeto1.valor);
		System.out.println(nuevoObjeto2.valor);
		System.out.println("====================");
	}

	public static void referenciaPrimitive(int intParametro) {
		int nuevoInt1 = 1;
		int nuevoInt2 = 2;
		intParametro = nuevoInt1;
		// intParametro vale 1
		intParametro = 3;
		// intParametro vale 3
		System.out.println(intParametro);
		System.out.println(nuevoInt1);
		System.out.println(nuevoInt2);
		System.out.println("====================");
		nuevoInt1 = 5;
		System.out.println(intParametro);
		System.out.println(nuevoInt1);
		System.out.println(nuevoInt2);
		System.out.println("====================");
		nuevoInt1 = nuevoInt2;
		nuevoInt2 = 8;
		System.out.println(intParametro);
		System.out.println(nuevoInt1);
		System.out.println(nuevoInt2);
		System.out.println("====================");
	}

}
