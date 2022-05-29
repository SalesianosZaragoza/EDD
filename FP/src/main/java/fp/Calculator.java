package fp;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.NotImplementedException;
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
		List<Integer> fibonnaciList = new ArrayList<Integer>();
		Integer primerNum = 0, segundoNum = 1;
		fibonnaciList.add(1);

		for (int i = 0; i < n - 1; i++) {
			Integer suma = primerNum + segundoNum;
			primerNum = segundoNum;
			segundoNum = suma;
			fibonnaciList.add(suma);
		}

		return fibonnaciList;
	}

	/*
	 * Escribir todos los números del number al 0 de step en step.
	 */
	public static int[] stepThisNumber(int number, int step) {
		List<Integer> lista = new ArrayList<>();
		while (number - step > 0) {
			lista.add(number -= step);
		}
		return vectorFinal(lista);
	}

	public static int[] vectorFinal (List<Integer> list) {
		int[] vectorEnteros = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			vectorEnteros[i] = list.get(i);
		}
		return vectorEnteros;
	}

	/*
	 * Módulo al que se le pasa un número entero del 0 al 20 y devuelve los
	 * divisores que tiene.
	 */
	public static int[] divisors(int n) {
		if (n == 0) {
			return null;
		}
		int numVector = 0;
		for (int i = 1; i <= n; i++)
			if (n % i == 0)
				numVector++;
		int[] divisor = new int[numVector];
		for (int i = n, j = 0; i > 0; i--)
			if (n % i == 0) {
				divisor[j] = i;
				j++;
			}
		return divisor;
	}

	/*
	 * Toma como parámetros una cadena de caracteres y devuelve cierto si la cadena resulta ser un palíndromo
	 */
	public static boolean checkIsPalindrome(String cadena) {
		if (cadena == null) {
			return false;
		} else {
			cadena = cadena.toLowerCase();
			cadena = cadena.replace("á", "a");
			cadena = cadena.replace("é", "e");
			cadena = cadena.replace("í", "i");
			cadena = cadena.replace("ó", "o");
			cadena = cadena.replace("ú", "u");
			cadena = cadena.replace("¿", "");
			cadena = cadena.replace("?", "");
			cadena = cadena.replace(":", "");
			cadena = cadena.replace("·", "");
			cadena = cadena.replace(",", "");
			cadena = cadena.replace(".", "");
			cadena = cadena.replace(" ", "");
			int fin = cadena.length() - 1;
			int ini = 0;
			boolean isPalindrome = true;
			while (ini < fin) {
				if (cadena.charAt(ini) != cadena.charAt(fin)) {
					isPalindrome = false;
				}
				ini++;
				fin--;
			}
			return isPalindrome;
		}
	}

	/*
	 * Pedir un número de 0 a 99 y mostrarlo escrito. Por ejemplo, para 56
	 * mostrar: cincuenta y seis
	 */
	public static String speakToMe(int n) {
		if (n == 0) 
			return "Cero";
		else {
			int numFinal;
			int unidades, decenas;
			String fraseFinal = "";
			numFinal = n;
			unidades = numFinal % 10;
			decenas = numFinal / 10;
			switch (decenas) {
				case 0:
					fraseFinal = "";
					break;
				case 1:
					fraseFinal = "Diez";
					break;
				case 2:
					fraseFinal = "Veinte";
					break;
				case 3:
					fraseFinal = "Treinta";
					break;
				case 4:
					fraseFinal = "Cuarenta";
					break;
				case 5:
					fraseFinal = "Cincuenta";
					break;
				case 6:
					fraseFinal = "Sesenta";
					break;
				case 7:
					fraseFinal = "Setenta";
					break;
				case 8:
					fraseFinal = "Ochenta";
					break;
				case 9:
					fraseFinal = "Noventa";
					break;
			}
			if ((n > 10) && unidades > 0) 
				fraseFinal = fraseFinal + " y "; 
			else 
				fraseFinal = fraseFinal + "";
			
			switch (unidades) {
				case 0:
					fraseFinal = fraseFinal + "";
					break;
				case 1:
					fraseFinal = fraseFinal + "uno";
					break;
				case 2:
					fraseFinal = fraseFinal + "dos";
					break;
				case 3:
					fraseFinal = fraseFinal + "tres";
					break;
				case 4:
					fraseFinal = fraseFinal + "cuatro";
					break;
				case 5:
					fraseFinal = fraseFinal + "cinco";
					break;
				case 6:
					fraseFinal = fraseFinal + "seis";
					break;
				case 7:
					fraseFinal = fraseFinal + "siete";
					break;
				case 8:
					fraseFinal = fraseFinal + "ocho";
					break;
				case 9:
					fraseFinal = fraseFinal + "nueve";
					break;
	
			}
			return fraseFinal;
		}
	}

	/*
	 * este metodo devuelve cierto si el año de la fecha es bisiesto fecha
	 * dd-MM-yyyy
	 */
	public static boolean isLeapYear(String fecha) {
		if ((fecha == "")||(fecha == null)) 
			return false;
		else {
			String añoString = fecha.substring(fecha.length() - 4);
			int añoInt = Integer.parseInt(añoString);
			if ((añoInt % 4 == 0) && ((añoInt % 100 != 0) || (añoInt % 400 == 0)))
				return true;
			else
				return false;
		}
	}

	/*
	 * este metodo devuelve cierto si la fecha es válida
	 */
	public static boolean isValidDate(String date) {
		throw new NotImplementedException("no implementado");
	}
}
