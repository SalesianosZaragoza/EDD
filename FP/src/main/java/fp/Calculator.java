package fp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Calculator {


	/*
     * este metodo devuelve el Class del object que le pasamos
     */
	public static Class classTypeOf(Object x) {
		Class prueba = x.getClass();
		return prueba;
	}


	/*
     * devuelve una lista con los n números de la serie de fibonacci.
     */
	public static List<Integer> fibonacci(int n) {
		List<Integer> a = new ArrayList<Integer>();
		int cont = 1;
		a.add(cont);

		for (int i = 1; i < n; i++){
			int anterior = a.get(i - 1);
			a.add(cont);
			cont = anterior + cont;
		}
		return a;
	}

	/*
	 * Escribir todos los números del number al 0 de step en step.
	 */
	public static int[] stepThisNumber(int number, int step) {
		int i = 0;
		int[] representacion = new int[number];
		if (number == 0){
			return representacion;
		}else {
			while (number > 0) {
				representacion[i + 1] = number - step;
			}
			return representacion;
		}
		}

	/*
	 * Módulo al que se le pasa un número entero del 0 al 20 y devuelve los
	 * divisores que tiene.
	 */
	public static int[] divisors(int n) {
		int auxiliar = 0;
		if(n==0) {
			return null;
		}
		for (int i = 1 ; i <= n ; i++)
			if (n % i == 0)
				auxiliar++;
		int []divisores = new int[auxiliar];
		for (int i = n, j = 0 ; i >0 ; i--)
			if (n % i == 0) {
				divisores[j] = i;
				j++;
			}
		return divisores;
	}

	/*
	 * Toma como parámetros una cadena de caracteres y devuelve cierto si la cadena resulta ser un palíndromo
	 */
	public static boolean checkIsPalindrome(String cadena) {
		if (cadena == null) {
			return false;
		}else {
			cadena = cadena.toLowerCase().replace("á", "a").replace("é", "e").replace("í", "i").replace("ó", "o")
					.replace("ú", "u").replace(" ", "").replace(".", "").replace(",", "").replace("?", "").replace("¿","")
					.replace(":", "").replace("·","");
			String invertir = new StringBuilder(cadena).reverse().toString();
			return invertir.equals(cadena);
		}
	}

	/*
	 * Pedir un número de 0 a 99 y mostrarlo escrito. Por ejemplo, para 56
	 * mostrar: cincuenta y seis
	 */
	public static String speakToMe(int n) {
		int valor;
		int unidades, decenas;
		String Num = "";
		valor = n;
		unidades = valor % 10;
		decenas = valor / 10;
		switch (decenas) {
			case 0:
				Num = "";
				break;
			case 1:
				Num = "Diez";
				break;
			case 2:
				Num = "Veinte";
				break;
			case 3:
				Num = "Treinta";
				break;
			case 4:
				Num = "Cuarenta";
				break;
			case 5:
				Num = "Cincuenta";
				break;
			case 6:
				Num = "Sesenta";
				break;
			case 7:
				Num = "Setenta";
				break;
			case 8:
				Num = "Ochenta";
				break;
			case 9:
				Num = "Noventa";
				break;
		}
		if ((n > 10)&&unidades>0) {
			Num = Num + " y ";
		} else {
			Num = Num + "";
		}
		switch (unidades) {
			case 0:
				Num = Num + "";
				break;
			case 1:
				Num = Num + "uno";
				break;
			case 2:
				Num = Num + "dos";
				break;
			case 3:
				Num = Num + "tres";
				break;
			case 4:
				Num = Num + "cuatro";
				break;
			case 5:
				Num = Num + "cinco";
				break;
			case 6:
				Num = Num + "seis";
				break;
			case 7:
				Num = Num + "siete";
				break;
			case 8:
				Num = Num + "ocho";
				break;
			case 9:
				Num = Num + "nueve";
				break;

		}
		if(n==0) {
			return "Cero";
		}else {
			return Num;
		}
	}

	/*
	 * este metodo devuelve cierto si el año de la fecha es bisiesto fecha
	 * dd-MM-yyyy
	 */
	public static boolean isLeapYear(String fecha) {
		if(fecha.equals("")) {
			return false;
		}
		String year = fecha.substring(fecha.length()-4);
		int ano = Integer.parseInt(year);
		if ((ano % 4 == 0) && ((ano % 100 != 0) || (ano % 400 == 0)))
			return true;
		else
			return false;
	}

	/*
	 * este metodo devuelve cierto si la fecha es válida
	 */
	public static boolean isValidDate(String date) {
		try {
			SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
			formato.setLenient(false);
			formato.parse(date);
		} catch (ParseException e) {
			return false;
		}
		return true;
	}
}
