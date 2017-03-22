package fp;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.awt.Button;
import java.util.ArrayList;
import java.util.List;

import org.hamcrest.core.IsNull;

public class Calculator {

	public static void main(String[] args)
	{
		int[] vector = stepThisNumber(12, 3);
//		int[] vector = divisors(20);
		for (int i = 0; i < vector.length; i++) System.out.printf("%3d ", vector[i]);
//		System.out.println(checkIsPalindrome("tacocat"));
//		System.out.println(checkIsPalindrome("TácOcát"));
//		List<Integer> lista = fibonacci(10);
//		for (Integer numero : lista) System.out.println(numero);
		System.out.println(speakToMe(3));
	}
	
	public static Class classTypeOf(Object x)
	{
	return x.getClass();
	}
	
	public static List<Integer> fibonacci(int n)
	{
		List<Integer> fibonacci = new ArrayList<Integer>();
		for (int i = 0; i <= n; i++)
		{
			if (i == 0 || i == 1)
			{
				fibonacci.add(i);
			}
			else
			{
				fibonacci.add(fibonacci.get(i - 1) + fibonacci.get(i - 2));
			}
		}
	return fibonacci;
	}

	public static int[] stepThisNumber(int number, int step)
	{
		if (step <= 0) 
		{
			int[] result = {-1};
		    return result;
		}
		
		int[] result = new int[number / step - 1];
		int current = number;
		int counter = 0;
		while(current - step > 0)
		{
			result[counter++] = (current -= step);
		}
	return result;
	}
	
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

	public static String speakToMe(int n)
	{
		String answer = "";
		if (n < 0 || n > 99)
		{
		    throw new IllegalArgumentException("Only integers between 0 and 99 are allowed");
		} 
		else if (n == 0) // Aquí podrían harcodearse otros únicos, como once, doce...
		{
			answer = "Cero";
		return answer;
		}
		int leftNumber = n / 10;
		int rightNumber = n % 10;
		
		switch (leftNumber)
		{
			case 1:
				answer += "Diez";
				break;
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
		
		if (leftNumber != 0) answer += " y ";
		
		switch (rightNumber)
		{
			case 1:
				answer += "Uno";
				break;
			case 2:
				answer += "Dos";
				break;
			case 3:
				answer += "Tres";
				break;
			case 4:
				answer += "Cuatro";
				break;
			case 5:
				answer += "Cinco";
				break;
			case 6:
				answer += "Seis";
				break;
			case 7:
				answer += "Siete";
				break;
			case 8:
				answer += "Ocho";
				break;
			case 9:
				answer += "Nueve";
				break;
		}
		
	return answer;
	}
	
	public static boolean isLeapYear(String fecha)
	{
		// el año es bisiesto si es divisible por 4
		int year = Integer.parseInt(fecha.substring(fecha.length() - 5, fecha.length() - 1));
		if (isValidDate(fecha) && (int) year % 4 == 0) return true;
	return false;
	}

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
