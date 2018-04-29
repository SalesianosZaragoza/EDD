package fp;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

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
		List<Integer> serieFibonacci = new ArrayList<Integer>();
		if (n > 0) {
			serieFibonacci.add(1);
			if (n > 1) {
				serieFibonacci.add(1);
				if (n > 2)
					for (int i = 2; i < n; i++)
						serieFibonacci.add(serieFibonacci.get(serieFibonacci.size() - 1)
								+ serieFibonacci.get(serieFibonacci.size() - 2));
			}
		}
		return serieFibonacci;
	}

	/*
	 * Escribir todos los números del number al 0 de step en step.
	 */
	public static int[] stepThisNumber(int number, int step) {
		int numeros[];
		List<Integer> listaNumeros = new ArrayList<Integer>();
		if (step != 0) {
			for (int i = 1; i <= number / step; i++)
				if (number - step * i > 0)
					listaNumeros.add(number - step * i);
		}
		numeros = new int[listaNumeros.size()];
		for (int i = 0; i < listaNumeros.size(); i++)
			numeros[i] = listaNumeros.get(i);
		return numeros;
	}

	/*
	 * Módulo al que se le pasa un número entero del 0 al 20 y devuelve los
	 * divisores que tiene.
	 */
	public static int[] divisors(int n) {
		int[] divisores = null;
		if (n > 0) {
			List<Integer> listaDivisores = new ArrayList<Integer>();
			listaDivisores.add(n);
			for (int i = n / 2; i > 0; i--)
				if (n % i == 0) {
					listaDivisores.add(i);
				}
			divisores = new int[listaDivisores.size()];
			for (int i = 0; i < listaDivisores.size(); i++)
				divisores[i] = listaDivisores.get(i);
		}
		return divisores;
	}

	/*
	 * Toma como parámetros una cadena de caracteres y devuelve cierto si la cadena
	 * resulta ser un palíndromo
	 */
	public static boolean checkIsPalindrome(String cadena) {
		boolean palindromo = true;
		String caracteresASustituir[] = { "[àá]", "[éè]", "[íï]", "[óò]", "[úü]" };
		String caracteresSustitutos[] = { "a", "e", "i", "o", "u" };
		if (cadena != null) {
			for (int i = 0; i < caracteresSustitutos.length; i++)
				cadena = cadena.replaceAll(caracteresASustituir[i], caracteresSustitutos[i]);
			cadena = cadena.toLowerCase().replaceAll("\\W", "");
			for (int i = 0; i < (cadena.length() / 2); i++)
				if (cadena.charAt(i) != cadena.charAt(cadena.length() - i - 1)) {
					palindromo = false;
					break;
				}
		} else
			palindromo = false;
		return palindromo;
	}

	/*
	 * Pedir un número de 0 a 99 y mostrarlo escrito. Por ejemplo, para 56 mostrar:
	 * cincuenta y seis
	 */
	public static String speakToMe(int n) {
		String[] unidades = { "cero", "uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve" };
		String[] diezAVeinte = { "diez", "once", "doce", "trece", "catorce", "quince", "dieciséis", "diecisiete",
				"dieciocho", "diecinueve" };
		String[] decenas = { "veinte", "treinta", "cuarenta", "cincuenta", "sesenta", "setenta", "ochenta", "noventa" };
		String numeroEnTexto = "";
		int numUnidad = n % 10;
		int numDecena = (n / 10) % 10;
		switch (numDecena) {
		case 0:
			numeroEnTexto += unidades[numUnidad];
			break;
		case 1:
			numeroEnTexto += diezAVeinte[numUnidad];
			break;
		default:
			if (numUnidad == 0)
				numeroEnTexto += decenas[numDecena - 2];
			else if (numDecena == 2) {
				numeroEnTexto += decenas[0].substring(0, decenas[0].length() - 1) + "i";
				switch (numUnidad) {
				case 2:
					numeroEnTexto += "dós";
					break;
				case 3:
					numeroEnTexto += "trés";
					break;
				case 6:
					numeroEnTexto += "séis";
					break;
				default:
					numeroEnTexto += unidades[numUnidad];
					break;
				}
			} else
				numeroEnTexto += decenas[numDecena - 2] + " y " + unidades[numUnidad];
			break;
		}
		numeroEnTexto = numeroEnTexto.substring(0, 1).toUpperCase() + numeroEnTexto.substring(1);
		return numeroEnTexto;
	}

	/*
	 * este metodo devuelve cierto si el año de la fecha es bisiesto fecha
	 * dd-MM-yyyy
	 */
	public static boolean isLeapYear(String fecha) {
		if (isValidDate(fecha)) {
			String anyo = fecha.substring(fecha.length() - 4);
			int anyoInt = Integer.parseInt(anyo);
			if (anyoInt % 4 == 0 && anyoInt % 100 != 0 || anyoInt % 400 == 0)
				return true;
		}
		return false;
	}

	/*
	 * este metodo devuelve cierto si la fecha es válida
	 */
	public static boolean isValidDate(String date) {
		String anyoStr, mesStr, diaStr;
		int anyo, mes, dia;
		String patron = "\\d{2}" + "-" + "\\d{2}" + "-" + "\\d{4}";
		if (date.matches(patron)) {
			anyoStr = date.substring(date.length() - 4);
			mesStr = date.substring(3, 5);
			diaStr = date.substring(0, 2);
			anyo = Integer.parseInt(anyoStr);
			mes = Integer.parseInt(mesStr);
			dia = Integer.parseInt(diaStr);
			if (anyo >= 1 && mes >= 1 && mes < 13 && dia >= 1 && dia < 32)
				return true;
		}
		return false;
	}
}
