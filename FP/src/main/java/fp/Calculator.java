package fp;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class Calculator {


	/*
     * este metodo devuelve el Class del object que le pasamos
     */
	public static Class classTypeOf(Object x) {
		Class clase = x.getClass();
		return clase;
	}


	/*
     * devuelve una lista con los n números de la serie de fibonacci.
     */
	public static List<Integer> fibonacci(int n) {
		int num1 = 1;
		int num2 = 1;
		List<Integer> numFibonacci = new ArrayList<Integer>();
		numFibonacci.add(num1);
		numFibonacci.add(num2);
		int i = 0;
		while (i <= n - 3) {
			numFibonacci.add(numFibonacci.get(i) + numFibonacci.get(i + 1));
			i++;
		}
		return numFibonacci;
	}

	/*
	 * Escribir todos los números del number al 0 de step en step.
	 */
	public static int[] stepThisNumber(int number, int step) {
		int[] numeros;
		List<Integer> numListas = new ArrayList();
		int numero = number - step;
		int i = 0;
		while (numero > 0) {
			numListas.add(numero);
			numero -= step;
			i++;
		}
		numeros = new int[i];
		for (int j = 0; j < numeros.length; j++) {
			numeros[j] = numListas.get(j);
		}
		return numeros;
		}

	/*
	 * Módulo al que se le pasa un número entero del 0 al 20 y devuelve los
	 * divisores que tiene.
	 */
	public static int[] divisors(int n) {
		List<Integer> div = new ArrayList<Integer>();
		int divisores[] = null;
		if (!positiveNumber(n)) {
			int cont = 0;
			for (int i = n; i >= 1; i--) {
				if (n % i == 0) {
					div.add(i);
					cont++;
				}
			}

			divisores = new int[cont];
			for (int i = 0; i < cont; i++) {
				divisores[i] = div.get(i);
			}
		}


		return divisores;
	}

	public static boolean positiveNumber(int n) {
		if (n == 0) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * Toma como parámetros una cadena de caracteres y devuelve cierto si la cadena resulta ser un palíndromo
	 */
	public static boolean checkIsPalindrome(String cadena) {
		if (cadena == null) {
			return false;
		} else {
			removeAccent(cadena);
			eliminarEspacios(cadena);
			eliminarCaracteresEspecialesYConvertirAMinusculas(cadena);

			return comprobacionPalindromo(cadena);
		}


	}

	public static void eliminarEspacios(String cadena1) {
		cadena1 = cadena1.replace(" ", "");
	}

	public static void eliminarCaracteresEspecialesYConvertirAMinusculas(String cadena1) {
		// eliminamos de la cadena los caracteres especiales
		cadena1 = cadena1.replaceAll("[^\\p{ASCII}]", "");
		cadena1 = cadena1.replaceAll(",", "");
		cadena1 = cadena1.replaceAll(".", "");
		/*
		 * cadena1 = cadena1.replaceAll("?", ""); cadena1 = cadena1.replaceAll("¿", "");
		 * cadena1 = cadena1.replaceAll(":", ""); cadena1 = cadena1.replaceAll("á",
		 * "a"); cadena1 = cadena1.replaceAll("é", "e"); cadena1 =
		 * cadena1.replaceAll("è", "e"); cadena1 = cadena1.replaceAll("·", ""); cadena1
		 * = cadena1.replaceAll("í", "i"); cadena1 = cadena1.replaceAll("ó", "o");
		 * cadena1 = cadena1.replaceAll("ú", "u");
		 */

		// convertimos todos los caracteres de la cadena a minusculas
		cadena1 = cadena1.toLowerCase();
	}

	public static boolean comprobacionPalindromo(String cadena1) {
		int posicionMasBaja = 0;
		int posicionMasAlta = cadena1.length() - 1;
		boolean esPalindromo = true;

		while ((posicionMasAlta > posicionMasBaja) && esPalindromo) {
			if (cadena1.charAt(posicionMasBaja) != cadena1.charAt(posicionMasAlta)) {
				esPalindromo = false;
			}
			posicionMasBaja++;
			posicionMasAlta--;
		}
		return esPalindromo;
	}

	public static boolean compararString(String cadena) {
		String girado = null;
		boolean iguales = true;
		for (int i = cadena.length()-1; i >0; i++) {
			girado.concat(cadena.substring(i - 1, i));
		}
		for (int i = 0; i < girado.length(); i++) {
			if (girado.charAt(i) != cadena.charAt(i)) {
				iguales = false;
			}
		}
		return iguales;
	}

	private static String removeAccent(String texto) {
		String original = "ÁÉÍÓÚÝáéíóúý";
		String ascii = "ACEIOUYaeiouy";
	    String output = texto;
		for (int i = 0; i < texto.length(); i++) {
			for (int j = 0; j < original.length(); j++) {
				if (texto.charAt(i) == original.charAt(j)) {
					output = output.replace(original.charAt(j), ascii.charAt(j));
				}
			}

	    }
		return output;
	}
	/*
	 * Pedir un número de 0 a 99 y mostrarlo escrito. Por ejemplo, para 56
	 * mostrar: cincuenta y seis
	 */
	public static String speakToMe(int n) {
		return "";
		
	}

	public static void leerNumeroMayorDe10(int numero) {
		String numeroLeido = null;
		if (numero % 10 != 0) {
			switch (numero) {
			case 1:
				numeroLeido = "uno";
			case 2:
				numeroLeido = "dos";
			case 3:
				numeroLeido = "tres";
			case 4:
				numeroLeido = "cuatro";
			case 5:
				numeroLeido = "cinco";
			case 6:
				numeroLeido = "seis";
			case 7:
				numeroLeido = "siete";
			case 8:
				numeroLeido = "ocho";
			case 9:
				numeroLeido = "nueve";
			}
			numero = numero / 10;
		} else {
			numeroLeido = "cero";
		}
		if (numero % 10 != 0) {
			switch (numero) {
			case 1:
				numeroLeido = "dieci" + numeroLeido.substring(0);
			case 2:
				numeroLeido = "";
			case 3:
				numeroLeido = "tres";
			case 4:
				numeroLeido = "cuatro";
			case 5:
				numeroLeido = "cinco";
			case 6:
				numeroLeido = "seis";
			case 7:
				numeroLeido = "siete";
			case 8:
				numeroLeido = "ocho";
			case 9:
				numeroLeido = "nueve";
			}
		}
	}
	/*
	 * este metodo devuelve cierto si el año de la fecha es bisiesto fecha
	 * dd-MM-yyyy
	 */
	public static boolean isLeapYear(String fecha) {
		if (!stringIsNull(fecha)) {
			GregorianCalendar calendar = new GregorianCalendar();
			int anio = anioParseado(fecha);
			if (calendar.isLeapYear(anio)) {
			return true;
		} else {
			return false;
		}
		} else {
			return false;
		}
	}

	// comprueba que la fecha no este vacia
	public static boolean stringIsNull(String fecha) {
		if (fecha != "") {
			return false;
		} else {
			return true;
		}
	}

	// extrae el año de la fecha y lo parsea a tipo int
	public static int anioParseado(String fecha) {
		fecha = fecha.substring(6, 10);

		int anio = Integer.parseInt(fecha);
		return anio;
	}

	/*
	 * este metodo devuelve cierto si la fecha es válida
	 */
	public static boolean isValidDate(String date) {
		if (!stringIsNull(date)) {
			if (formatOfDate(date)) {
				return true;
			}else {
				return false;
			}

		} else {
			return false;
		}

	}
	
	// comprobamos si el formato de la fecha es valido
	public static boolean formatOfDate(String date) {
		if (date.length() == 10) {
			int dia = Integer.parseInt(date.substring(0, 2));
			int mes = Integer.parseInt(date.substring(3, 5));
			int anyo = Integer.parseInt(date.substring(6, date.length()));
			if ((dia <= 31 && dia >= 1) && (mes <= 12 && mes >= 1) && (anyo > 0 && anyo <= 9999)
				&& (date.charAt(2) == '-' && date.charAt(5) == '-')) {
			return true;
		} else {
			return false;
		}
		} else {
			return false;
		}
	}



}
