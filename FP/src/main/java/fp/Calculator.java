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
		List<Integer> nums;
		nums = new ArrayList<Integer>();

		int f1 = 0;
		int f2 = 1;
		int f3 = 1;

		for (int i=0; i<n; i++) {
			nums.add(f3);
			f3 = f1 + f2;
			f1 = f2;
			f2 = f3;
		}

		return nums;
	}

	/*
	 * Escribir todos los números del number al 0 de step en step.
	 */
	public static int[] stepThisNumber(int number, int step) {
		int aux = number-step;

		List<Integer> numerosList;
		numerosList = new ArrayList<Integer>();
		while(aux > 0) {
			numerosList.add(aux);
			aux -= step;
		}

		int[] steps;
		steps = new int[numerosList.size()];

		for (int i=0; i<numerosList.size(); i++) {
			steps[i] = numerosList.get(i);
		}

		return steps;
	}

	/*
	 * Módulo al que se le pasa un número entero del 0 al 20 y devuelve los
	 * divisores que tiene.
	 */
	public static int[] divisors(int n) {
		if (n == 0)
			return null;
		else if (n == 1) {
			int v[] = {1};
			return v;
		}
			
		List<Integer> nums;
		nums = new ArrayList<Integer>();
		
		for (int e=n/2; e>0; e--)
			if (n%e == 0)
				nums.add(e);

		int[] divisores;
		divisores = new int [nums.size()+1];

		for (int i=0; i<nums.size(); i++) {
			divisores[i+1] = nums.get(i);
		}

		divisores[0] = n;

		return divisores; 
	}

	/*
	 * Toma como parámetros una cadena de caracteres y devuelve cierto si 
	 * la cadena resulta ser un palíndromo
	 */
	public static boolean checkIsPalindrome(String cadena) {
		if (cadena==null)
			return false;

		String letters2 = "aaaeeeiiiooouuunAAAEEEIIIOOOUUUNcC           ";
		String letters = "áàäéèëíìïóòöúùuñÁÀÄÉÈËÍÌÏÓÒÖÚÙÜÑçÇ:;-_,.?¿¡!·";
		String out = cadena.toLowerCase();
		String inver = "";
					
		for (int i = 0; i < letters.length(); i++) {
			out = out.replace(letters.charAt(i), letters2.charAt(i));
		}
	
		out = out.replace(" ", "");
		for (int i = out.length() - 1; i >= 0; i--)
			inver += out.charAt(i);
			if (out.equals(inver)) {
				return true;
			}else {
				return false;
		}
	}

	/*
	 * Pedir un número de 0 a 99 y mostrarlo escrito. Por ejemplo, para 56
	 * mostrar: cincuenta y seis
	 */
	public static String speakToMe(int n) {
		String cero = "Cero";
		String[] uds = {"uno","dos","tres","cuatro","cinco","seis","siete","ocho","nueve"};
		String[] decs = {"Diez","Veinte","Treinta","Cuarenta","Cincuenta","Sesenta","Setenta","Ochenta","Noventa"};
		String[] teens = {"Once","Doce","Trece","Catorce","Quince","Dieciseis","Diecisiete","Dieciocho","Diecinueve"};
		String num = "";

		if (n == 0) {
			num += cero;
		} else if (n>10 && n<20) {
			num += teens[n%10-1];
		} else if (n > 9 && n%10 == 0) {
			num += decs[n/10-1];
		} else if (n < 10) {
			num += uds[n-1];
		} else {
			num = decs[n/10-1] + " y " + uds[n%10-1];
		}

		return num;
	}

	/*
	 * este metodo devuelve cierto si el año de la fecha es bisiesto fecha
	 * dd-MM-yyyy
	 */
	public static boolean isLeapYear(String fecha) {
		if (fecha == "")
			return false;
		
		int anyo = Integer.parseInt(fecha.substring(6));

		return (anyo%4==0 && anyo%100!=0) || (anyo%400==0);
	}

	/*
	 * este metodo devuelve cierto si la fecha es válida
	 */
	public static boolean isValidDate(String date) {
		if (date.length() != 10)
			return false;

		int dia = Integer.parseInt(date.substring(0,2));
		int mes = Integer.parseInt(date.substring(3,5));
		int anyo = Integer.parseInt(date.substring(6));

		return (dia>=1 && dia<=31) && (mes>=1 && mes<=12) && (anyo>0);
	}
}
