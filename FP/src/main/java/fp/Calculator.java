package fp;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.NotImplementedException;
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
		List<Integer> listaFibo = new ArrayList<Integer>();
		int n1 = 0, n2 = 1, n3 = 0;
		for (int i = 0; i < n; i++) {
			n3 = n1 + n2;
			n2 = n1;
			n1 = n3;
			listaFibo.add(n3);

		}

		return listaFibo;
	}

	/*
	 * Escribir todos los números del number al 0 de step en step.
	 */
	public static int[] stepThisNumber(int number, int step) {
		List<Integer> listaNumeros = new ArrayList<Integer>();
		while(number - step > 0){
			listaNumeros.add(number - step);
			number -= step;
		}
		int[] numeros = new int[listaNumeros.size()];
		for(int i = 0; i < numeros.length; i++){
			numeros[i] = listaNumeros.get(i);
		}
		return numeros;
	}

	/*
	 * Módulo al que se le pasa un número entero del 0 al 20 y devuelve los
	 * divisores que tiene.
	 */
	public static int[] divisors(int n) {
		throw new NotImplementedException("no implementado");
	}

	/*
	 * Toma como parámetros una cadena de caracteres y devuelve cierto si la cadena resulta ser un palíndromo
	 */
	public static boolean checkIsPalindrome(String cadena) {
		if(cadena == null){
			return false;
		}
		else{
			cadena = cadena.replace(" ", "");
			cadena = cadena.replace(",", "");
			cadena = cadena.replace(".", "");
			System.out.print(cadena);
			int fin = cadena.length() - 1;
			int ini = 0;
			boolean espalin = true;

			while (ini < fin) {
				if (cadena.charAt(ini) != cadena.charAt(fin)){
					espalin = false;
				}
				ini++;
				fin--;
			}
			return espalin;
		}
	}

	/*
	 * Pedir un número de 0 a 99 y mostrarlo escrito. Por ejemplo, para 56
	 * mostrar: cincuenta y seis
	 */
	public static String speakToMe(int n) {
		throw new NotImplementedException("no implementado");
	}

	/*
	 * este metodo devuelve cierto si el año de la fecha es bisiesto fecha
	 * dd-MM-yyyy
	 */
	public static boolean isLeapYear(String fecha) {
		throw new NotImplementedException("no implementado");
	}

	/*
	 * este metodo devuelve cierto si la fecha es válida
	 */
	public static boolean isValidDate(String date) {
		throw new NotImplementedException("no implementado");
	}
}
