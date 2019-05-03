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
		List<Integer> list = new ArrayList<Integer>();
		int n1 = 0;
		int n2 = 1;
		list.add(n2);
		for(int i = 0; i< n - 1; i++){
			n2 = n1 + n2;
			n1 = n2 - n1;
			list.add(n2);
		}
		return list;
	}

	/*
	 * Escribir todos los números del number al 0 de step en step.
	 */
	public static int[] stepThisNumber(int number, int step) {
		int numbers[];
		List<Integer> listNumbers = new ArrayList<Integer>();
		if (step != 0) {
			for (int i = 1; i <= number / step; i++)
				if (number - step * i > 0)
					listNumbers.add(number - step * i);
		}
		numbers = new int[listNumbers.size()];
		for (int i = 0; i < listNumbers.size(); i++)
			numbers[i] = listNumbers.get(i);
		return numbers;
	}

	/*
	 * Módulo al que se le pasa un número entero del 0 al 20 y devuelve los
	 * divisores que tiene.
	 */
	public static int[] divisors(int n) {
		int[] divisors = null;
		if (n > 0) {
			List<Integer> listDivisors = new ArrayList<Integer>();
			listDivisors.add(n);
			for (int i = n / 2; i > 0; i--)
				if (n % i == 0) {
					listDivisors.add(i);
				}
			divisors = new int[listDivisors.size()];
			for (int i = 0; i < listDivisors.size(); i++)
				divisors[i] = listDivisors.get(i);
		}
		return divisors;
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
	public static boolean isLeapYear(String date) {
		if (isValidDate(date)) {
			String year = date.substring(date.length() - 4);
			int yearInt = Integer.parseInt(year);
			if (yearInt % 4 == 0 && yearInt % 100 != 0 || yearInt % 400 == 0)
				return true;
		}
		return false;
	}

	/*
	 * este metodo devuelve cierto si la fecha es válida
	 */
	public static boolean isValidDate(String date) {
		String yearStr, monthStr, dayStr;
		int year, month, day;
		String patron = "\\d{2}" + "-" + "\\d{2}" + "-" + "\\d{4}";
		if (date.matches(patron)) {
			yearStr = date.substring(date.length() - 4);
			monthStr = date.substring(3, 5);
			dayStr = date.substring(0, 2);
			year = Integer.parseInt(yearStr);
			month = Integer.parseInt(monthStr);
			day = Integer.parseInt(dayStr);
			if (year >= 1 && month >= 1 && month < 13 && day >= 1 && day < 32)
				return true;
		}
		return false;
	}
}
