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
		 List<Integer> numeros = new ArrayList<Integer>();
		 int n1 = 0;
	     int n2 = 1;
	     int aux;
	     numeros.add(n2);
         for(int i = 1; i < n; i++) {
            aux = n1;
            n1 = n2;
            n2 = aux + n1;
            numeros.add(n2);
        }
         return numeros;
		 
		//throw  new NotImplementedException();
	}

	/*
	 * Escribir todos los numeros del number al 0 de step en step.
	 */
	public static int[] stepThisNumber(int number, int step) {
		int n = number-step;
		int d = number-step;
		int contador=0;
		while (d>0) {
			contador++;
			d=d-step;
		}
		
		int numbers[] = new int[contador];
		if(number == 0 && step == 0){
			return numbers;
		}else{
			int i = 0;
			for (int j = 0; j < numbers.length; j++) {
				numbers[j] = n;
				n=n-step;
			}
			return numbers;
		}
	}

	/*
	 * Módulo al que se le pasa un número entero del 0 al 20 y devuelve los
	 * divisores que tiene.
	 */
	public static int[] divisors(int n) {
		if(n == 0)
			return null;
		else{
			int j = 0;
			int contador = 0;
			for (int i = 1; i <= n ; i++)
	            if (n % i == 0)
	                contador ++;
	            
			int divisors[] = new int[contador];
			for (int i = n; i >= 1 ; i--)
	            if (n % i == 0){
	                divisors[j] = i;
	                j++;
	            }
	        
			return divisors;
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
