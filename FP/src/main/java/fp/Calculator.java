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
		throw new NotImplementedException();
	}

	/*
	 * Módulo al que se le pasa un número entero del 0 al 20 y devuelve los
	 * divisores que tiene.
	 */
	public static int[] divisors(int n) {
		int[] divisores = null;
		if (n > 0) {
			int cantidadDivisores = 0;
			List<Integer> lista = new ArrayList<Integer>();
			for (int i = n; i > 0; i--)
				if (n % i == 0) {
					cantidadDivisores++;
					lista.add(i);
				}
			divisores = new int[cantidadDivisores];
			for (int i = 0; i < cantidadDivisores; i++)
				divisores[i] = lista.get(i);
		}
		return divisores;
	}

	/*
	 * Toma como parámetros una cadena de caracteres y devuelve cierto si la cadena
	 * resulta ser un palíndromo
	 */
	public static boolean checkIsPalindrome(String cadena) {
		String caracteresASustituir[] = { "[àá]", "[éè]", "[íï]", "[óò]", "[úü]" };
		String caracteresSustitutos[] = { "a", "e", "i", "o", "u" };
		if (cadena == null)
			return false;
		else {
			for (int i = 0; i < caracteresSustitutos.length; i++)
				cadena = cadena.replaceAll(caracteresASustituir[i], caracteresSustitutos[i]);
			cadena = cadena.toLowerCase().replaceAll("\\W", "");
			int numeroCaracteres = cadena.length();
			for (int i = 0; i < (numeroCaracteres / 2); i++) {
				if (cadena.charAt(i) != cadena.charAt(numeroCaracteres - i - 1)) {
					return false;
				}
			}
			return true;
		}
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
		String cadena = "";
		int unidad = n % 10;
		int decena = (n / 10) % 10;
		switch (decena) {
		case 0:
			cadena += unidades[unidad];
			break;
		case 1:
			cadena += diezAVeinte[unidad];
			break;
		default:
			if (unidad == 0)
				cadena += decenas[decena - 2];
			else
				cadena += decenas[decena - 2] + " y " + unidades[unidad];
			break;
		}
		cadena = cadena.substring(0, 1).toUpperCase() + cadena.substring(1);
		return cadena;
	}

	/*
	 * este metodo devuelve cierto si el año de la fecha es bisiesto fecha
	 * dd-MM-yyyy
	 */
	public static boolean isLeapYear(String fecha) {
		if (fecha != "" && fecha != null) {
			String anyo = fecha.substring(fecha.length() - 4);
			int anyoInt = Integer.parseInt(anyo);
			boolean bisiesto = anyoInt % 4 == 0 && anyoInt % 100 != 0 || anyoInt % 400 == 0;
			if (bisiesto)
				return true;
		}
		return false;
	}

	/*
	 * este metodo devuelve cierto si la fecha es válida
	 */
	public static boolean isValidDate(String date) {
		String anyo, mes, dia;
		int anyoInt, mesInt, diaInt;
		String patron = "\\d{2}" + "-" + "\\d{2}" + "-" + "\\d{4}";
		if (date.matches(patron)) {
			anyo = date.substring(date.length() - 4);
			mes = date.substring(3, 5);
			dia = date.substring(0, 2);
			anyoInt = Integer.parseInt(anyo);
			mesInt = Integer.parseInt(mes);
			diaInt = Integer.parseInt(dia);
			if (anyoInt >= 1 && mesInt >= 1 && mesInt < 13 && diaInt >= 1 && diaInt < 32)
				return true;
		}
		return false;
	}
}
