package fp;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

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

	/*
	 * Escribir todos los números del number al 0 de step en step.
	 */
	public static int[] stepThisNumber(int number, int step) {
		// throw  new NotImplementedException();
		int numbers[] = {};
		for (int i = 0; i < number; i++) {
			number = number - step;
			numbers[i] = number;
		}
		return numbers;
	}

	/*
	 * Módulo al que se le pasa un número entero del 0 al 20 y devuelve los
	 * divisores que tiene.
	 */
	public static int[] divisors(int n) {
		// throw  new NotImplementedException();
		int divisors[] = {};
		if ((n >= 0) && (n <= 20)) {
			for (int i = n; i < 0; i--)
	            if (n % i == 0)
	            	divisors[i] = n;
		}
		return divisors;
	}

	/*
	 * Toma como parámetros una cadena de caracteres y devuelve cierto si la cadena resulta ser un palíndromo
	 */
	public static boolean checkIsPalindrome(String cadena) {
		// throw  new NotImplementedException();
		boolean valor=true;
		int i,ind;
		String cadena2="";
		for (int x=0; x < cadena.length(); x++)
			if (cadena.charAt(x) != ' ')
				cadena2 += cadena.charAt(x);
		cadena=cadena2;
		ind=cadena.length();
		for (i= 0 ;i < (cadena.length()); i++){
			if (cadena.substring(i, i+1).equals(cadena.substring(ind - 1, ind)) == false ) {
				valor=false;
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
		if(n>=0 && n<11)
			return unidades[n];         
		else if(n<20)
			return especiales[n-11];        
		else if(n<100){
           int unid = n % 10;
           int dec = n/10;
           if(unid == 0)
        	   return decenas[dec-2];               
           else
        	   return decenas[dec-2] + " y " + (unidades[unid]).toLowerCase();
		}
		else            
            return "El numero debe ser menor a 100";
	}

	/*
	 * este metodo devuelve cierto si el año de la fecha es bisiesto fecha
	 * dd-MM-yyyy
	 */
	public static boolean isLeapYear(String fecha) {
		throw  new NotImplementedException();
		//SimpleDateFormat.parse(fecha);
		SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd/MM/yyyy");
		Date dateFecha = null;
		try {

			fecha = formatoDeFecha.parse(fecha);

			} catch (ParseException ex) {

			ex.printStackTrace();

			}
		
		int anio;
		if ((anio % 4 == 0) && ((anio % 100 != 0) || (anio % 400 == 0)))
			return true;
		else
			return false;
	}

	/*
	 * este metodo devuelve cierto si la fecha es válida
	 */
	public static boolean isValidDate(String date) {
		// throw  new NotImplementedException();
		try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            formatoFecha.setLenient(false);
            formatoFecha.parse(date);
        } catch (ParseException e) {
            return false;
        }
        return true;
	}
}
