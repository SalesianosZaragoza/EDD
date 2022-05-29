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

		List<Integer> lista = new ArrayList();
	        // Base cases
	        if (n >= 1) 
	        	lista.add(0, 1);
	        if (n >= 2)
	        	lista.add(1, 1);
	        int i=2;
	        while(i<n) {
		        lista.add(i, lista.get(i-1)+lista.get(i-2));
		        i++;
	        }
	        return lista;	     
	}

	/*
	 * Escribir todos los números del number al 0 de step en step.
	 */
	public static int[] stepThisNumber(int number, int step) {
		int [] lista;
		if (step==0||number==0) {
			lista = new int[1];
			lista [0] = 0;
		}else {
			int length = (number%step==0)?(number/step-1):(number/step);
			lista= new int[length];
			int i = number;
			int contador=0;
			while (i>step) {
				i -= step;
				lista[contador]=i;
				contador++;
			}
		}
		return lista;
	}

	/*
	 * Módulo al que se le pasa un número entero del 0 al 20 y devuelve los
	 * divisores que tiene.
	 */
	public static int[] divisors(int n) {
		ArrayList<Integer> divisores = new ArrayList();
		if (n==0) {
			return null;
		}
		int i=1;
		while (i<=n) {
			if (n%i==0)
				divisores.add(i);
			i++;
		}
		int[] lista = new int[divisores.size()];
		for (int j=0; j<lista.length; j++)
			lista[j]=divisores.get(lista.length-j-1);
		return lista;
		
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
