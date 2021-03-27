package fp;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import java.lang.UnsupportedOperationException;

public class Calculator {


	/*
     * este metodo devuelve el Class del object que le pasamos
     */
	public static Class classTypeOf(Object x) {

		//throw  new NotImplementedException();
		return x.getClass();
	}


	/*
     * devuelve una lista con los n números de la serie de fibonacci.
     */
	public static List<Integer> fibonacci(int n) {

		//throw new NotImplementedException();

		List<Integer> numbers = new ArrayList<>();
		Integer n1 = 0;
		Integer n2 = 1;
		numbers.add(1);

		for (int i = 0; i < n; i++){

			Integer summa = n1 + n2;
			n1 = n2;
			n2 = summa;
			numbers.add(summa);

		}

		return numbers;

	}

	/*
	 * Escribir todos los números del number al 0 de step en step.
	 */
	public static int[] stepThisNumber(int number, int step) {

		int[] solve = new int[number];

		int index = 0;
		while(number - step > 0) {

			solve[index++] = number -= step;
		}

		return solve;

		//throw  new NotImplementedException();
	}

	/*
	 * Módulo al que se le pasa un número entero del 0 al 20 y devuelve los
	 * divisores que tiene.
	 */
	public static int[] divisors(int n) {

		int[] solve = new int[n];

		for (int i = n; i > 0; i--) {

			if (n % i == 0) {

				solve[n - i] = i;
			}
		}

		//throw  new NotImplementedException();

		return solve;
	}

	/*
	 * Toma como parámetros una cadena de caracteres y devuelve cierto si la cadena resulta ser un palíndromo
	 */
	public static boolean checkIsPalindrome(String cadena) {
		throw  new UnsupportedOperationException();
	}

	/*
	 * Pedir un número de 0 a 99 y mostrarlo escrito. Por ejemplo, para 56
	 * mostrar: cincuenta y seis
	 */
	public static String speakToMe(int n) {
		throw  new UnsupportedOperationException();
	}

	/*
	 * este metodo devuelve cierto si el año de la fecha es bisiesto fecha
	 * dd-MM-yyyy
	 */
	public static boolean isLeapYear(String fecha) {
		throw  new UnsupportedOperationException();
	}

	/*
	 * este metodo devuelve cierto si la fecha es válida
	 */
	public static boolean isValidDate(String date) {
		throw  new UnsupportedOperationException();
	}
}
