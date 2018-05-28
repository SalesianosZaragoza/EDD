package fp;

import java.util.ArrayList;
import java.util.List;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

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
		int numero1 = 0;
		int numero2 = 1;

		List<Integer> lista = new ArrayList<Integer>();

		for (int i = 0; i < n; i++) {
			lista.add(numero1 + numero2);
			numero2 = numero1;
			numero1 = lista.get(i);
		}

		return lista;

	}

	/*
	 * Escribir todos los números del number al 0 de step en step.
	 */
	public static int[] stepThisNumber(int number, int step) {
		int numero = 0;
		if (step > 0 && number > 0) {
			numero = (number - 1) / step;
			int numeros[] = new int[numero];
			for (int i = 0; i < numeros.length; i++) {
				number -= step;
				numeros[i] = number;
			}
			return numeros;
		} else
			return new int[0];

	}

	/*
	 * Módulo al que se le pasa un número entero del 0 al 20 y devuelve los
	 * divisores que tiene.
	 */
	public static int[] divisors(int n) {
		int divisores[] = new int[n];
		if (n >= 0 && n <= 20)
			if (n == 0)
				return null;
			else
				for (int i = 20; i <= 0; i--)
					if (n % i == 0)
						for (int j = 0; j < divisores.length; j++) {
							divisores[j] = i;
						}

		return divisores;

	}

	/*
	 * Toma como parámetros una cadena de caracteres y devuelve cierto si la cadena
	 * resulta ser un palíndromo
	 */
	public static boolean checkIsPalindrome(String cadena) {
		String chain = "";
		String exceptions = "áàäéèëíìïóòöúùuñÁÀÄÉÈËÍÌÏÓÒÖÚÙÜÑçÇ";
		String ascii = "aaaeeeiiiooouuunAAAEEEIIIOOOUUUNcC";
		String reverse = "";

		if (cadena != null) {
			for (int i = 0; i < cadena.length(); i++)
				if (Character.isLetter(cadena.charAt(i)))
					chain += cadena.charAt(i);
			chain = chain.toLowerCase();
			for (int i = 0; i < exceptions.length(); i++)
				chain = chain.replace(exceptions.charAt(i), ascii.charAt(i));
			for (int i = chain.length() - 1; i >= 0; i--)
				reverse += chain.charAt(i);
			if (chain.equals(reverse))
				return true;
			else
				return false;
		}

		return false;

	}

	/*
	 * Pedir un número de 0 a 99 y mostrarlo escrito. Por ejemplo, para 56 mostrar:
	 * cincuenta y seis
	 */
	public static String speakToMe(int n) {
		throw new NotImplementedException();
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
