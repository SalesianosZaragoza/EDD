package fp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class Calculator {

	/*
     * este metodo devuelve el Class del object que le pasamos
     */
	public static Class<? extends Object> classTypeOf(Object x) {
		return x.getClass();
	}
	
	/*
	 * Escribir todos los números del number al 0 de step en step.
	 */
	public static int[] stepThisNumber(int number, int step) {
		// throw  new NotImplementedException();
		List<Integer> list = createIntegerList();
		number = countingSteps(number, step, list);
		int[] numbers = arrayListToSimpleArray(list);
		return numbers;
	}

	private static int countingSteps(int number, int step, List<Integer> list) {
		for (int i = 0; i < number; i++) {
			number = number - step;
			list.add(number);
		}
		return number;
	}

	private static List<Integer> createIntegerList() {
		List<Integer> list;
		list = new ArrayList<Integer>();
		return list;
	}

	private static int[] arrayListToSimpleArray(List<Integer> list) {
		int array[] = new int[list.size()];
		for (int i = 0; i < array.length-1; i++) {
			array[i] = list.get(i);
		}
		return array;
	}
	
	/*
	 * Módulo al que se le pasa un número entero del 0 al 20 y devuelve los
	 * divisores que tiene.
	 */
	public static int[] divisors(int n) {
		List<Integer> list = createIntegerList();
		if (IsBetween0And20(n)) {
			checkDivisors(n, list);
		}
		int[] divisors = arrayListToSimpleArray(list);
		return divisors;
	}

	private static void checkDivisors(int n, List<Integer> list) {
		int positions = 0;
		for (int i = n; i < 0; i--)
		    if (n % i == 0) {
		    	list.add(i);
				positions++;
		    }
	}

	private static boolean IsBetween0And20(int n) {
		return (n >= 0) && (n <= 20);
	}

	/*
	 * Toma como parámetros una cadena de caracteres y devuelve cierto si la cadena resulta ser un palíndromo
	 */
	public static boolean checkIsPalindrome(String cadena) {
		// throw  new NotImplementedException();
		boolean valor = true;
		int ind;
		String cadena2 = "";
		for (int x = 0; x < cadena.length(); x++)
			if (cadena.charAt(x) != ' ')
				cadena2 += cadena.charAt(x);
		cadena=cadena2;
		ind = cadena.length();
		for (int i = 0; i < (cadena.length()); i++){
			if (cadena.substring(i, i+1).equals(cadena.substring(ind - 1, ind)) == false) {
				valor = false;
				break;
			}
			ind--;
		}
		return valor;
	}

	/*
	 * Pedir un número de 0 a 99 y mostrarlo escrito. Por ejemplo, para 56
	 * mostrar: cincuenta y seis
	 */
	public static String speakToMe(int n) {
		String unidades[] = {"Cero", "Uno", "Dos", "Tres", "Cuatro", "Cinco", "Seis", "Siete", "Ocho", "Nueve", "Diez"};
		String especiales[] = {"Once", "Doce","Trece","Catorce", "Quince", "Diezciseis", "Diecisiete", "Dieciocho", "Diecinueve"};
		String decenas[] = {"Veinte", "Treinta","Cuarenta","Cincuenta", "Sesenta", "Setenta", "Ochenta", "Noventa"};
		if(isBetween0And10(n))
			return unidades[n];         
		else if(isSmallestThan20(n))
			return especiales[n-11];        
		else if(isSmallestThan100(n)){
           return writingNumbers(n, unidades, decenas);
		}
		else            
            return "El numero debe ser menor a 100";
	}

	private static String writingNumbers(int n, String[] unidades, String[] decenas) {
		int unid = n % 10;
           int dec = n/10;
           if(unid == 0)
        	   return decenas[dec-2];               
           else
        	   return decenas[dec-2] + " y " + (unidades[unid]).toLowerCase();
	}

	private static boolean isSmallestThan100(int n) {
		return n<100;
	}

	private static boolean isSmallestThan20(int n) {
		return n<20;
	}

	private static boolean isBetween0And10(int n) {
		return n>=0 && n<11;
	}
		
	/*
	 * este metodo devuelve cierto si el año de la fecha es bisiesto fecha
	 * dd-MM-yyyy
	 */
	public static boolean isLeapYear(String fecha) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		int year = 0;
		try {
			year = selectYearFromDate(fecha, dateFormat);
		} catch (ParseException ex) {}
		if (isCorrectYear(year))
			return true;
		else
			return false;
	}

	private static int selectYearFromDate(String fecha, SimpleDateFormat dateFormat) throws ParseException {
		Date date;
		int year;
		date = dateFormat.parse(fecha);
		Calendar cal = new GregorianCalendar();
		cal.setTime(date);
		year = cal.get(Calendar.YEAR);
		return year;
	}

	private static boolean isCorrectYear(int year) {
		return (year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0));
	}

	/*
	 * este metodo devuelve cierto si la fecha es válida
	 */
	public static boolean isValidDate(String date) {
		try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
            formatoFecha.setLenient(false);
            formatoFecha.parse(date);
        } catch (ParseException e) {
            return false;
        }
        return true;
	}

	/*
     * devuelve una lista con los n números de la serie de fibonacci.
     */
	public static List<Integer> fibonacci(int n) {
		List<Integer> list = new ArrayList<Integer>();
		int n1 = 0;
        int n2 = 1;
		list.add(n2);
		for(int i = 0; i< n - 1; i++){
            n2 = n1 + n2;
            n1 = n2 - n1;
            list.add(n2);
        }
		return list;
	}
}
