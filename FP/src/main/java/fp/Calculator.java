package fp;

import java.util.List;
import java.util.ArrayList;

import org.apache.commons.lang3.NotImplementedException;

public class Calculator {

	/*
	 * este metodo devuelve el Class del object que le pasamos
	 */
	public static Class classTypeOf(Object x) {
		if (x == null) {
			throw new NotImplementedException("no implementado");
		}
		return x.getClass();
	}

	/*
	 * devuelve una lista con los n números de la serie de fibonacci.
	 */
	public static List<Integer> fibonacci(int n) {
		if (n < 0) {
			throw new NotImplementedException("no implementado");
		}
		List<Integer> lista = new ArrayList<Integer>();
		int numero = 1;
		lista.add(numero);
		lista.add(numero);
		for (int i = 2; i < n; i++) {
			numero = lista.get(i - 1) + lista.get(i - 2);
			lista.add(numero);
		}
		return lista;
	}

	/*
	 * Escribir todos los números del number al 0 de step en step.
	 */
	public static int[] stepThisNumber(int number, int step) {
		if (number < 0 || step < 0) {
			throw new NotImplementedException("no implementado");
		}
		if (number == 0) {
			return new int[] { 0 };
		}
		int[] lista = new int[((number - 1) / step)];
		for (int i = 0; i < lista.length; i++) {
			lista[i] = number - ((i + 1) * step);
		}
		return lista;
	}

	/*
	 * Módulo al que se le pasa un número entero del 0 al 20 y devuelve los
	 * divisores que tiene.
	 */
	public static int[] divisors(int n) {
		if (n < 0 || n > 20) {
			throw new NotImplementedException("no implementado");
		}
		if (n == 0) {
			return null;
		}
		int contador = 0;
		int[] lista1 = new int[n];
		for (int i = lista1.length; i > 0; i--) {
			if (n % i == 0) {
				lista1[contador] = i;
				contador++;
			}
		}
		int[] lista2 = new int[contador];
		for (int i = 0; i < lista2.length; i++) {
			lista2[i] = lista1[i];
		}
		return lista2;
	}

	/*
	 * Toma como parámetros una cadena de caracteres y devuelve cierto si la cadena
	 * resulta ser un palíndromo
	 */
	public static boolean checkIsPalindrome(String cadena) {
		if (cadena == null) {
			return false;
		}
		String cadena2 = cadena.toLowerCase();
		String letters2 = "aaaeeeiiiooouuunAAAEEEIIIOOOUUUNcC           ";
		String letters = "áàäéèëíìïóòöúùuñÁÀÄÉÈËÍÌÏÓÒÖÚÙÜÑçÇ:;-_,.?¿¡!·";
		for (int i = 0; i < cadena2.length(); i++) {
			for (int j = 0; j < letters2.length(); j++) {
				if (cadena2.charAt(i) == letters2.charAt(j)) {
					cadena2 = cadena2.replace(cadena2.charAt(i), letters.charAt(j));
				}
			}
		}
		String cadena3 = "";
		for (int i = 0; i < cadena2.length(); i++) {
			if (cadena2.charAt(i) >= 'a' && cadena2.charAt(i) <= 'z') {
				cadena3 += cadena2.charAt(i);
			}
		}
		for (int i = 0; i < cadena3.length() / 2; i++) {
			if (cadena3.charAt(i) != cadena3.charAt(cadena3.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}

	/*
	 * Pedir un número de 0 a 99 y mostrarlo escrito. Por ejemplo, para 56
	 * mostrar: cincuenta y seis
	 */
	public static String speakToMe(int n) {
		if (n < 0 || n > 99) {
			throw new NotImplementedException("no implementado");
		}
		String[] unidades = { "Cero", "uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve" };
		String[] decenas = { "Diez", "Once", "Doce", "Trece", "Catorce", "Quince", "Dieciséis", "Diecisiete",
				"Dieciocho", "Diecinueve" };
		String[] decenas2 = { "Veinte", "Treinta", "Cuarenta", "Cincuenta", "Sesenta", "Setenta", "Ochenta",
				"Noventa" };

		if (n < 10) {
			return unidades[n];
		} else if (n < 20) {
			return decenas[n - 10];
		} else if (n == 20) {
			return decenas2[n / 10 - 2];
		} else if (n < 30) {
			return "veinti" + unidades[n - 20];
		} else if (n == 30) {
			return decenas2[n / 10 - 2];
		} else if (n < 40) {
			return decenas2[n / 10 - 2] + " y " + unidades[n - 30];
		} else if (n == 40) {
			return decenas2[n / 10 - 2];
		} else if (n < 50) {
			return decenas2[n / 10 - 2] + " y " + unidades[n - 40];
		} else if (n == 50) {
			return decenas2[n / 10 - 2];
		} else if (n < 60) {
			return decenas2[n / 10 - 2] + " y " + unidades[n - 50];
		} else if (n == 60) {
			return decenas2[n / 10 - 2];
		} else if (n < 70) {
			return decenas2[n / 10 - 2] + " y " + unidades[n - 60];
		} else if (n == 70) {
			return decenas2[n / 10 - 2];
		} else if (n < 80) {
			return decenas2[n / 10 - 2] + " y " + unidades[n - 70];
		} else if (n == 80) {
			return decenas2[n / 10 - 2];
		} else if (n < 90) {
			return decenas2[n / 10 - 2] + " y " + unidades[n - 80];
		} else if (n == 90) {
			return decenas2[n / 10 - 2];
		} else {
			return decenas2[n / 10 - 2] + " y " + unidades[n - 90];
		}
	}

	/*
	 * este metodo devuelve cierto si el año de la fecha es bisiesto fecha
	 * dd-MM-yyyy
	 */
	public static boolean isLeapYear(String fecha) {
		if (fecha == null) {
			return false;
		}
		if (fecha.length() != 10) {
			return false;
		}
		String[] fecha2 = fecha.split("-");
		int anio = Integer.parseInt(fecha2[2]);
		return (anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0);
	}

	/*
	 * este metodo devuelve cierto si la fecha es válida
	 */
	public static boolean isValidDate(String date) {
		throw new NotImplementedException("no implementado");
	}
}
