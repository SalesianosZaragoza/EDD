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
		ArrayList<Integer>fibonacci= new ArrayList<Integer>();
		int a=1, b=0, aux;
		for(int x=0;x<n;x++){
			if(x==0){
				fibonacci.add(a);
			}else{
				fibonacci.add(a+b);
				aux=a;
				a=a+b;
				b=aux;
			}
		}
		return fibonacci;
	}

	/*
	 * Escribir todos los números del number al 0 de step en step.
	 */
	public static int[] stepThisNumber(int number, int step) {
		ArrayList<Integer>numero= new ArrayList<Integer>();
		int a=number-step;
		while(a>0){
			numero.add(a);
			a-=step;
		}
		int numeros[]= new int[numero.size()];
		for(int x=0;x<numeros.length;x++){
			numeros[x]= numero.get(x);
		}
		return numeros;
		}

	/*
	 * Módulo al que se le pasa un número entero del 0 al 20 y devuelve los
	 * divisores que tiene.
	 */
	public static int[] divisors(int n) {
		int numero=n;
		ArrayList<Integer>divisores= new ArrayList<Integer>();
		while(numero!=0){
			if(n%numero==0){
				divisores.add(numero);
			}
			numero--;
		}
		int div[]=new int[(divisores.size())];
		if(n==0){
			div=null;
		}else{
			for(int x=0;x<div.length;x++){
				div[x]=divisores.get(x);
			}
		}
		return div;
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
