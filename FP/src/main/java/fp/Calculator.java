package fp;

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
		java.util.List<Integer> lista;
		lista = new java.util.ArrayList<Integer>();
		int n1 = 0;
		int n2 = 1;
		int resultado;
		for (int i = 0; i < n; i++) {
			resultado = n1 + n2;
			n2 = n1;
			n1 = resultado;
			lista.add(resultado);

		}

		return lista;

	}

	/*
	 * Escribir todos los números del number al 0 de step en step.
	 */
	public static int[] stepThisNumber(int number, int step) {
		throw new NotImplementedException();
	}

	/*
	 * Módulo al que se le pasa un número entero del 0 al 20 y devuelve los
	 * divisores que tiene.
	 */
	public static int[] divisors(int n) {
		int dividendo = 0;
		int numDivisores = 0;
		int divisores[];
		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				numDivisores++;
			}

		}
		divisores = new int[numDivisores];

		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				divisores[numDivisores - 1] = n / i;
				numDivisores--;
				return null;
			}
		}
		return divisores;

	}

	/*
	 * Toma como parámetros una cadena de caracteres y devuelve cierto si la cadena
	 * resulta ser un palíndromo
	 */
	public static boolean checkIsPalindrome(String cadena) {
		throw new NotImplementedException();
	}

	/*
	 * Pedir un número de 0 a 99 y mostrarlo escrito. Por ejemplo, para 56 mostrar:
	 * cincuenta y seis
	 */
	public static String speakToMe(int n) {
		String numero = null;
		String unidades[] = { "Uno", "Dos", "Tres", "Cuatro", "Cinco", "Seis", "Sieta", "Ocho", "Nueve" };
		String decenas[] = { "Diez", "Veinte", "Treinta", "Cuarenta", "Cincuenta", "Sesenta", "Setenta", "Ochenta",
				"Noventa" };
		if (n > 100) {
			if (n / 10 < 1) {
				numero = unidades[(n / 10) - 1];
			}
		}

		return numero;
	}

	/*
	 * este metodo devuelve cierto si el año de la fecha es bisiesto fecha
	 * dd-MM-yyyy
	 */
	public static boolean isLeapYear(String fecha) {
		int año;
		if (fecha.isEmpty())
			return false;
		else {
			año = Integer.parseInt(fecha.substring(6));

			if (año % 4 == 0) {
				if (año % 100 != 0)
					return true;
				else if (año % 400 == 0)
					return true;
				else
					return false;
			} else
				return false;
		}
	}

	/*
	 * este metodo devuelve cierto si la fecha es válida
	 */
	public static boolean isValidDate(String date) {
		throw new NotImplementedException();
	}
}
