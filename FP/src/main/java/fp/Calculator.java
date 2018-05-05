package fp;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
		List<Integer> fibonacci = new ArrayList();
		int limite = n;
		int n1 = 0;
		int n2 = 1;
		int aux = 0;

		for (int i = 0; i < limite; i++) {
			aux = n1 + n2;
			n2 = n1;
			n1 = aux;
			fibonacci.add(aux);
		}
		return fibonacci;
	}

	/*
	 * Escribir todos los números del number al 0 de step en step.
	 */
	public static int[] stepThisNumber(int number, int step) {
		int[] numeros = new int[number];
		int pos = 0;
		if (step != 0) {
			for (int i = number - 1; i > 0; i -= step) {
				numeros[pos] = i;
				pos++;
			}
			for (int i = 0; i < numeros.length; i++) {
				System.out.println(numeros[i]);
			}
		}

		return numeros;

	}

	/*
	 * Módulo al que se le pasa un número entero del 0 al 20 y devuelve los
	 * divisores que tiene.
	 */
	public static int[] divisors(int n) {
		int numero = n;

		int[] divisors = new int[n];
		if (numero != 0) {

			for (int i = 1; i <= n; i++)
				for (int j = 0; j < divisors.length; j++) {
					if (n % i == 0)
						divisors[j] = i;
					System.out.println(i);
				}
		}
		return divisors;
	}

	/*
	 * Toma como parámetros una cadena de caracteres y devuelve cierto si la cadena
	 * resulta ser un palíndromo
	 */
	public static boolean checkIsPalindrome(String cadena) {
		String s = cadena;

		boolean espalin = true;
		if (s != null) {
			s = s.replace(" ", "");
			s = s.replace(",", "");
			s = s.replace(".", "");
			s = s.replace("?", "");
			s = s.replace("¿", "");
			s = s.replace(":", "");
			s = s.replace("á", "a");
			s = s.replace("é", "e");
			s = s.replace("è", "e");
			s = s.replace("·", "");
			s = s.replace("í", "i");
			s = s.replace("ó", "o");
			s = s.replace("ú", "u");
			s = s.toLowerCase();
			int fin = s.length() - 1;
			int ini = 0;

			while (ini < fin) {
				if (s.charAt(ini) != s.charAt(fin)) {
					espalin = false;
				}
				ini++;
				fin--;
			}
		}
		return espalin;

	}

	/*
	 * Pedir un número de 0 a 99 y mostrarlo escrito. Por ejemplo, para 56 mostrar:
	 * cincuenta y seis
	 */
	public static String speakToMe(int n) {
		String numeroescrito = "";
		String[] unidadesescritas = { "Cero", "uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve",
				"Diez", "Once", "Doce", "Trece", "Catorce", "Quince", "Diecesies", "Diecisiete", "Dicieocho",
				"Dicienueve" };
		String[] decenasescritas = { "Cero", "Diez", "Veinte", "Treinta", "Cuarenta", "Cincuenta", "Sesenta", "Setenta",
				"Ochenta", "Noventa" };
		if (n < 100) {
			if (n >= 20) {
				if ((n % 10) != 0) {
					numeroescrito += decenasescritas[(n / 10)];
					numeroescrito += " y " + unidadesescritas[(n % 10)];

				} else {
					numeroescrito += decenasescritas[(n / 10)];
				}
			} else {
				numeroescrito += unidadesescritas[n];
			}
		}

		return numeroescrito;
	}

	/*
	 * este metodo devuelve cierto si el año de la fecha es bisiesto fecha
	 * dd-MM-yyyy
	 */
	public static boolean isLeapYear(String fecha) {
		String f = fecha;
		boolean bisiesto = false;

		if (f != "") {
			String anio = f;
			anio = anio.substring(6);
			int a = Integer.parseInt(anio);
			if (a % 4 == 0 && a % 100 != 0 || a % 400 == 0) {
				bisiesto = true;
			} else {
				bisiesto = false;
			}
		}
		return bisiesto;
	}

	/*
	 * este metodo devuelve cierto si la fecha es válida
	 */
	public static boolean isValidDate(String date) {
		String fecha = date;
		boolean validate = false;
		if (fecha != "") {
			try {
				SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
				formatoFecha.parse(fecha);
				validate = true;
			} catch (ParseException e) {
				validate = false;
			}

		}

		return validate;
	}
}