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
		List<Integer> nums;
		nums = new ArrayList<Integer>();

		int f1 = 0;
		int f2 = 1;
		int f3 = 1;

		for (int i=0; i<n; i++) {
			nums.add(f3);
			f3 = f1 + f2;
			f1 = f2;
			f2 = f3;
		}

		return nums;
	}

	/*
	 * Escribir todos los números del number al 0 de step en step.
	 */
	public static int[] stepThisNumber(int number, int step) {
		int aux = number-step;

		List<Integer> numerosList;
		numerosList = new ArrayList<Integer>();
		while(aux > 0) {
			numerosList.add(aux);
			aux -= step;
		}

		int[] steps;
		steps = new int[numerosList.size()];

		for (int i=0; i<numerosList.size(); i++) {
			steps[i] = numerosList.get(i);
		}

		return steps;
	}

	/*
	 * Módulo al que se le pasa un número entero del 0 al 20 y devuelve los
	 * divisores que tiene.
	 */
	public static int[] divisors(int n) {
		if (n == 0)
			return null;
		else if (n == 1) {
			int v[] = {1};
			return v;
		}
			
		List<Integer> nums;
		nums = new ArrayList<Integer>();
		
		for (int e=n/2; e>0; e--)
			if (n%e == 0)
				nums.add(e);

		int[] divisores;
		divisores = new int [nums.size()+1];

		for (int i=0; i<nums.size(); i++) {
			divisores[i+1] = nums.get(i);
		}

		divisores[0] = n;

		return divisores; 
	}

	/*
	 * Toma como parámetros una cadena de caracteres y devuelve cierto si la cadena resulta ser un palíndromo
	 */
	public static boolean checkIsPalindrome(String cadena) {
		throw new NotImplementedException("no implementado");
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
