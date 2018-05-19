package fp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
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
		
		List<Integer> secuenciaFibonacci = new ArrayList<Integer>(n);
		fibonacciLoop(n, secuenciaFibonacci);
		return secuenciaFibonacci;
	}


	private static void fibonacciLoop(int n, List<Integer> secuenciaFibonacci) {
		int a = 0;
		int b = 1;
		int sumAB = 0;
		for (int i = 0; i < n; i++) {
			sumAB = a + b;
			b = a;
			a = sumAB;
			secuenciaFibonacci.add(sumAB);
		}
	}

	/*
	 * Escribir todos los números del number al 0 de step en step.
	 */
	public static int[] stepThisNumber(int number, int step) {
		List<Integer> sequence = new ArrayList<Integer>();
		int operation = number-step;
	
		while(operation>0) {
			sequence.add(operation);
			operation -= step;
		}
		
		int stepSequence[] = new int[sequence.size()];
		for (int i = 0; i < stepSequence.length; i++) {
			stepSequence[i] = sequence.get(i);
		}
		
		return stepSequence;
		
	}



	private static void fillArray(List<Integer> sequence, int[] numbers) {
		for (int i = 0; i < sequence.size(); i++) {
			numbers[i] = sequence.get(i);
		}
	}
	
	

	/*
	 * Módulo al que se le pasa un número entero del 0 al 20 y devuelve los
	 * divisores que tiene.
	 */
	public static int[] divisors(int n) {
		List<Integer> divisors = new ArrayList<Integer>();
		int divisorsNumbers[] = null;
		int arrayPosition = 0;
		
		//Falla en el test de null, hay que poner el condicional para limitarlo en 0
		if(n > 0) {
		for (int i = n; i > 0; i--) {
			if(n % i == 0) {	
				divisors.add(i);
				arrayPosition++;
			}
		}
		divisorsNumbers = new int[arrayPosition];
		for (int i = 0; i < arrayPosition; i++) {
			divisorsNumbers[i] = divisors.get(i);
			}
		}
		
		return divisorsNumbers;
			
	}
	

	/*
	 * Toma como parámetros una cadena de caracteres y devuelve cierto si la cadena resulta ser un palíndromo
	 */
	public static boolean checkIsPalindrome(String cadena) {
		
		if(cadena == null) {
			return false;
		}
		cadena = replaceString(cadena);
		int charString = 0;
		int reversed = cadena.length() -1;
		boolean palindrome = true;
		
		while((charString < reversed) && palindrome) {
			if (cadena.charAt(charString)== cadena.charAt(reversed)) {
				charString++;
				reversed--;
			}else {
				palindrome = false;
			}
		}
		
		return palindrome;
		
	}


	private static String replaceString(String string) {
		string = string.replace(" ", "");
		string = string.replace(".", "");
		string = string.replace(",", "");
		string = string.replace("ª", "");
		string = string.replace("¿", "");
		string = string.replace("?", "");
		string = string.replace(":", "");
		string = string.replace("·", "");
		string = string.replace("ó", "o");
		string = string.replace("ú", "u");
		string = string.replace("á", "a");
		string = string.replace("í", "i");
		string = string.replace("è", "e");
		string = string.replace("é", "e");
		string = string.toLowerCase();
		
		return string;
	}
	

	/*
	 * Pedir un número de 0 a 99 y mostrarlo escrito. Por ejemplo, para 56
	 * mostrar: cincuenta y seis
	 */
	public static String speakToMe(int n) {
		String number="";
        String zero = "Cero";
        String units[] = {"uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve"};		
        String tens[] = {"Diez", "Veinte", "Treinta", "Cuarenta", "Cincuenta", "Sesenta", "Setenta", "Ochenta", "Noventa"};
			
        	if(n==0)
			    number+=zero;
        	
        	else if(n<10){
				   number+=units[n-1];
			} else if(n%10==0){
				   number+=tens[(n/10)-1];
			} else {
			    int unit=n%10;
			    int ten=n/10;
			    number=tens[ten-1]+" y "+units[unit-1];
			}
			return number;
	}

	/*
	 * este metodo devuelve cierto si el año de la fecha es bisiesto fecha
	 * dd-MM-yyyy
	 */
	public static boolean isLeapYear(String fecha) {
		int year;
		if(fecha.isEmpty()) {
			return false;
		
		}else {
			year = Integer.parseInt(fecha.substring(6));
			
			if(year % 4 == 0) {
				if(year % 100 != 0)
					return true;
				else if(year % 400 == 0)
					return true;
				else
					return false;
			}else {
				return false;
			}
			
		}
		
	}	
		
	

	/*
	 * este metodo devuelve cierto si la fecha es válida
	 */
	public static boolean isValidDate(String date) {
		
		if(date.length()!=10)
			return false;
		
		int year, month, day;
		year = Integer.parseInt(date.substring(6));
		month = Integer.parseInt(date.substring(3, 5));
		day = Integer.parseInt(date.substring(0, 2));
		
		
		
		if(month <= 12 && month > 0 && year > 0 && day > 0) {
			if((month == 4 || month == 6 || month == 9 || month == 11) && day <= 30) {
				return true;
			}else {
				if((month == 2 && day <= 28) || (month == 2 && (isLeapYear(date)) && day <= 29)) {
					return true;
				}else {
					if((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) && day <= 31 ) {
						return true;
					}else
						
						
						return false;
				}
			}
		}else
			return false;
		
	}
}
