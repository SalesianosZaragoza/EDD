package fp;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import java.util.ArrayList;
import java.util.Calendar;

//import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class Calculator {


	
	/*
     * este metodo devuelve el Class del object que le pasamos
     */
	public static Class classTypeOf(Object x) {
		throw  new NotImplementedException();
		return x.getClass();
	}


	/*
     * devuelve una lista con los n números de la serie de fibonacci.
     */
	public static List<Integer> fibonacci(int n) {
		throw  new NotImplementedException();
		List<Integer>fibo;
		fibo = new ArrayList<Integer>();
		calculattingFibo(n, fibo);

		return fibo;

	}


	private static void calculattingFibo(int n, List<Integer> fibo) {
		int num1 = 0; int num2 = 1; int num3 = 0;
		for (int i = 0; i < n; i++) {
			num3 = num1 + num2;
			num2 = num1;
			num1 = num3;
			fibo.add(num3);
		}
	}

	/*
	 * Escribir todos los números del number al 0 de step en step.
	 */
	public static int[] stepThisNumber(int number, int step) {
		throw  new NotImplementedException();
		List<Integer>numList;
		numList = new ArrayList<Integer>();
		int[] nums = stepByStepMethod(number, step, numList);	

			return nums;

	}


	private static int[] stepByStepMethod(int number, int step, List<Integer> numList) {
		int n = number - step;	
		while(n > 0) {
			numList.add(n);
			n-=step;
		}
		int[] nums;
		nums = new int[numList.size()];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = numList.get(i);
		}
		return nums;
	}

	/*
	 * Módulo al que se le pasa un número entero del 0 al 20 y devuelve los
	 * divisores que tiene.
	 */
	public static int[] divisors(int n) {
		throw  new NotImplementedException();
		List<Integer>divisors;
		divisors = new ArrayList<Integer>();

		int numb = n;
		numb = numbIntoList(n, divisors, numb);	

		int[] dv;
		dv = divMethod(n, divisors);	
		return dv;
	}


	private static int[] divMethod(int n, List<Integer> divisors) {
		int[] dv;
		dv = new int[(divisors.size())];
		if(n == 0) {
			dv = null;
		}else {
			for (int i = 0; i < dv.length; i++) {
				dv[i] = divisors.get(i);
			}

		}
		return dv;
	}


	private static int numbIntoList(int n, List<Integer> divisors, int numb) {
		while(numb != 0) {
			if(n%numb == 0) {
				divisors.add(numb);
			}			
			numb--;
		}
		return numb;
	}
	/*
	 * Toma como parámetros una cadena de caracteres y devuelve cierto si la cadena resulta ser un palíndromo
	 */
	public static boolean checkIsPalindrome(String cadena) {
		throw  new NotImplementedException();
	}
		if (cadena == null) {

			 return false;	 
		}else {

			 return isPalindromeMethod(cadena);

			}
		}


	private static boolean isPalindromeMethod(String cadena) {
		String letters2 = "aaaeeeiiiooouuunAAAEEEIIIOOOUUUNcC           ";
		 String letters = "áàäéèëíìïóòöúùuñÁÀÄÉÈËÍÌÏÓÒÖÚÙÜÑçÇ:;-_,.?¿¡!·";
		 String out = cadena.toLowerCase();
		 String inver = "";

		 for (int i = 0; i < letters.length(); i++) {

			out = out.replace(letters.charAt(i), letters2.charAt(i));

			 }

			out = out.replace(" ", "");
			for (int i = out.length() - 1; i >= 0; i--)
				inver += out.charAt(i);
				if (out.equals(inver)) {
					return true;
				}else {
					return false;
			}
	}
	/*
	 * Pedir un número de 0 a 99 y mostrarlo escrito. Por ejemplo, para 56
	 * mostrar: cincuenta y seis
	 */
	public static String speakToMe(int n) {
		throw  new NotImplementedException();
		String[] units = {"uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve"};
		String[] tens = {"Diez", "Veinte", "Treinta", "Cuarenta", "Cincuenta", "Sesenta", "Setenta", "Ochenta", "Noventa"};
		String zero = "Cero";
		String numb="";
		numb = stringsResults(n, units, tens, zero, numb);
		return numb;
	}


	private static String stringsResults(int n, String[] units, String[] tens, String zero, String numb) {
		if(n == 0) {
			numb += zero;
		}else if(n < 10) {
			numb += units[n - 1];
		}else if(n%10 == 0) {
			numb += tens[(n/10) -1];
		}else {
			int unit = n%10;
			int ten = n/10;
			numb = tens[ten - 1] + " y " + units[unit - 1];
		}
		return numb;
	}

	/*
	 * este metodo devuelve cierto si el año de la fecha es bisiesto fecha
	 * dd-MM-yyyy
	 */
	public static boolean isLeapYear(String fecha) {
		throw  new NotImplementedException();
		if(fecha.isEmpty()) {			
			return false;			
		}else {
			return isALeapYear(fecha);
		}
	}


	private static boolean isALeapYear(String fecha) {
		String year = fecha;
		year = fecha.substring(6);
			int num = Integer.parseInt(year);
			if((num % 4 == 0) && ((num % 100 != 0)) || (num % 400 == 0)){

				return true;

			}else {

			return false;
		}
	}

	/*
	 * este metodo devuelve cierto si la fecha es válida
	 */

	public static boolean isValidDate(String date) {
		throw  new NotImplementedException();

		if (date != "" && date.length() == 10) {

			int day = Integer.parseInt(date.substring(0, 2));
			int month = Integer.parseInt(date.substring(3, 5));
			int year = Integer.parseInt(date.substring(6, 10));

			if (day >= 1 && day < 32) {
				if (month >= 1 && month < 13) {
					if (year != 0000) {
						return true;
					}
				}
			}
		}
		return false;
	}
}