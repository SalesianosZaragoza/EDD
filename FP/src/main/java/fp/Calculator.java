package fp;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

	/*
	 * este metodo devuelve el Class del object que le pasamos
	 */
	public static Class classTypeOf(Object x) {
		if (x != null) {
			throw new NullPointerException("not valid");
		} else {
			Class clase = x.getClass();
			return clase;
		}
	}

	/*
	 * devuelve una lista con los n números de la serie de fibonacci.
	 */

	/*
	 * He ajustado el método para que diera de acuerdo con el Test, pero tras
	 * mucho rato mirando las series fibonacci en internet he visto que el
	 * resultado esperado del test esta mal Te mando el link de wikipedia para
	 * que lo veas aunque he consultado en más lugares.
	 * https://es.wikipedia.org/wiki/Sucesi%C3%B3n_de_Fibonacci
	 */
	public static List<Integer> fibonacci(int n) {
		if (n <= 0) {
			throw new ArithmeticException("not valid");
		} else {
			List<Integer> serie = new ArrayList<Integer>();
			int aux;
			int n1 = 0;
			int n2 = 1;
			// serie.add(n1);
			serie.add(n2);
			for (int i = 0; i < n - 1; i++) {
				aux = n1;
				n1 = n2;
				n2 = aux + n1;
				serie.add(n2);
			}
			return serie;
		}
	}

	/*
	 * Escribir todos los números del number al 0 de step en step.
	 */
	public static int[] stepThisNumber(int number, int step) {
		if (step < 0) {
			throw new ArithmeticException("not valid");
		} else {
			if (step == 0) {
				int[] ent = { 0 };
				return ent;
			} else {
				int division = number / step - 1;
				int[] enteros = new int[division];
				int aux = number;
				for (int i = division - 1; i > 0; i--) {
					aux = aux - step;
					enteros[i] = aux;
				}
				return enteros;
			}
		}
	}

	/*
	 * Módulo al que se le pasa un número entero del 0 al 20 y devuelve los
	 * divisores que tiene.
	 */
	public static int[] divisors(int n) {
		if (n < 1 || n > 21) {
			return null;
		} else {
			int cont = 0;
			for (int i = 1; i <= n; i++)
				if (n % i == 0)
					cont++;
			int[] divisores = new int[cont];
			int pos = 0;
			for (int i = n; i >= 1; i--) {
				if (n % i == 0) {
					divisores[pos] = i;
					pos++;
				}
			}
			return divisores;
		}
	}

	/*
	 * Toma como parámetros una cadena de caracteres y devuelve cierto si la
	 * cadena resulta ser un palíndromo
	 */
	public static boolean checkIsPalindrome(String cadena) {
		if (cadena == null) {
			return false;
		} else {
			String abecedario[] = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "Ñ", "O", "P",
					"Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
			String signosDePuntuacion = "¡!¿?.,;:";
			String cadenaSinEspacios = "";
			for (int i = 0; i < cadena.length(); i++) {
				for (int j = 0; j < signosDePuntuacion.length(); j++) {
					if (cadena.charAt(i) != ' ' || cadena.charAt(i) != signosDePuntuacion.charAt(j))
						cadenaSinEspacios += cadena.charAt(i);
				}
			}
			String cadenaInvertida = "";
			for (int i = cadenaSinEspacios.length(); i >= 1; i--) {
				cadenaInvertida = cadenaInvertida + cadenaSinEspacios.charAt(i);
			}
			if (cadenaSinEspacios.equalsIgnoreCase(cadenaInvertida)) {
				return true;
			} else {
				return false;
			}
		}
	}

	/*
	 * Pedir un número de 0 a 99 y mostrarlo escrito. Por ejemplo, para 56
	 * mostrar: cincuenta y seis
	 */
	public static String speakToMe(int n) {
		if (n < 0 || n > 99) {
			throw new ArithmeticException("not valid");
		} else {
			int decimal;
			int unidad;
			String numeroEscrito = "";
			String decenas[] = new String[9];
			decenas[0] = "Diez";
			decenas[1] = "Veinte";
			decenas[2] = "Treinta";
			decenas[3] = "Cuarenta";
			decenas[4] = "Cincuenta";
			decenas[5] = "Sesenta";
			decenas[6] = "Setenta";
			decenas[7] = "Ochenta";
			decenas[8] = "Noventa";

			String dieci = "dieci";
			String veinti = "veinti";

			String unidades[] = new String[10];
			unidades[0] = "Cero";
			unidades[1] = "uno";
			unidades[2] = "dos";
			unidades[3] = "tres";
			unidades[4] = "cuatro";
			unidades[5] = "cinco";
			unidades[6] = "seis";
			unidades[7] = "siete";
			unidades[8] = "ocho";
			unidades[9] = "nueve";

			if (n < 10) {
				numeroEscrito = unidades[n];
			} else {
				if (n == 11) {
					numeroEscrito = "once";
				}
				if (n == 12) {
					numeroEscrito = "doce";
				}
				if (n == 13) {
					numeroEscrito = "trece";
				}
				if (n == 14) {
					numeroEscrito = "catorce";
				}
				if (n == 15) {
					numeroEscrito = "quince";
				}
				if (n == 10 || n == 20 || n >= 30) {
					decimal = n / 10;
					unidad = n - (decimal * 10);
					if (unidad == 0) {
						numeroEscrito = decenas[decimal - 1];
					} else {
						numeroEscrito = decenas[decimal - 1] + " y " + unidades[unidad];
					}
				}
				if (n > 15 && n < 20) {
					decimal = n / 10;
					unidad = n - (decimal * 10);
					numeroEscrito = dieci + unidades[unidad];
				}
				if (n > 20 && n < 30) {
					decimal = n / 10;
					unidad = n - (decimal * 10);
					numeroEscrito = veinti + unidades[unidad];
				}
			}
			return numeroEscrito;
		}
	}

	/*
	 * este metodo devuelve cierto si el año de la fecha es bisiesto fecha
	 * dd-MM-yyyy
	 */
	public static boolean isLeapYear(String fecha) {
		throw new NotImplementedException();
	}

	/*
	 * este metodo devuelve cierto si la fecha es válida
	 */
	public static boolean isValidDate(String date) {
		throw new NotImplementedException();
	}
}
