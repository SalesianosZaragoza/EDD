package fp;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.awt.Button;
import java.util.List;

import org.hamcrest.core.IsNull;

public class Calculator {

	public static void main(String[] args)
	{
//		int[] vector = stepThisNumber(1600, 6);
//		int[] vector = divisors(20);
//		for (int i = 0; i < vector.length; i++) System.out.printf("%3d ", vector[i]);
//		System.out.println(checkIsPalindrome("tacocat"));
//		System.out.println(checkIsPalindrome("TácOcát"));
	}
	
	/*
     * este metodo devuelve el Class del object que le pasamos
     */
	// DONE
	public static Class classTypeOf(Object x) {
	
	return x.getClass();
	}

	/*
     * devuelve una lista con los n nÃºmeros de la serie de fibonacci.
     */
	public static List<Integer> fibonacci(int n) {
		throw  new NotImplementedException();
	}

	/*
	 * Escribir todos los nÃºmeros del number al 0 de step en step.
	 */
	// DONE
	public static int[] stepThisNumber(int number, int step)
	{
//		if (step <= 0) 
//		{
//		    throw new IllegalArgumentException("That's not a wise step choice, Chief...");
//		}
		int[] result = new int[number / step + 1];
		int current = number;
		int counter = 0;
		while(current - step >= 0)
		{
			current = number - step * counter;
			result[counter++] = current;
		}
	return result;
	}

	/*
	 * MÃ³dulo al que se le pasa un nÃºmero entero del 0 al 20 y devuelve los
	 * divisores que tiene.
	 */
	// DONE
	public static int[] divisors(int n)
	{
		if (n < 0 || n > 20)
		{
		    throw new IllegalArgumentException("Only integers between 0 and 20 are allowed");
		}
		int[] divisorsWasteSpace = new int[9]; // como máx, tendrá 9 divisores
		int counter = 0;
		int spacesWasted = 0; // A priori no puede saberse sencillamente el número de divisores, por lo que habrá elementos inútiles en el array
		for (int i = 1; i <= 9; i++)
		{
			if (n % i == 0) divisorsWasteSpace[counter++] = i;
			else spacesWasted++;
		}
		int[] divisors = new int[9 - spacesWasted];
		for (int i = 0; i < 9 - spacesWasted; i++) divisors[i] = divisorsWasteSpace[i];
	return divisors;
	}

	/*
	 * Toma como parÃ¡metros una cadena de caracteres y devuelve cierto si la cadena resulta ser un palÃ­ndromo
	 */
	// DONE
	public static boolean checkIsPalindrome(String cadena)
	{
		String real = makeStandard(cadena);
		for (int i = 0; i < real.length(); i++)
		{
			if (real.charAt(i) != real.charAt(real.length() - i - 1)) return false;
		}
	return true;
	}
	
	public static String makeStandard(String string) // minusculas sin acentos
	{
		String standard = ""; // los String son inmutables
		char[] nonStandardChars = {'á', 'í', 'ú', 'é', 'ó'};
		char[] standardChars = {'a', 'i', 'u', 'e', 'o'};
		for (int i = 0; i < string.length(); i++)
		{
			for (int j = 0; j < nonStandardChars.length; j++)
			{
				if (string.toLowerCase().charAt(i) == nonStandardChars[j])
				{
					standard += standardChars[j];
					break;
				}
			}
			if(standard.length() == i) standard += string.toLowerCase().charAt(i);
		}
	return standard;
	}

	/*
	 * Pedir un nÃºmero de 0 a 99 y mostrarlo escrito. Por ejemplo, para 56
	 * mostrar: cincuenta y seis
	 */
	public static String speakToMe(int n)
	{
		String answer = "";
		if (n < 0 || n > 99)
		{
		    throw new IllegalArgumentException("Only integers between 0 and 99 are allowed");
		} 
		else if (n == 0)
		{
			answer = "Cero";
		return answer;
		}
		int leftNumber = n / 10;
		int rightNumber = n % 10;
		switch (leftNumber) {
		case 1:
			answer += "Diez";
		case 2:
			answer += "Veinte";
			break;
		case 3:
			answer += "Treinta";
			break;
		case 4:
			answer += "Cuarenta";
			break;
		case 5:
			answer += "Cincuenta";
			break;
		case 6:
			answer += "Sesenta";
			break;
		case 7:
			answer += "Setenta";
			break;
		case 8:
			answer += "Ochenta";
			break;
		case 9:
			answer += "Noventa";
			break;
		}
	return answer;
	}

	/*
	 * este metodo devuelve cierto si el aÃ±o de la fecha es bisiesto fecha
	 * dd-MM-yyyy
	 */
	//DONE
	public static boolean isLeapYear(String fecha)
	{
		// el año es bisiesto si es divisible por 4
		int year = Integer.parseInt(fecha.substring(fecha.length() - 5, fecha.length() - 1));
		if (isValidDate(fecha) && (int) year % 4 == 0) return true;
	return false;
	}

	/*
	 * este metodo devuelve cierto si la fecha es vÃ¡lida
	 */
	//DONE
	public static boolean isValidDate(String date)
	{
		if (date.length() != 10) return false;
		if (date.charAt(2) != '-' || date.charAt(5) != '-') return false;
		for (int i = 0; i < date.length(); i++)
		{
			if((i != 0 || i != 5) && !Character.isDigit(date.charAt(0))) return false;
		}
	return true;
	}
}
