package fp;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
	static String cadena1;
	static int contador = 0;

	public static void main(String[] args) {
		fibonacci(5);
	}

	/*
	 * este metodo devuelve el Class del object que le pasamos
	 */
	public static Class classTypeOf(Object x) {
		return x.getClass();
	}

	/*
	 * devuelve una lista con los n números de la serie de fibonacci.
	 */
	public static List<Integer> fibonacci(int n) {
		List<Integer> numeros = new ArrayList<Integer>();
		/// Hago el bucle para que se ejecute un numero determinado de veces
		int a = 0;
		int b = 1;
		int c;
		numeros.add(b);
		for (int i = 0; i < n - 1; i++) {
			c = a;
			a = b;
			b = c + a;
			numeros.add(b);
		}
		for (int i = 0; i < numeros.size(); i++) {
			System.out.println(numeros.get(i));
		}
		return numeros;
	}

	/*
	 * Escribir todos los números del number al 0 de step en step.
	 */
	public static int[] stepThisNumber(int number, int step) {
		int numeros[] = null;
		int posiciones = 0;
		List<Integer> calculo = new ArrayList<Integer>();

		while (step != 0 && number - step > 0) {
			calculo.add(number - step);
			number = number - step;
			posiciones++;
		}

		numeros = new int[posiciones];
		for (int i = 0; i < calculo.size(); i++) {
			numeros[i] = calculo.get(i);
		}
		return numeros;
	}

	/*
	 * Módulo al que se le pasa un número entero del 0 al 20 y devuelve los
	 * divisores que tiene.
	 */
	public static int[] divisors(int n) {
		int divisores[] = null;
		List<Integer> numeros = new ArrayList<Integer>();
		int posiciones = 0;

		if (n > 0) {
			for (int i = n; i > 0; i--) {
				if (n % i == 0) {
					numeros.add(i);
					posiciones++;
				}
			}

			divisores = new int[posiciones];
			for (int i = 0; i < posiciones; i++) {
				divisores[i] = numeros.get(i);
			}
		}
		return divisores;
	}

	/*
	 * Toma como parámetros una cadena de caracteres y devuelve cierto si la cadena
	 * resulta ser un palíndromo
	 */
	public static boolean checkIsPalindrome(String cadena) {
		/// char sustituiracentosminusculas[]=
		/// {'á','é','í','ó','ú','Á','É','Í','Ó','Ú'};
		char sustituiracentosminusculas[] = { 'Á', 'É', 'Í', 'Ó', 'Ú' };
		char sustitutosacentosminusculas[] = { 'A', 'E', 'I', 'O', 'U' };
		char caracteresespeciales[] = { ' ', '?', '¿', '!', '¡', ',', '.', ':', '·' };
		char sinespacio = ' ';
		if (cadena != null) {
			cadena = cadena.toUpperCase();
			/// Todo este bucle sirve para quitar espacios , caracteresespeciales ,
			/// acentos..
			for (int i = 0; i < cadena.length(); i++) {
				if (cadena.charAt(i) == ' ') {
					cadena = cadena.replace(" ", "");
				}
				for (int j = 0; j < sustituiracentosminusculas.length; j++) {
					if (cadena.charAt(i) == sustituiracentosminusculas[j]) {
						cadena = cadena.replace(cadena.charAt(i), sustitutosacentosminusculas[j]);
					}
				}

				for (int e = 0; e < caracteresespeciales.length; e++) {
					if (cadena.charAt(i) == caracteresespeciales[e]) {
						cadena = cadena.replace(cadena.charAt(i), sinespacio);
					}
				}
			}
			// quitamos los espacios
			cadena = cadena.replace(" ", "");

			//// Aqui invierto la cadena
			StringBuilder builder = new StringBuilder(cadena);
			String cadena1 = builder.reverse().toString();

			// Comprobamos si es palidroma o no
			if (!cadena.equals(cadena1)) {
				return false;
			}

		}
		return true;

	}

	/*
	 * Pedir un número de 0 a 99 y mostrarlo escrito. Por ejemplo, para 56 mostrar:
	 * cincuenta y seis
	 */
	public static String speakToMe(int n) {
		String numeroescrito = "";
		String[] unidadesescritas = { "Cero", "uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve",
				"Diez", "Once", "Doce", "Trece", "Catorce", "Quince", "Diecesies", "Diecisiete", "Dicieocho",
				"Dicienueve" };
		String[] decenasescritas = { "Cero", "Diez", "Veinte", "Treinta", "Cuarenta", "Cincuenta", "Sesenta", "Setenta",
				"Ochenta", "Noventa" };
		if (n < 100) {
			if (n >= 20) {
				if ((n % 10) != 0) {
					numeroescrito += decenasescritas[(n / 10)];
					numeroescrito += " y " + unidadesescritas[(n % 10)];

				} else {
					numeroescrito += decenasescritas[(n / 10)];
				}
			} else {
				numeroescrito += unidadesescritas[n];
			}
		}
		System.out.println(numeroescrito);

		return numeroescrito;
	}

	/*
	 * este metodo devuelve cierto si el año de la fecha es bisiesto fecha
	 * dd-MM-yyyy
	 */
	public static boolean isLeapYear(String fecha) {
		String añoenletra = "";
		String calculardivisible = "";
		Integer añoennumero;
		int ultimosdosdigitosañoennumero;
		if (fecha != null && fecha != "") {
			// 6 por que es el valor donde comienza el año
			for (int i = 6; i < fecha.length(); i++) {
				añoenletra += fecha.charAt(i);
			}

			/// Aqui "parseamos" el año escrito a numero
			añoennumero = Integer.valueOf(añoenletra);
			// lo volvemos a convertir a String para recuperar los dos ultimos digitos
			añoenletra = añoennumero.toString();

			for (int i = 2; i < añoenletra.length(); i++) {
				calculardivisible += añoenletra.charAt(i);
			}

			/// Volvemos a parsearlo a numero
			ultimosdosdigitosañoennumero = Integer.parseInt(calculardivisible);

			if ((añoennumero % 400) == 0) {
				return true;

			} else if ((añoennumero % 4) == 0 && (añoennumero % 100) != 0) {
				return true;
			} else {
				// System.out.println("no");
				return false;
			}
		}

		return true;
	}

	/*
	 * este metodo devuelve cierto si la fecha es válida
	 */
	public static boolean isValidDate(String date) {
		String vectorcaracteresposibles[] = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "-" };
		List<String> listacaracteresposibles = new ArrayList<String>();
		int contador = 0;
		if (date != null) {

			if (date.length() == 10) {
				// Cogemos los digitos del dia
				String substringdia = date.substring(0, 2);
				int numerosubstringdia = Integer.parseInt(substringdia);

				// Cogemos los digitos del mes
				String substringmes = date.substring(3, 5);
				int numerossubstringmes = Integer.parseInt(substringmes);

				// Cogemos los digitos del año
				String substringaño = date.substring(6, 10);
				int numerosubstringaño = Integer.parseInt(substringaño);

				if (numerosubstringdia <= 31 && numerosubstringdia > 0 && numerossubstringmes <= 12
						&& numerossubstringmes > 0 && numerosubstringaño > 0) {
					for (int i = 0; i < vectorcaracteresposibles.length; i++) {
						listacaracteresposibles.add(vectorcaracteresposibles[i]);
					}
					for (int i = 0; i < date.length(); i++) {
						if (listacaracteresposibles.contains(String.valueOf(date.charAt(i)))) {
							contador++;
						} else {
							return false;
						}

					}
				} else {
					return false;
				}

			} else {
				return false;
			}
		}
		return true;
	}
}
