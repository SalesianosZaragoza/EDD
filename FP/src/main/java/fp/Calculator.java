package fp;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

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
		List<Integer> numeros = new ArrayList<Integer>();
		Integer inicio = 0;
		Integer primer = 1;
		Integer acum;
		numeros.add(primer);
		for (int i = 0; i < n - 1; i++) {
			acum = inicio + primer;
			inicio = primer;
			primer = acum;
			numeros.add(acum);
		}
		return numeros;

	}

	/*
	 * Escribir todos los números del number al 0 de step en step.
	 */
	public static int[] stepThisNumber(int number, int step) {

		if (step == 0) {
			int result[] = { 0 };
			return result;

		} else {
			int result[];
			if (number % step == 0) {
				result = new int[(number / step) - 1];
			} else {
				result = new int[number / step];
			}
			int i = 0;
			while ((number - step) > 0) {
				number -= step;
				result[i] = number;
				i++;
			}

			return result;
		}

	}

	/*
	 * Módulo al que se le pasa un número entero del 0 al 20 y devuelve los
	 * divisores que tiene.
	 */
	public static int[] divisors(int n) {
		if (n == 0)
			return null;
		else {
			int divisores[] = new int[n];
			int j = 0;
			for (int i = n; i > 0; i--)
				if (n % i == 0) {
					divisores[j] = i;
					j++;
				}
			int result[] = new int[j];
			for (int x = 0; x < j; x++)
				result[x] = divisores[x];
			return result;
		}

	}

	/*
	 * Toma como parámetros una cadena de caracteres y devuelve cierto si la
	 * cadena resulta ser un palíndromo
	 */
	public static boolean checkIsPalindrome(String cadena) {
		throw new NotImplementedException();
	}

	/*
	 * Pedir un número de 0 a 99 y mostrarlo escrito. Por ejemplo, para 56
	 * mostrar: cincuenta y seis
	 */
	public static String speakToMe(int n) {
		String decenas, unidades, result;
		decenas = Ayuda.speakToMeDecenas(n);
		unidades = Ayuda.speakToMeUnidades(n);
		result = decenas + unidades;
		return result;
	}

	/*
	 * este metodo devuelve cierto si el año de la fecha es bisiesto fecha
	 * dd-MM-yyyy
	 */
	public static boolean isLeapYear(String fecha) {
		int año;
		if (fecha.isEmpty())
			return false;
		else {
			año = Integer.parseInt(fecha.substring(6, 10));

			if (año % 4 == 0) {
				if (año % 100 != 0)
					return true;
				else if (año % 400 == 0)
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
		if (date.length() != 10)
			return false;
		else {
			Integer dia, mes, año;
			dia = Integer.parseInt(date.substring(0, 2));
			mes = Integer.parseInt(date.substring(3, 5));
			año = Integer.parseInt(date.substring(6));

			if (año != null && mes <= 12 && mes > 0 && dia > 0 && año > 0) {
				if ((mes == 4 || mes == 6 || mes == 7 || mes == 9 || mes == 11) && dia <= 30) {
					return true;
				} else {
					if ((mes == 2 && isLeapYear(date) && dia <= 29) || (mes == 2 && !(isLeapYear(date)) && dia <= 28)) {
						return true;
					} else {
						if ((mes != 2) && dia <= 31)
							return true;
						else
							return false;
					}
				}
			} else
				return false;
		}

	}

	public static class Ayuda {
		public Ayuda() {

		}

		public static String speakToMeDecenas(int num) {
			if ((num / 10 > 0.9) && (num % 10 != 0)) {
				switch (num / 10) {
				case 1:
					return "Dieci";
				case 2:
					return "Veinti ";
				case 3:
					return "Treinta y";
				case 4:
					return "Cuarenta y ";
				case 5:
					return "Cincuenta y ";
				case 6:
					return "Sesenta y ";
				case 7:
					return "Setenta y ";
				case 8:
					return "Ochenta y ";
				case 9:
					return "Noventa y ";
				default:
					return "";
				}
			}
			return "";

		}

		public static String speakToMeUnidades(int num) {
			switch (num) {
			case 0:
				return "Cero";
			case 10:
				return "Diez";
			case 11:
				return "Once";
			case 12:
				return "Doce";
			case 13:
				return "Trece";
			case 14:
				return "Catorce";
			case 15:
				return "Quince";
			case 20:
				return "Veinte";
			case 30:
				return "Treinta";
			case 40:
				return "Cuarenta";
			case 50:
				return "Cincuenta";
			case 60:
				return "Sesenta";
			case 70:
				return "Setenta";
			case 80:
				return "Ochenta";
			case 90:
				return "Noventa";
			default:
				switch (num % 10) {
				case 0:
					return "cero";
				case 1:
					return "uno";
				case 2:
					return "dos";
				case 3:
					return "tres";
				case 4:
					return "cuatro";
				case 5:
					return "cinco";
				case 6:
					return "seis";
				case 7:
					return "siete";
				case 8:
					return "ocho";
				case 9:
					return "nueve";
				default:
					return "";

				}

			}
		}
	}
}
