package fp;

import java.util.ArrayList;
import java.util.List;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;



public class Calculator {


	/*
     * este metodo devuelve el Class del object que le pasamos
     */
	public static Class classTypeOf(Object x) {
		//throw  new NotImplementedException();
		return x.getClass();
	}
	


	/*
     * devuelve una lista con los n números de la serie de fibonacci.
     */
	public static List<Integer> fibonacci(int n) {
		//throw new NotImplementedException();
		List <Integer> fibonacci = new ArrayList<Integer>();
		Integer n1 = 0, n2 = 1;
		fibonacci.add(1);

		for (int i = 0; i < n - 1; i++) {
			Integer summa = n1 + n2;
			n1 = n2;
			n2 = summa;
			fibonacci.add(summa);
		}

		return fibonacci;
	}

	/*
	 * Escribir todos los números del number al 0 de step en step.
	 */
	public static int[] stepThisNumber(int number, int step) {
		//throw  new NotImplementedException();
		List<Integer> lista = new ArrayList<>();
		while (number - step > 0){
			lista.add(number = number - step);
		}
		return Conversor(lista);
	}

	public static int[] Conversor(List<Integer> list) {
		int[] lista = new int[list.size()];
		for (int i=0; i< list.size(); i++){
			lista[i]= list.get(i);
		}
		return lista;
	}
	

	/*
	 * Módulo al que se le pasa un número entero del 0 al 20 y devuelve los
	 * divisores que tiene.
	 */
	public static int[] divisors(int n) {
		//throw  new NotImplementedException();
		List<Integer> divisores = new ArrayList<>();
		if (n == 0)
			return null;
		if (n >= 0 && n <= 20) {
			
			for (int i = 20; i > 0; i--) {
				if (n % i == 0) {
					divisores.add(i);
				}
			}

			return Conversor(divisores);
		}
		return new int[]{-1};
	}

	/*
	 * Toma como parámetros una cadena de caracteres y devuelve cierto si la cadena resulta ser un palíndromo
	 */
	public static boolean checkIsPalindrome(String cadena) {
		//throw  new NotImplementedException();
			cadena = cadena.toLowerCase().replace("á", "a").replace("é", "e").replace("í", "i").replace("ó", "o")
					.replace("ú", "u").replace(" ", "").replace(".", "").replace(",", "");
			
			String invertida = new StringBuilder(cadena).reverse().toString();

			return invertida.equals(cadena);
		}



	/*
	 * Pedir un número de 0 a 99 y mostrarlo escrito. Por ejemplo, para 56
	 * mostrar: cincuenta y seis
	 */
	public static String speakToMe(int n) {
		//throw  new NotImplementedException();
		int uni = n % 10;
		n = n / 10;
		String letras = uText(uni);
		int dec = n % 10;
		n = n / 10;

		if ((uni == 0) && (dec > 0)) {
			letras = dtext(dec);
		} else if (dec == 1) {
			letras = once_diecnueve(10 + uni);
		} else if (dec > 1) {
			letras = dtext(dec) + " y " + letras.toLowerCase();
		}
		return letras;
	}

	public static String uText (int num){
		switch (num){
			case 0:
				return "Cero";
			case 1:
				return "Uno";
			case 2:
				return "Dos";
			case 3:
				return "Tres";
			case 4:
				return "Cuatro";
			case 5:
				return "Cinco";
			case 6:
				return "Seis";
			case 7:
				return "Siete";
			case 8:
				return "Ocho";
			case 9:
				return "Nueve";
			default:
				return "";
		}
	}
	public static String dtext(int num) {
		switch (num) {
			case 1:
				return "Diez";
			case 2:
				return "Veinte";
			case 3:
				return "Treinta";
			case 4:
				return "Cuarenta";
			case 5:
				return "Cincuenta";
			case 6:
				return "Sesenta";
			case 7:
				return "Setenta";
			case 8:
				return "Ochenta";
			case 9:
				return "Noventa";
			default:
				return "";
		}
	}
	public static String once_diecnueve(int num){
		switch (num) {
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
			case 16:
				return "Dieciseis";
			case 17:
				return "Diecisiete";
			case 18:
				return "Dieciocho";
			case 19:
				return "Diecinueve";
			default:
				return "";
		}
	}

	/*
	 * este metodo devuelve cierto si el año de la fecha es bisiesto fecha
	 * dd-MM-yyyy
	 */
	public static boolean isLeapYear(String fecha) {
		//throw  new NotImplementedException();
		if (fecha == "")
			return false;
		DateTimeFormatter bisiesto = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		return LocalDate.parse(fecha, bisiesto).isLeapYear();
	}

	/*
	 * este metodo devuelve cierto si la fecha es válida 
	 */
	public static boolean isValidDate(String date) {
		//throw  new NotImplementedException();
		DateFormat valido = new SimpleDateFormat("dd-MM-yyyy");
		valido.setLenient(false);
		try {
			valido.parse(date);
		} catch (ParseException e) {
			return false;
		}
		return true;
	}
}