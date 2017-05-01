package fp;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

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
		
		throw  new NotImplementedException();
	}

	/*
	 * Escribir todos los números del number al 0 de step en step.
	 */
	public static int[] stepThisNumber(int number, int step) {
		int numeros[];
		while(number != 0){
			number=-step;
		}
		
	}

	/*
	 * Módulo al que se le pasa un número entero del 0 al 20 y devuelve los
	 * divisores que tiene.
	 */
	public static int[] divisors(int n) {
		int[] divisores;
		for(int i=0;i<=n;i++){
			if(n%i==0)
				divisores[i]+=n;
				
		
		return divisores[i];
		}
			
		
	}

	/*
	 * Toma como parámetros una cadena de caracteres y devuelve cierto si la cadena resulta ser un palíndromo
	 */
	public static boolean checkIsPalindrome(String cadena) {
			    int primercaracter = 0;
			    int ultimocaracter = cadena.length() -1;

			    while(primercaracter < ultimocaracter) {
			      if(cadena.charAt(primercaracter) != cadena.charAt(ultimocaracter)) {
			        return false;
			      }
			      primercaracter ++;
				  ultimocaracter --;
			    }
			   

			    return true;
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
		int digito=fecha.length()-1;
		if(digito==4||digito==8)
			return true;
		else
			return false;
		
		
		
	}

	/*
	 * este metodo devuelve cierto si la fecha es válida
	 */
	public static boolean isValidDate(String date) {
		if(date=="##-##-####")
			return true;
		else
			return false;
		
	}
}
