package fp;

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
		java.util.List<Integer> list;
		list = new java.util.ArrayList<Integer>();
		int n1 = 0;
		int n2 = 1;
		int result;
		for (int i = 0; i < n; i++) {
			result = n1 + n2;
			n2 = n1;
			n1 = result;
			list.add(result);

		}

		return list;

	}

	/*
	 * Escribir todos los números del number al 0 de step en step.
	 */
	public static int[] stepThisNumber(int number, int step) {
		int length = 0;
		if (step > 0 && number > 0) {
			length = (number - 1) / step;
			int steps[] = new int[length];
			for (int i = 0; i < steps.length; i++) {
				number -= step;
				steps[i] = number;
			}
			return steps;
		} else
			return new int[0];
	}

	/*
	 * Módulo al que se le pasa un número entero del 0 al 20 y devuelve los
	 * divisores que tiene.
	 */
	public static int[] divisors(int n) {
		if (n == 0)
			return null;
		else {
			int divisors[] = new int[n];
			int j = 0;
			for (int i = n; i > 0; i--)
				if (n % i == 0) {
					divisors[j] = i;
					j++;
				}
			int result[] = new int[j];
			for (int x = 0; x < j; x++)
				result[x] = divisors[x];
			return result;
		}

	}

	/*
	 * Toma como parámetros una cadena de caracteres y devuelve cierto si la cadena
	 * resulta ser un palíndromo
	 */
	public static boolean checkIsPalindrome(String cadena) {
		boolean valor = true;
		int i, ind;
		String cadena2 = "";
		if (cadena == null)
			return false;
		// quitamos los espacios
		for (int x = 0; x < cadena.length(); x++) {
			if (cadena.charAt(x) != ' ')
				cadena2 += cadena.charAt(x);
		}
		cadena = cadena2;
		ind = cadena.length();
		for (i = 0; i < (cadena.length()); i++) {
			if (cadena.substring(i, i + 1).equals(cadena.substring(ind - 1, ind)) == false) {
				valor = false;
				break;
			}
			ind--;
		}
		return valor;
	}

	/*
	 * Pedir un número de 0 a 99 y mostrarlo escrito. Por ejemplo, para 56 mostrar:
	 * cincuenta y seis
	 */
	public static String speakToMe(int n) {
		String number = "";
		String units[] = { "Cero", "Uno", "Dos", "Tres", "Cuatro", "Cinco", "Seis", "Siete", "Ocho", "Nueve", "Diez" };
		String specials[] = { "Once", "Doce", "Trece", "Catorce", "Quince", "Diezciseis", "Diecisiete", "Dieciocho",
				"Diecinueve" };
		String tens[] = { "Veinte", "Treinta", "Cuarenta", "Cincuenta", "Sesenta", "Setenta", "Ochenta", "Noventa" };
		String T_units[] = { "cero", "uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve",
				"diez" };

		if (n >= 0 && n < 11) {
			number = units[n];
			return number;
		} else if (n < 20) {
			number = specials[n - 11];
			return number;
		} else if (n < 100) {
			int unid = n % 10;
			int dec = n / 10;
			if (unid == 0) {
				number = tens[dec - 2];
				return number;
			} else {
				number = tens[dec - 2] + " y " + T_units[unid];
				return number;
			}

		}
		return null;
	}

	/*
	 * este metodo devuelve cierto si el año de la fecha es bisiesto fecha
	 * dd-MM-yyyy
	 */
	public static boolean isLeapYear(String date) {
		int year;
		if (date.isEmpty())
			return false;
		else {
			year = Integer.parseInt(date.substring(6));

			if (year % 4 == 0) {
				if (year % 100 != 0)
					return true;
				else if (year % 400 == 0)
					return true;
				else
					return false;
			} else
				return false;
		}
	}

	/*
	 * este metodo devuelve cierto si la fecha es válida
	 */
	public static boolean isValidDate(String date) {
		Integer year;
		Integer month;
		Integer day;
		if (date.length() != 10)
			return false;
		else {
			day = Integer.parseInt(date.substring(0, 2));
			month = Integer.parseInt(date.substring(3, 5));
			year = Integer.parseInt(date.substring(6));

			if (year != null && month <= 12 && month > 0 && day > 0 && year > 0) {
				if ((month == 4 || month == 6 || month == 7 || month == 9 || month == 11) && day <= 30) {
					return true;
				} else {
					if ((month == 2 && isLeapYear(date) && day <= 29)
							|| (month == 2 && !(isLeapYear(date)) && day <= 28)) {
						return true;
					} else {
						if ((month != 2) && day <= 31)
							return true;
						else
							return false;
					}
				}
			} else
				return false;
		}
	}
}
