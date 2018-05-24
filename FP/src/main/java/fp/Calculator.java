package fp;

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
	public static List<Integer> fibonacci(int n) {
		int a = 0, b = 1;
		List<Integer> lista = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			lista.add(a + b);
			b = a;
			a = lista.get(i);
		}
		return lista;
	}

	/*
	 * Escribir todos los números del number al 0 de step en step.
	 */
	public static int[] stepThisNumber(int number, int step) {
		List<Integer> lnumbers = new ArrayList<Integer>();
		while (number > 0 && number > step) {
			number -= step;
			lnumbers.add(number);
		}
		int[] numbers = new int[lnumbers.size()];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = lnumbers.get(i);
		}
		return numbers;
	}

	/*
	 * Módulo al que se le pasa un número entero del 0 al 20 y devuelve los
	 * divisores que tiene.
	 */
	public static int[] divisors(int n) {
		int divisores[] = null;
		List<Integer> numeros = new ArrayList<Integer>();

		if (n != 0) {
			for (int i = n; i > 0; i--)
				if (n % i == 0)
					numeros.add(i);
			divisores = new int[numeros.size()];
			for (int i = 0; i < divisores.length; i++)
				divisores[i] = numeros.get(i);
		}
		return divisores;
	}

	/*
	 * Toma como parámetros una cadena de caracteres y devuelve cierto si la cadena
	 * resulta ser un palíndromo
	 */
	private static boolean isPalindromeMethod(String cadena) {
		String letters2 = "aaaeeeiiiooouuunAAAEEEIIIOOOUUUNcC           ";
		String letters = "áàäéèëíìïóòöúùuñÁÀÄÉÈËÍÌÏÓÒÖÚÙÜÑçÇ:;-_,.?¿¡!·";
		String out = cadena.toLowerCase();
		String inver = "";

		for (int i = 0; i < letters.length(); i++) {

			out = out.replace(letters.charAt(i), letters2.charAt(i));

		}

		out = out.replace(" ", "");
		for (int i = out.length() - 1; i >= 0; i--)
			inver += out.charAt(i);
		if (out.equals(inver)) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean checkIsPalindrome(String cadena) {
		if (cadena == null) {

			return false;
		} else {

			return isPalindromeMethod(cadena);

		}
	}

	/*
	 * Pedir un número de 0 a 99 y mostrarlo escrito. Por ejemplo, para 56 mostrar:
	 * cincuenta y seis
	 */
	public static String speakToMe(int n) {
		String numero = "";
		String[] unidades = { "Cero", "uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve", "Diez",
				"Once", "Doce", "Trece", "Catorce", "Quince", "Diecesies", "Diecisiete", "Dicieocho", "Dicienueve" };
		String[] decenas = { "Cero", "Diez", "Veinte", "Treinta", "Cuarenta", "Cincuenta", "Sesenta", "Setenta",
				"Ochenta", "Noventa" };
		if (n < 100) {
			if (n >= 20) {
				numero = decimalCompleto(n, numero, unidades, decenas);
			} else {
				numero += unidades[n];
			}
			System.out.println(numero);
		}
		return numero;
	}

	private static String decimalCompleto(int n, String numero, String[] unidades, String[] decenas) {
		if ((n % 10) != 0) {
			numero += decenas[(n / 10)];
			numero += " y ";
			numero += unidades[(n % 10)];

		} else {
			numero += decenas[(n / 10)];
		}
		return numero;
	}

	/*
	 * este metodo devuelve cierto si el año de la fecha es bisiesto fecha
	 * dd-MM-yyyy
	 */
	public static boolean isLeapYear(String fecha) {
		if (fecha.isEmpty()) {
			return false;
		} else {
			return isALeapYear(fecha);
		}
	}

	private static boolean isALeapYear(String fecha) {
		String year = fecha;
		year = fecha.substring(6);
		int num = Integer.parseInt(year);
		if ((num % 4 == 0) && ((num % 100 != 0)) || (num % 400 == 0)) {

			return true;

		} else {

			return false;
		}
	}

	/*
	 * este metodo devuelve cierto si la fecha es válida
	 */
	public static boolean isValidDate(String date) {

		if (date != "" && date.length() == 10) {

			int day = Integer.parseInt(date.substring(0, 2));
			int month = Integer.parseInt(date.substring(3, 5));
			int year = Integer.parseInt(date.substring(6, 10));

			if (day >= 1 && day < 32) {
				if (month >= 1 && month < 13) {
					if (year != 0000) {
						return true;
					}
				}
			}
		}
		return false;
	}
}
