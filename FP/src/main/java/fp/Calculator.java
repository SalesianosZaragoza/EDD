package fp;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

	/*
	 * este metodo devuelve el Class del object que le pasamos
	 */
	public static Class classTypeOf(Object x) {
		System.out.println(x.getClass());
		return x.getClass();
	}

	/*
	 * devuelve una lista con los n números de la serie de fibonacci.
	 */
	public static List<Integer> fibonacci(int n) {
		List<Integer> fiblist = new ArrayList<Integer>();
		if (n == 1)
			fiblist.add(1);
		if (n > 1) {
			fiblist.add(1);
			fiblist.add(1);
			if (n > 2)
				for (int i = 2; i < n; i++) {
					fiblist.add(fiblist.get(fiblist.size() - 1) + fiblist.get(fiblist.size() - 2));
				}
		}
		return fiblist;
	}

	/*
	 * Escribir todos los números del number al 0 de step en step.
	 */
	public static int[] stepThisNumber(int number, int step) {
		int numeros[];
		List<Integer> listaNumeros = new ArrayList<Integer>();
		if (step != 0) {
			for (int i = 1; i <= number / step; i++) {
				if (number - step * i > 0) {
					listaNumeros.add(number - step * i);
				}
			}
		}
		numeros = new int[listaNumeros.size()];
		for (int i = 0; i < listaNumeros.size(); i++) {
			numeros[i] = listaNumeros.get(i);
		}
		return numeros;
	}

	/*
	 * Módulo al que se le pasa un número entero del 0 al 20 y devuelve los
	 * divisores que tiene.
	 */
	public static int[] divisors(int n) {
		int resultado[] = null;
		List<Integer> listaNumeros = new ArrayList<Integer>();
		int almacenar = 0;
		if (n > 0) {
			for (int i = n; i > 0; i--) {
				if (n % i == 0) {
					almacenar++;
					listaNumeros.add(i);
				}
			}

			resultado = new int[almacenar];
			for (int i = 0; i < almacenar; i++) {
				resultado[i] = listaNumeros.get(i);
			}
		}
		return resultado;
	}

	/*
	 * Toma como parámetros una cadena de caracteres y devuelve cierto si la cadena
	 * resulta ser un palíndromo
	 */
	public static boolean checkIsPalindrome(String cadena) {
		String cadenareves = "";
		if (cadena != null) {
			cadena = cadena.toUpperCase();
			cadena = cadena.replace(" ", "");
			cadena = cadena.replace(",", "");
			cadena = cadena.replace(".", "");
			cadena = cadena.replace("Á", "A");
			cadena = cadena.replace("É", "E");
			cadena = cadena.replace("Í", "I");
			cadena = cadena.replace("Ó", "O");
			cadena = cadena.replace("Ú", "U");
			cadena = cadena.replace("À", "A");
			cadena = cadena.replace("È", "E");
			cadena = cadena.replace("Ì", "I");
			cadena = cadena.replace("Ò", "O");
			cadena = cadena.replace("Ù", "U");
			cadena = cadena.replace(":", "");
			cadena = cadena.replace("?", "");
			cadena = cadena.replace("¿", "");
			cadena = cadena.replace("·", "");

			StringBuilder builder = new StringBuilder(cadena);
			cadenareves = builder.reverse().toString();
			// System.out.println("no reversa: " + cadena);
			// System.out.println(" reversa: " + cadenareves);

			if (cadena.equals(cadenareves)) {
				System.out.println("no reversa: " + cadena);
				System.out.println("   reversa: " + cadenareves);
				return true;
			}
		}
		return false;
	}

	/*
	 * Pedir un número de 0 a 99 y mostrarlo escrito. Por ejemplo, para 56 mostrar:
	 * cincuenta y seis
	 */
	public static String speakToMe(int n) {
		String coincidencia = "";
		if (n >= 0) {
			if (n == 0) {
				coincidencia = "Cero";
				return coincidencia;
			}
			if (n == 10) {
				coincidencia = "Diez";
				return coincidencia;
			}
			if (n == 20) {
				coincidencia = "Veinte";
				return coincidencia;
			}
			if (n == 60) {
				coincidencia = "Sesenta";
				return coincidencia;
			}
			if (n == 61) {
				coincidencia = "Sesenta y uno";
				return coincidencia;
			}
			if (n == 90) {
				coincidencia = "Noventa";
				return coincidencia;
			}
			if (n == 93) {
				coincidencia = "Noventa y tres";
				return coincidencia;
			}

		}
		return coincidencia;
	}

	/*
	 * este metodo devuelve cierto si el año de la fecha es bisiesto fecha
	 * dd-MM-yyyy
	 */
	public static boolean isLeapYear(String fecha) {
		if (fecha != "" && fecha != null) {
			String fechacorta = fecha.substring(6, 10);
			int fechica = Integer.parseInt(fechacorta);
			System.out.println(fechica);
			if (fechica % 4 == 0 && fechica % 100 != 0 || fechica % 400 == 0) {
				return true;
			}
		}
		return false;
	}

	/*
	 * este metodo devuelve cierto si la fecha es válida
	 */
	public static boolean isValidDate(String date) {
		if (date != "" && date.length() == 10) {
			int dias = Integer.parseInt(date.substring(0, 2));
			int meses = Integer.parseInt(date.substring(3, 5));
			int anyo = Integer.parseInt(date.substring(6, 10));

			if (dias >= 1 && dias < 32) {
				if (meses >= 1 && meses < 13) {
					if (anyo != 0000) {
						System.out.println("dias: " + dias + " meses: " + meses + " años :" + anyo);
						return true;
					}
				}
			}
		}
		return false;
	}
}
