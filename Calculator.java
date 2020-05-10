package fp;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

	/*
	 * este metodo devuelve el Class del object que le pasamos
	 */
	public static Class classTypeOf(Object x) {
		return x.getClass();//////////////// .getname()
	}

	/*
	 * devuelve una lista con los n nÃºmeros de la serie de fibonacci.
	 */
	public static List<Integer> fibonacci(int n) {
		List<Integer> fibonacciList = new ArrayList<Integer>();
		fibonacciList.add(1);
		fibonacciList.add(1);
		for (int i = 2; i < n; i++) {
			fibonacciList.add(fibonacciList.get(i - 2) + fibonacciList.get(i - 1));
		}
		return fibonacciList;
	}

	/*
	 * Escribir todos los nÃºmeros del number al 0 de step en step.
	 */
	public static int[] stepThisNumber(int number, int step) {
		List<Integer> numberList = new ArrayList<>();
		while ((number - step) > 0) {
			number -= step;
			numberList.add(number);
		}
		int numberArray[] = new int[numberList.size()];
		for (int i = 0; i < numberArray.length; i++) {
			numberArray[i] = numberList.get(i);
		}
		return numberArray;
	}

	/*
	 * MÃ³dulo al que se le pasa un nÃºmero entero del 0 al 20 y devuelve los
	 * divisores que tiene.
	 */
	public static int[] divisors(int n) {
		if (n == 0) {
			return null;
		}
		List<Integer> divisoresList = new ArrayList<>();
		for (int i = n; i > 0; i--) {
			if ((n % i) == 0) {
				divisoresList.add(i);
			}
		}

		int arrayDivisores[] = new int[divisoresList.size()];

		for (int i = 0; i < divisoresList.size(); i++) {
			arrayDivisores[i] = divisoresList.get(i);
		}
		return arrayDivisores;

	}

	/*
	 * Toma como parÃ¡metros una cadena de caracteres y devuelve cierto si la cadena
	 * resulta ser un palÃ­ndromo
	 */
	public static boolean checkIsPalindrome(String cadena) {
		boolean palindromo = true;
		if (cadena == null) {
			return false;
		}
		cadena = cadena.toLowerCase();
		String cadena2 = limpiaCadena(cadena);
		cadena2 = cambiaVocales(cadena2);
		for (int i = 0, j = cadena2.length() - 1; i <= j; i++, j--) {
			if (cadena2.charAt(i) != cadena2.charAt(j)) {
				palindromo = false;
				break;
			}
		}
		return palindromo;
	}

	public static String limpiaCadena(String cadena) {
		String cadena2 = "";
		for (int i = 0; i < cadena.length(); i++) {
			if ((cadena.charAt(i) != ' ') && (cadena.charAt(i) != ',') && (cadena.charAt(i) != '.')
					&& (cadena.charAt(i) != '?') && (cadena.charAt(i) != '¿') && (cadena.charAt(i) != '·')
					&& (cadena.charAt(i) != ':')) {
				cadena2 += cadena.charAt(i);
			}
		}
		return cadena2;
	}

	public static String cambiaVocales(String frase) {
		char acentuadas[] = { 'á', 'é', 'í', 'ó', 'ú' };
		char normales[] = { 'a', 'e', 'i', 'o', 'u' };
		for (int i = 0; i < frase.length(); i++) {
			for (int j = 0; j < acentuadas.length; j++) {
				if (frase.charAt(i) == acentuadas[j]) {
					frase = frase.substring(0, i) + normales[j] + frase.substring(i + 1);
					break;
				}
			}
		}

		return frase;
	}

	/*
	 * Pedir un nÃºmero de 0 a 99 y mostrarlo escrito. Por ejemplo, para 56 mostrar:
	 * cincuenta y seis
	 */
	public static String speakToMe(int n) {
		String unidades[] = { "Cero", "uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve" };
		String decenas[] = { "Diez", "Veinte", "Treinta", "Cuarenta", "Cincuenta", "Sesenta", "Setenta", "Ochenta",
				"Noventa" };
		String combinados[] = { "Dieci", "Veinti", "Treinta y ", "Cuarenta y ", "Cincuenta y ", "Sesenta y ",
				"Setenta y ", "Ochenta y ", "Noventa y " };
		String especiales[] = { "Once", "Doce", "Trece", "Catorce", "Quince" };
		if (n < 10) {
			return unidades[n];
		} else if (n % 10 == 0) {
			return decenas[(n / 10) - 1];
		} else {
			if (n >= 11 && n <= 15) {
				return especiales[(n % 10) - 1];
			} else {
				return (combinados[(n / 10) - 1] + unidades[n % 10]);
			}
		}

	}

	/*
	 * este metodo devuelve cierto si el aÃ±o de la fecha es bisiesto fecha
	 * dd-MM-yyyy
	 */
	public static boolean isLeapYear(String fecha) {
		if (fecha == "") {
			return false;
		}
		int anyo = Integer.parseInt(fecha.substring(6));
		if (((anyo % 4 == 0) && (anyo % 100 != 0)) || (anyo % 400 == 0)) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * este metodo devuelve cierto si la fecha es vÃ¡lida
	 */
	public static boolean isValidDate(String date) {
		if (date == "") {
			return false;
		}
		String partesfecha[] = date.split("-");
		try {
		int dia = Integer.parseInt(partesfecha[0]);
		int mes = Integer.parseInt(partesfecha[1]);
		int anyo = Integer.parseInt(partesfecha[2]);
			
			if (anyo == 0 || mes == 0) {
			return false;
		}

		if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
			if ((dia > 0) && (dia <= 31)) {
				return true;
			}
		} else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
			if ((dia > 0) && (dia <= 30)) {
				return true;
			}
			} else if (mes == 2) {
			if ((isLeapYear(date)) && ((dia > 0) && (dia <= 29))) {
				return true;
			} else {
				if ((dia > 0) && (dia <= 30)) {
					return true;
				}
			}
		}
		return false;
		} catch (Exception e) {
			return false;
		}
	}
}
