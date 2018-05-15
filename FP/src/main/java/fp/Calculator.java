package fp;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

public class Calculator {

	/*
	 * este metodo devuelve el Class del object que le pasamos
	 */
	public static Class classTypeOf(Object x) {
		return x.getClass();
	}

	/*
	 * devuelve una lista con los n números de la serie de fibonacci.
	 */
	private static List<Integer> loadFibonacci(int n, List<Integer> result) {
		int xn1 = 0;
		int xn2 = 1;
		int aux = 0;
		for (int i = 0; i < n; i++) {
			aux = xn1 + xn2;
			xn2 = xn1;
			xn1 = aux;
			result.add(aux);
		}
		return result;

	}

	public static List<Integer> fibonacci(int n) {
		List<Integer> result = new ArrayList<Integer>();
		result = loadFibonacci(n, result);
		return result;
	}

	/*
	 * Escribir todos los números del number al 0 de step en step.
	 */
	private static int stepTimes(int number, int step) {
		int cont = 0;
		for (int i = number; i > 0; i -= step)
			cont++;
		return cont;
	}

	private static int[] loadArray(int number, int step, int[] array) {
		int cont = stepTimes(number - step, step);
		int i = 0;
		for (int j = number - step; j > 0; j -= step) {
			if (i < cont) {
				array[i] = j;
				i++;
			}
		}
		return array;
	}

	public static int[] stepThisNumber(int number, int step) {
		int array[] = new int[stepTimes(number - step, step)];
		/* stepTimes devuelve la longitud que va a coger el array */
		array = loadArray(number, step, array);
		/* loadArray carga en el Array los valores */
		return array;
	}

	/*
	 * Módulo al que se le pasa un número entero del 0 al 20 y devuelve los
	 * divisores que tiene.
	 */
	private static int[] loadArrayDiv(int n, int[] array) {
		int cont = 0;
		for (int i = 1; i < n + 1; i++) {
			if (n % i == 0) {
				if (cont <= i) {
					array[cont] = n / i;
					cont++;
				}
			}
		}
		return array;
	}

	private static int stepTimesDiv(int n) {
		int cont = 0;
		for (int i = 1; i <= n; i++) {
			if (n % i == 0)
				cont++;
		}
		return cont;
	}

	public static int[] divisors(int n) {
		int array[] = new int[stepTimesDiv(n)];
		if (n != 0) {
			array = loadArrayDiv(n, array);
			return array;
		} else {
			return null;
		}

	}

	/*
	 * Toma como parámetros una cadena de caracteres y devuelve cierto si la cadena
	 * resulta ser un palíndromo
	 */

	private static String clearString(String cadena) {
		cadena = Normalizer.normalize(cadena, Normalizer.Form.NFD);
		cadena = cadena.replaceAll("[^\\p{ASCII}]", "");
		cadena = cadena.replaceAll(",", "");
		cadena = cadena.replaceAll(" ", "");
		cadena = cadena.toLowerCase();
		return cadena;
	}

	public static boolean checkIsPalindrome(String cadena) {
		if (stringNotNull(cadena)) {
			clearString(cadena);
			boolean palindrome = true;
			int fin = cadena.length() - 1;
			int ini = 0;
			while (ini < fin) {
				if (cadena.charAt(ini) != cadena.charAt(fin)) {
					palindrome = false;
				}
				ini++;
				fin--;
			}
			return palindrome;
		}
		return true;
	}

	/*
	 * Pedir un número de 0 a 99 y mostrarlo escrito. Por ejemplo, para 56 mostrar:
	 * cincuenta y seis
	 */
	private static boolean isNotAbove100orIs0(int n) {
		if (n < 100 || n == 0)
			return true;
		else
			return false;

	}

	private static boolean isUnder20(int n) {
		if (n < 20)
			return true;
		else
			return false;

	}

	private static String getFirst20(int n, String units[]) {
		String result = "";
		result = units[n];
		return result;
	}

	private static boolean isNotTens(int n) {
		if ((n % 10) != 0)
			return true;
		else
			return false;
	}

	private static String getComposedNumber(int n, String units[], String tens[]) {
		String result = "";
		result += tens[n / 10];
		result += " y ";
		result += units[n % 10];
		return result;
	}

	private static String getSimpleNumber(int n, String tens[]) {
		String result = "";
		result += tens[n / 10];

		return result;
	}

	public static boolean is0(int n) {
		if (n == 0) {
			return true;
		} else {
			return false;
		}
	}

	public static String speakToMe(int n) {
		String numero = "";
		if (isNotAbove100orIs0(n)) {
			String units[] = { "Cero", "uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve",
					"Diez", "once", "doce", "trece", "catorce", "qince", "dieciseis", "diecisiete", "dieciocho",
					"diecinueve" };
			String tens[] = { "Cero", "Diez", "Veinte", "Treinta", "Cuarenta", "Cincuenta", "Sesenta", "Setenta",
					"Ochenta", "Noventa" };
			if (isUnder20(n)) {
				if (is0(n)) {
					numero = tens[n];
					return numero;
				} else {
					numero = getFirst20(n, units);
					return numero;
				}
			} else {
				if (isNotTens(n)) {
					numero = getComposedNumber(n, units, tens);
					return numero;
				} else {
					numero = getSimpleNumber(n, tens);
					return numero;
				}
			}
		} else
			return null;
	}

	/*
	 * este metodo devuelve cierto si el año de la fecha es bisiesto fecha
	 * dd-MM-yyyy
	 */
	private static boolean stringNotNull(String phrase) {
		if (phrase != "")
			return true;
		else
			return false;

	}

	private static boolean checkLeap(String fecha) {
		fecha = fecha.substring(fecha.length() - 4);
		int convertedToInt = Integer.parseInt(fecha);
		if (convertedToInt % 4 == 0 && convertedToInt % 25 != 0 || convertedToInt % 40 == 0) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isLeapYear(String fecha) {
		if (stringNotNull(fecha)) {
			return checkLeap(fecha);
		} else {
			return false;
		}
	}

	/*
	 * este metodo devuelve cierto si la fecha es válida
	 */
	public static boolean checkDateFormat(String date) {
		if ((date.charAt(2) != '-' && date.charAt(5) != '-')
				&& ((Integer.parseInt(date.substring(0, 1))) <= 31 && (Integer.parseInt(date.substring(3, 4)) <= 12))
				&& (Integer.parseInt(date.substring(6, date.length() - 1)) <= 9999))
			return true;
		else
			return false;

	}

	public static boolean isValidDate(String date) {
		if (stringNotNull(date)) {
			if (checkDateFormat(date))
				return true;
			else
				return false;
		}
		return false;

	}
}
