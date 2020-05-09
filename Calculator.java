package fp;

import java.text.Normalizer;
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
		if (n > 0) {
			list.add(1);
			if (n > 1) {
				list.add(1);
				for (int i = 2; i < n; i++) {
					list.add(list.get(i - 1) + list.get(i - 2));
				}
			}
		}
		return list;
	}

	/*
	 * Escribir todos los números del number al 0 de step en step.
	 */
	public static int[] stepThisNumber(int number, int step) {
		int[] list = { 0 };
		if (number != 0 && step != 0) {
			if ((float) number / (float) step != number / step) {
				list = new int[number / step];
			} else {
				list = new int[(number / step) - 1];
			}

			for (int i = 0; i < list.length; i++) {
				list[i] = number - (step * (i + 1));
			}
		}
		return list;
	}

	/*
	 * Módulo al que se le pasa un número entero del 0 al 20 y devuelve los
	 * divisores que tiene.
	 */
	public static int[] divisors(int n) {
		if (n == 0)
			return null;
		else if (n == 1)
			return new int[] { 1 };
		else {
			int[] provisionalDivisors = new int[n / 2];
			provisionalDivisors[0] = n;
			int counter = 1;
			for (int i = provisionalDivisors.length; i > 0; i--) {
				if (n % i == 0) {
					provisionalDivisors[counter] = i;
					counter++;
				}
			}
			int[] divisors = new int[counter];
			for (int i = 0; i < divisors.length; i++) {
				divisors[i] = provisionalDivisors[i];
			}
			return divisors;
		}
	}

	/*
	 * Toma como parámetros una cadena de caracteres y devuelve cierto si la cadena
	 * resulta ser un palíndromo
	 */
	public static boolean checkIsPalindrome(String cadena) {
		if (cadena == null)
			return false;
		else {
			cadena = Normalizer.normalize(cadena, Normalizer.Form.NFD);
			cadena = cadena.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "").toLowerCase();
			String compare = "";
			for (int i = cadena.length() - 1; i >= 0; i--) {
				if (cadena.charAt(i) == '¿' || cadena.charAt(i) == '?' || cadena.charAt(i) == '.'
						|| cadena.charAt(i) == '!' || cadena.charAt(i) == '¡' || cadena.charAt(i) == ':'
						|| cadena.charAt(i) == ',' || cadena.charAt(i) == '·' || cadena.charAt(i) == '\''
						|| cadena.charAt(i) == '\"' || cadena.charAt(i) == ' ') {
					if (i == cadena.length() - 1)
						cadena = cadena.substring(0, i);
					else if (i == 0)
						cadena = cadena.substring(1, cadena.length());
					else
						cadena = cadena.substring(0, i) + cadena.substring(i + 1, cadena.length());
				} else
					compare += cadena.charAt(i);
			}
			compare = Normalizer.normalize(compare, Normalizer.Form.NFD);
			compare = compare.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "").toLowerCase();
			if (cadena.equals(compare))
				return true;
			else
				return false;
		}
	}

	/*
	 * Pedir un número de 0 a 99 y mostrarlo escrito. Por ejemplo, para 56 mostrar:
	 * cincuenta y seis
	 */
	public static String speakToMe(int n) {
		String number = "";
		String[] oneToFifteen = { "Cero", "Uno", "Dos", "Tres", "Cuatro", "Cinco", "Seis", "Siete", "Ocho", "Nueve",
				"Diez", "Once", "Doce", "Trece", "Catorce", "Quince" };
		String[] begining = { "Dieci", "Veinti", "Treinta", "Cuarenta", "Cincuenta", "Sesenta", "Setenta", "Ochenta",
				"Noventa" };
		int[] ns = { n / 10, n % 10 };
		if (n <= 15) {
			for (int i = 0; i <= n; i++) {
				if (n == i) {
					number += oneToFifteen[i];
				}
			}
		} else {
			if (n == 20)
				number = "Veinte";
			else {
				for (int i = 0; i < ns[0]; i++) {
					if (ns[0] == i + 1) {
						number += begining[i];
						break;
					}
				}
				if (ns[1] != 0) {
					number += " y ";
					for (int i = 0; i <= ns[1]; i++) {
						if (ns[1] == i) {
							number += oneToFifteen[i].toLowerCase();
							break;
						}
					}
				}
			}
		}
		return number;
	}

	/*
	 * este metodo devuelve cierto si el año de la fecha es bisiesto fecha
	 * dd-MM-yyyy
	 */
	public static boolean isLeapYear(String fecha) {
		try {
			int year = Integer.parseInt(fecha.substring(fecha.lastIndexOf('-') + 1));
			if ((year % 4 == 0) && (year % 400 == 0) || (year % 100 != 0))
				return true;
			else
				return false;
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * este metodo devuelve cierto si la fecha es válida
	 */
	public static boolean isValidDate(String date) {
		String[] dateStr = date.split("-");
		try {
			int day = Integer.parseInt(dateStr[0]), month = Integer.parseInt(dateStr[1]),
					year = Integer.parseInt(dateStr[2]);
			if (year == 0)
				return false;
			else if (isLeapYear(date) && month == 2 && day == 29) {
				return true;
			} else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10
					|| month == 12) {
				if (day > 0 && day <= 31) {
					return true;
				}
			} else if (month == 2) {
				if (day > 0 && day <= 28) {
					return true;
				}
			} else if (month == 4 || month == 6 || month == 9 || month == 11) {
				if (day > 0 && day <= 30) {
					return true;
				}
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}
}