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
	
	public static String convertirEstandar(String frase){
		frase = frase.replace(" ", "");
		frase = frase.replace(".", "");
		frase = frase.replace(",", "");
		frase = frase.replace("¿", "");
		frase = frase.replace("?", "");
		frase = frase.replace("!", "");
		frase = frase.replace("¡", "");
		frase = frase.replace("·", "");
		frase = frase.replace(":", "");
		frase = frase.toLowerCase();
		String original = "áàäéèëíìïóòöúùuñÁÀÄÉÈËÍÌÏÓÒÖÚÙÜÑçÇ";
	    String ascii = "aaaeeeiiiooouuunAAAEEEIIIOOOUUUNcC";
	    for (int i=0; i<original.length(); i++) {
	    	frase = frase.replace(original.charAt(i), ascii.charAt(i));
	    }
		return frase;
	}
	
	public static boolean checkIsPalindrome(String cadena) {
		if(cadena == null)
			return true;
		else{
			cadena = convertirEstandar(cadena);
			int inc = 0;
			int des = cadena.length()-1;
			boolean palindromo = true;
			
			while ((inc<des) && (palindromo)){
				if (cadena.charAt(inc)==cadena.charAt(des)){	
					inc++;
					des--;
				} else {
					palindromo = false;
				}
			}
			return palindromo;
		}
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
		int year;
		if(fecha==null||fecha == ""){
			return false;
		}else{
			year=(int) Integer.parseInt(fecha.substring(fecha.length() -4));
			if (year % 4 != 0)
				return false;
			else if(year % 100 != 0)
				return true;
			else if(year % 400 != 0)
				return false;
			else
				return true;
		}
		
	}

	/*
	 * este metodo devuelve cierto si la fecha es válida
	 */
	public static boolean isValidDate(String date) {
		
		if(date == null || date == ""){
			return false;
		}else if(date.length() == 10){
			if ((date.substring(6, 10) != "0000") && (date.substring(0, 2) != "32") &&  (date.substring(0, 2) != "00")  && (date.substring(3, 5) != "00") && (date.substring(3, 5) != "13"))
				if (date.charAt(2) == '-' && date.charAt(5) == '-') {
					System.out.println(date.substring(0, 2) != "00"); 
					System.out.println(date);
					return true;
				}
				
		}
		return false;
	}
}
