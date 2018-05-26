package fp;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

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
				
		List<Integer> secuenciaFibonacci = new ArrayList<Integer>(n);
		fibonacciLoop(n, secuenciaFibonacci);
		return secuenciaFibonacci;
	}
		
		
	private static void fibonacciLoop(int n, List<Integer> secuenciaFibonacci) {
		int a = 0;
		int b = 1;
		int suma = 0;
		for (int i = 0; i < n; i++) {
			suma = a + b;
			b = a;
			a = suma;
	    	secuenciaFibonacci.add(suma);
		}
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
		String añoenletra = "";
		String calculardivisible = "";
		Integer añoennumero;
		int ultimosdosdigitosañoennumero;
		if (fecha != null && fecha != "") {

			for (int i = 6; i < fecha.length(); i++) {
				añoenletra += fecha.charAt(i);
			}


			añoennumero = Integer.valueOf(añoenletra);

			añoenletra = añoennumero.toString();

			for (int i = 2; i < añoenletra.length(); i++) {
				calculardivisible += añoenletra.charAt(i);
			}


			ultimosdosdigitosañoennumero = Integer.parseInt(calculardivisible);

			if ((añoennumero % 400) == 0) {
				return true;

			} else if ((añoennumero % 4) == 0 && (añoennumero % 100) != 0) {
				return true;
			} else {
				return false;
			}
		}

		return true;
	}

		

	/*
	 * este metodo devuelve cierto si la fecha es válida
	 */
	public static boolean isValidDate(String date) {
		
		
}

