package fp;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
public class Calculator {


	/*
     * este metodo devuelve el Class del object que le pasamos
     */
	public static Class classTypeOf(Object x) {
		Class obtenerClase = x.getClass();
		return obtenerClase;
	}


	/*
     * devuelve una lista con los n números de la serie de fibonacci.
     */
	public static List<Integer> fibonacci(int n) {
		List<Integer> lista = new ArrayList<Integer>();
		int numero = 1;
		lista.add(numero);
		lista.add(numero);
		for (int i = 2; i < n; i++) {
			lista.add(lista.get(i - 1) + lista.get(i - 2));
		}
		return lista;
	}

	/*
	 * Escribir todos los números del number al 0 de step en step.
	 */
	public static int[] stepThisNumber(int number, int step) {
		List<Integer> stepList = new ArrayList<>();
		while (number - step > 0) {
			stepList.add(number -= step);
		}
		return ListToArray(stepList);
	}

	public static int[] ListToArray(List<Integer> list) {
		int[] intArray = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			intArray[i] = list.get(i);
		}
		return intArray;
	}

	/*
	 * Módulo al que se le pasa un número entero del 0 al 20 y devuelve los
	 * divisores que tiene.
	 */
	public static int[] divisors(int n) {
		if (n == 0)
			return null;
		List<Integer> divisorsList = new ArrayList<Integer>();
		if (n >= 0 && n <= 20) {
			int counter = 0;
			for (int i = 20; i > 0; i--) {
				if (n % i == 0) {
					divisorsList.add(i);
				}
			}

			return ListToArray(divisorsList);
		}
		return new int[] { -1 };
	}

	/*
	 * Toma como parámetros una cadena de caracteres y devuelve cierto si la cadena resulta ser un palíndromo
	 */
	public static boolean checkIsPalindrome(String cadena) {
		if (cadena == null) {
			return false;
		}
		String cadena2 = StringUtils.stripAccents(cadena).toLowerCase();
		cadena2 = cadena2.replaceAll(" ", "");
		cadena2 = cadena2.replaceAll("\\.", "");
		cadena2 = cadena2.replaceAll(",", "");
		cadena2 = cadena2.replaceAll("\\?", "");
		cadena2 = cadena2.replaceAll("\\¿", "");
		cadena2 = cadena2.replaceAll(":", "");
		cadena2 = cadena2.replaceAll("·", "");

		int i = 0, j = cadena2.length() - 1;
		while (i < j) {
			if (cadena2.charAt(i) != cadena2.charAt(j)) {
				return false;
			}

			i++;
			j--;
		}

		return true;
	}

	/*
	 * Pedir un número de 0 a 99 y mostrarlo escrito. Por ejemplo, para 56
	 * mostrar: cincuenta y seis
	 */
	public static String speakToMe(int n) {
		int valor;
		int unidades;
		int decenas;
		String numeroEscrito = "";
		unidades = n % 10;
		decenas = n / 10;

		switch (decenas) {
		case 0:
			numeroEscrito = "";
			break;
		case 1:
			numeroEscrito = "Diez";
			break;
		case 2:
			numeroEscrito = "Veinte";
			break;
		case 3:
			numeroEscrito = "Treinta";
			break;
		case 4:
			numeroEscrito = "Cuarenta";
			break;
		case 5:
			numeroEscrito = "Cincuenta";
			break;
		case 6:
			numeroEscrito = "Sesenta";
			break;
		case 7:
			numeroEscrito = "Setenta";
			break;
		case 8:
			numeroEscrito = "Ochenta";
			break;
		case 9:
			numeroEscrito = "Noventa";
			break;
		}
		switch (unidades) {
		case 0:
			numeroEscrito = numeroEscrito + "";
			break;
		case 1:
			numeroEscrito = numeroEscrito + "uno";
			break;
		case 2:
			numeroEscrito = numeroEscrito + "dos";
			break;
		case 3:
			numeroEscrito = numeroEscrito + "tres";
			break;
		case 4:
			numeroEscrito = numeroEscrito + "cuatro";
			break;
		case 5:
			numeroEscrito = numeroEscrito + "cinco";
			break;
		case 6:
			numeroEscrito = numeroEscrito + "seis";
			break;
		case 7:
			numeroEscrito = numeroEscrito + "siete";
			break;
		case 8:
			numeroEscrito = numeroEscrito + "ocho";
			break;
		case 9:
			numeroEscrito = numeroEscrito + "nueve";
			break;

		}
		if (n == 0)
			return "Cero";
		return numeroEscrito;
	}

	/*
	 * este metodo devuelve cierto si el año de la fecha es bisiesto fecha
	 * dd-MM-yyyy
	 */
	public static boolean isLeapYear(String fecha) {
		if (fecha == "")
			return false;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		return LocalDate.parse(fecha, formatter).isLeapYear();
	}

	/*
	 * este metodo devuelve cierto si la fecha es válida
	 */
	public static boolean isValidDate(String date) {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		dateFormat.setLenient(false);
		try {
			dateFormat.parse(date);
		} catch (ParseException e) {
			return false;
		}
		return true;
	}
}
