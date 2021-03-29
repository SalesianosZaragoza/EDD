package fp;

import java.text.DateFormat;
import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Calculator {


	/*
	 * este metodo devuelve el Class del object que le pasamos
	 */
	public static Class classTypeOf(java.io.Serializable x) {

		return x.getClass();
	}


	/*
	 * devuelve una lista con los n números de la serie de fibonacci.
	 */
	public static List<Integer> fibonacci(int n) {

		List<Integer> numbers = new ArrayList<>();
		Integer n1 = 0;
		Integer n2 = 1;
		numbers.add(1);

		for (int i = 0; i < n - 1; i++) {

			Integer summa = n1 + n2;
			n1 = n2;
			n2 = summa;
			numbers.add(summa);

		}

		return numbers;

	}

	/*
	 * Escribir todos los números del number al 0 de step en step.
	 */
	public static int[] stepThisNumber(int number, int step) {

		ArrayList<Integer> solve = new ArrayList<>();

		while (number - step > 0) {

			solve.add(number -= step);
		}

		return convertIntegers(solve);

	}

	/*
	 * Módulo al que se le pasa un número entero del 0 al 20 y devuelve los
	 * divisores que tiene.
	 */
	public static int[] divisors(int n) {

		if (n == 0) return null;

		ArrayList<Integer> solve = new ArrayList<>();

		for (int i = n; i > 0; i--) {

			if (n % i == 0) {

				solve.add(i);
			}
		}

		return convertIntegers(solve);
	}

	/*
	 * Toma como parámetros una cadena de caracteres y devuelve cierto si la cadena resulta ser un palíndromo
	 */
	public static boolean checkIsPalindrome(String cadena) {

		if (cadena == null) return false;

		String chain = Normalizer.normalize(cadena, Normalizer.Form.NFD);
		chain = chain.replaceAll("[^\\p{ASCII}]", "");
		chain = chain.replaceAll("[^a-z,^A-Z]", "");
		chain = chain.replaceAll("[\s,]", "");
		chain = chain.toLowerCase();

		for (int i = 0; i < chain.length() / 2; i++) {

			if (chain.charAt(i) != chain.charAt(chain.length() - i - 1)) return false;
		}

		return true;
	}

	/*
	 * Pedir un número de 0 a 99 y mostrarlo escrito. Por ejemplo, para 56
	 * mostrar: cincuenta y seis
	 */
	public static String speakToMe(int n) {

		if (n == 0) return "Cero";

		StringBuilder result = new StringBuilder();
		int centenas = n / 100;
		int decenas = (n % 100) / 10;
		int unidades = (n % 10);


		switch (centenas) {
			case 0:
				break;
			case 1:
				if (decenas == 0 && unidades == 0) {
					result.append("Cien ");
					return result.substring(0, result.length() - 1);
				} else result.append("Ciento ");
				break;
			case 2:
				result.append("Doscientos ");
				break;
			case 3:
				result.append("Trescientos ");
				break;
			case 4:
				result.append("Cuatrocientos ");
				break;
			case 5:
				result.append("Quinientos ");
				break;
			case 6:
				result.append("Seiscientos ");
				break;
			case 7:
				result.append("Setecientos ");
				break;
			case 8:
				result.append("Ochocientos ");
				break;
			case 9:
				result.append("Novecientos ");
				break;
		}

		switch (decenas) {
			case 0:
				break;
			case 1:
				if (unidades == 0) {
					result.append("Diez ");
					return result.substring(0, result.length() - 1);
				} else if (unidades == 1) {
					result.append("Once ");
					return result.substring(0, result.length() - 1);
				} else if (unidades == 2) {
					result.append("Doce ");
					return result.substring(0, result.length() - 1);
				} else if (unidades == 3) {
					result.append("Trece ");
					return result.substring(0, result.length() - 1);
				} else if (unidades == 4) {
					result.append("Catorce ");
					return result.substring(0, result.length() - 1);
				} else if (unidades == 5) {
					result.append("Quince ");
					return result.substring(0, result.length() - 1);
				} else result.append("Dieci");
				break;
			case 2:
				if (unidades == 0) {
					result.append("Veinte ");
					return result.substring(0, result.length() - 1);
				} else result.append("Veinti");
				break;
			case 3:
				result.append("Treinta ");
				break;
			case 4:
				result.append("Cuarenta ");
				break;
			case 5:
				result.append("Cincuenta ");
				break;
			case 6:
				result.append("Sesenta ");
				break;
			case 7:
				result.append("Setenta ");
				break;
			case 8:
				result.append("Ochenta ");
				break;
			case 9:
				result.append("Noventa ");
				break;
		}

		if (decenas > 2 && unidades > 0)
			result.append("y ");

		switch (unidades) {
			case 0:
				break;
			case 1:
				result.append("Un ");
				break;
			case 2:
				result.append("Dos ");
				break;
			case 3:
				result.append("Tres ");
				break;
			case 4:
				result.append("Cuatro ");
				break;
			case 5:
				result.append("Cinco ");
				break;
			case 6:
				result.append("Seis ");
				break;
			case 7:
				result.append("Siete ");
				break;
			case 8:
				result.append("Ocho ");
				break;
			case 9:
				result.append("Nueve ");
				break;
		}

		return result.substring(0, result.length() - 1);
	}

	/*
	 * este metodo devuelve cierto si el año de la fecha es bisiesto fecha
	 * dd-MM-yyyy
	 */
	public static boolean isLeapYear(String fecha) {

		try {

			DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
			df.setLenient(false);               // Para que no acepte valores invalidos como dia 56 o cosas así
			df.parse(fecha);                     // Si hay valores invalidos petará aquí

			return df.getCalendar().getActualMaximum(Calendar.DAY_OF_YEAR) > 365;

		} catch (ParseException e) {

			return false;
		}
	}

	/*
	 * este metodo devuelve cierto si la fecha es válida
	 */
	public static boolean isValidDate(String date) {

		try {

			DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
			df.setLenient(false);               // Para que no acepte valores invalidos como dia 56 o cosas así
			df.parse(date);                     // Si hay valores invalidos petará aquí
			return true;
		} catch (ParseException e) {

			return false;
		}
	}

	private static int[] convertIntegers(ArrayList<Integer> integers) {

		int[] solve = new int[integers.size()];

		for (int i = 0; i < solve.length; i++) {

			solve[i] = integers.get(i);
		}

		return solve;
	}

}
