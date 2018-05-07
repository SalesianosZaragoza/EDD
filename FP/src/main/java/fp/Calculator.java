package fp;

import java.util.ArrayList;
import java.util.List;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

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
		throw  new NotImplementedException();
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
		throw  new NotImplementedException();
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
