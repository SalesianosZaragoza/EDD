package fp;

import java.util.ArrayList;
import java.util.List;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Calculator {


	/*
     * este metodo devuelve el Class del object que le pasamos
     */
	public static Class<? extends Object> classTypeOf(Object x) {
		return x.getClass();
	}


	/*
     * devuelve una lista con los n números de la serie de fibonacci.
     */
	public static List<Integer> fibonacci(int n) {
		List<Integer> list;
		list = new ArrayList<Integer>();
		int n1 = 1;
		int n2 = 1;
		int aux;
		list.add(n1);
		list.add(n2);

		for (int i = 2; i < n; i++) {
			aux = n1;
			n1 = n2;
			n2 = aux + n1;

			list.add(n2);
		}
		return list;
	}

	/*
	 * Escribir todos los números del number al 0 de step en step.
	 */
	public static int[] stepThisNumber(int number, int step) {
		List<Integer> steps = new ArrayList<Integer>();
		while (number > step) {
			steps.add(number - step);
			number -= step;
		}
		int results[] = new int[steps.size()];
		for (int i = 0; i < results.length; i++) {
			results[i] = steps.get(i);
		}
		return results;
	}

	/*
	 * Módulo al que se le pasa un número entero del 0 al 20 y devuelve los
	 * divisores que tiene.
	 */
	private static int[] loadDivisors(int n, int[] divisors) {
		int cont = 0;
		for (int i = 1; i < n + 1; i++) {
			if (n % i == 0) {
				if (cont <= i) {
					divisors[cont] = n / i;
					cont++;
				}
			}
		}
		return divisors;
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
		int divisors[] = new int[stepTimesDiv(n)];
		if (n != 0) {
			divisors = loadDivisors(n, divisors);
			return divisors;
		} else {
			return null;
		}
	}

	/*
	 * Toma como parámetros una cadena de caracteres y devuelve cierto si la cadena resulta ser un palíndromo
	 */
	public static boolean checkIsPalindrome(String cadena) {
		throw  new NotImplementedException();
	}

	/*
	 * Pedir un número de 0 a 99 y mostrarlo escrito. Por ejemplo, para 56
	 * mostrar: cincuenta y seis
	 */
	public static String speakToMe(int n) {
		String[] units = { "Cero", "Uno", "Dos", "Tres", "Cuatro", "Cinco", "Seis", "Siete", "Ocho", "Nueve", "Diez",
				"Once", "Doce", "Trece", "Catorce", "Quince", "Dieciseis", "Diecisiete", "Dieciocho", "Diecinueve" };
		String[] tens = { "Diez", "Veinte", "Treinta", "Cuarenta", "Cincuenta", "Sesenta", "Setenta", "Ochenta",
				"Noventa" };
		if (n > 0 && n < 99) {
			if (n < 20)
				return units[n];
			else if ((n % 10) == 0)
				return tens[(n / 10) - 1];
			else if (n > 20) {
				return tens[(n / 10) - 1] + " y " + units[n % 10].toLowerCase();
			}
		} else if (n == 0)
			return units[n];
		return null;
	}

	/*
	 * este metodo devuelve cierto si el año de la fecha es bisiesto fecha
	 * dd-MM-yyyy
	 */
	public static boolean isLeapYear(String fecha) {
		throw  new NotImplementedException();
	}

	/*
	 * este metodo devuelve cierto si la fecha es válida
	 */
	public static boolean isValidDate(String date) {
		throw  new NotImplementedException();
	}
}
