package fp;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import java.util.ArrayList;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Calculator {
	/*
	 * este metodo devuelve el Class del object que le pasamos
	 */
	public static Class classTypeOf(Object x) {
		Class a = x.getClass();
		return a;
	}

	/*
	 * devuelve una lista con los n números de la serie de fibonacci.
	 */
	public static List<Integer> fibonacci(int n) {
		// throw new NotImplementedException();
		List<Integer> a = new ArrayList<Integer>();
//		int m = 0;
//		Boolean y = false;
//		Integer l = null;
//		l = m;
//		m = l;
		int contador = 1;
		a.add(contador);

		for (int i = 1; i < n; i++) {
			int anterior = a.get(i - 1);
			a.add(contador);
			contador = anterior + contador;
		}
		return a;

	}

	/*
	 * Escribir todos los números del number al 0 de step en step.
	 */
	public static int[] stepThisNumber(int number, int step) {
		int tamArray = 0;
		int[] numeros;
		int i = 0;
		int auxnumber = number;

		while (auxnumber - step > 0) {
			auxnumber -= step;
			tamArray++;
		}
		numeros = new int[tamArray];
		while (number - step > 0) {
			numeros[i] = number - step;
			number -= step;
			i++;
		}
		return numeros;
	}

	/*
	 * Módulo al que se le pasa un número entero del 0 al 20 y devuelve los
	 * divisores que tiene.
	 */
	public static int[] divisors(int n) {
		int aux = 0;
		if (n == 0) {
			return null;
		}
		for (int i = 1; i <= n; i++)
			if (n % i == 0)
				aux++;
		int[] divisor = new int[aux];
		for (int i = n, j = 0; i > 0; i--)
			if (n % i == 0) {
				divisor[j] = i;
				j++;
			}
		return divisor;
	}

	/*
	 * Toma como parámetros una cadena de caracteres y devuelve cierto si la cadena
	 * resulta ser un palíndromo
	 */
	public static boolean checkIsPalindrome(String cadena) {
		if (cadena == null) {
			return false;
		} else {
			cadena = cadena.toLowerCase().replace("á", "a").replace("é", "e").replace("í", "i").replace("ó", "o")
					.replace("ú", "u").replace(" ", "").replace(".", "").replace(",", "").replace("?", "")
					.replace("¿", "").replace(":", "").replace("·", "");
			String invertir = new StringBuilder(cadena).reverse().toString();
			return invertir.equals(cadena);
		}
	}

	/*
	 * Pedir un número de 0 a 99 y mostrarlo escrito. Por ejemplo, para 56 mostrar:
	 * cincuenta y seis
	 */
	public static String speakToMe(int n) {
		int resultado;
		int unidad, decenas;
		String resultadoFrase = "";
		resultado = n;
		unidad = resultado % 10;
		decenas = resultado / 10;
		switch (decenas) {
		case 0:
			resultadoFrase = "";
			break;
		case 1:
			resultadoFrase = "Diez";
			break;
		case 2:
			resultadoFrase = "Veinte";
			break;
		case 3:
			resultadoFrase = "Treinta";
			break;
		case 4:
			resultadoFrase = "Cuarenta";
			break;
		case 5:
			resultadoFrase = "Cincuenta";
			break;
		case 6:
			resultadoFrase = "Sesenta";
			break;
		case 7:
			resultadoFrase = "Setenta";
			break;
		case 8:
			resultadoFrase = "Ochenta";
			break;
		case 9:
			resultadoFrase = "Noventa";
			break;
		}
		if ((n > 10) && unidad > 0) {
			resultadoFrase = resultadoFrase + " y ";
		} else {
			resultadoFrase = resultadoFrase + "";
		}
		switch (unidad) {
		case 0:
			resultadoFrase = resultadoFrase + "";
			break;
		case 1:
			resultadoFrase = resultadoFrase + "uno";
			break;
		case 2:
			resultadoFrase = resultadoFrase + "dos";
			break;
		case 3:
			resultadoFrase = resultadoFrase + "tres";
			break;
		case 4:
			resultadoFrase = resultadoFrase + "cuatro";
			break;
		case 5:
			resultadoFrase = resultadoFrase + "cinco";
			break;
		case 6:
			resultadoFrase = resultadoFrase + "seis";
			break;
		case 7:
			resultadoFrase = resultadoFrase + "siete";
			break;
		case 8:
			resultadoFrase = resultadoFrase + "ocho";
			break;
		case 9:
			resultadoFrase = resultadoFrase + "nueve";
			break;

		}
		if (n == 0) {
			return "Cero";
		} else {
			return resultadoFrase;
		}
	}

	/*
	 * este metodo devuelve cierto si el año de la fecha es bisiesto fecha
	 * dd-MM-yyyy
	 */
	public static boolean isLeapYear(String fecha) {
		if (fecha == "") {
			return false;
		}
		String year = fecha.substring(fecha.length() - 4);
		int anio = Integer.parseInt(year);
		if ((anio % 4 == 0) && ((anio % 100 != 0) || (anio % 400 == 0)))
			return true;
		else
			return false;
	}

	/*
	 * este metodo devuelve cierto si la fecha es válida
	 */
	public static boolean isValidDate(String date) {
		try {
			SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
			formatoFecha.setLenient(false);
			formatoFecha.parse(date);
		} catch (ParseException e) {
			return false;
		}
		return true;
	}
}
