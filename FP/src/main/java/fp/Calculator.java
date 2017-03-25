package fp;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.awt.Button;
import java.security.DigestInputStream;
import java.util.ArrayList;
import java.util.List;

import org.hamcrest.core.IsNull;

public class Calculator {

	public static void main(String[] args)
	{
		int[] numeros = stepThisNumber(10, 3);
		for (int i = 0; i < numeros.length; i++) System.out.print(numeros[i]);
	}
	
	public static Class classTypeOf(Object x)
	{
	return x.getClass();
	}
	
	public static List<Integer> fibonacci(int n)
	{
		List<Integer> fibonacci = new ArrayList<Integer>();
		// fb(n) == 0 v n == 0
		// fb(n) == 1 v n == 1
		// fb(n) == fb(n-1) + fb(n-2) v n != [0,1]
		// n c E
		// A�ado esto a mano porque el test no contempla el caso de que i == 0 que exige la definici�n formal anterior
		fibonacci.add(1);
		fibonacci.add(1);
		for (int i = 2; i < n; i++)
		{
			fibonacci.add(fibonacci.get(i - 1) + fibonacci.get(i - 2));
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
		
		int[] result = new int[(number - step) / step];
		int current = number;
		int counter = 0;
		while(current - step >= step)
		{
			number -= step;
			result[++counter] = number;
			System.out.println(number);
		}
	return result;
	}
	
	public static int[] divisors(int n)
	{
		if (n <= 0 || n > 20)
		{
//		    throw new IllegalArgumentException("Only integers between 0 and 20 are allowed");
		    return null;
		}
		int[] divisorsWasteSpace = new int[n]; // como m�x, tendr� n divisores
		divisorsWasteSpace[0] = n; // un n�mero siempre es divisible por s� mismo;
		int counter = 1;
		int spacesWasted = 0; // A priori no puede saberse sencillamente el n�mero de divisores, por lo que habr� elementos in�tiles en el array
		for (int i = n - 1; i >= 1; i--)
		{
			if (n % i == 0) divisorsWasteSpace[counter++] = i;
			else spacesWasted++;
		}
		int[] divisors = new int[n - spacesWasted];
		for (int i = 0; i < divisors.length; i++) divisors[i] = divisorsWasteSpace[i];
	return divisors;
	}

//	public static boolean checkIsPalindrome(String cadena)
//	{
////		String real = makeStandard(cadena);
//		for (int i = 0; i < real.length(); i++)
//		{
//			if (real.charAt(i) != real.charAt(real.length() - i - 1)) return false;
//		}
//	return true;
//	}
//	
//	public static String makeStandard(String string) // minusculas sin acentos
//	{
////		char[] standard = ''; // los String son inmutables
//		char[] nonStandardChars = {'�', '�', '�', '�', '�'};
//		char[] standardChars = {'a', 'i', 'u', 'e', 'o'};
//		char[] removableChars = {' ', '.', ',', ':', '-'};
//		for (int i = 0; i < string.length(); i++)
//		{
//			for (int j = 0; j < nonStandardChars.length; j++)
//			{
//				if (string.toLowerCase().charAt(i) == nonStandardChars[j])
//				{
//					standard += standardChars[j];
//					break;
//				}
//				else if (string.charAt(i) == removableChars[j])
//				{
//					i++;
//					break;
//				}
//			}
//			if(standard.length() == i) standard += string.toLowerCase().charAt(i);
//		}
//	return standard;
//	}

	public static String speakToMe(int n)
	{
		String answer = "";
		if (n < 0 || n > 99)
		{
		    throw new IllegalArgumentException("Only integers between 0 and 99 are allowed");
		}
		// Excepciones no algoritmizitables (asumiendo que 21 == Veinte y Uno y no Veintiuno)
		else switch(n)
		{
			case 0:
				answer += "Cero";
				return answer;
			case 10:
				answer += "Diez";
				return answer;
			case 11:
				answer += "Once";
				return answer;
			case 12:
				answer += "Doce";
				return answer;
			case 13:
				answer += "Trece";
				return answer;
			case 14:
				answer += "Catorce";
				return answer;
			case 15:
				answer += "Quince";
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
		
		if ( leftNumber != 0 && rightNumber != 0) answer += " y ";
		
		switch (rightNumber)
		{
			case 1:
				answer += "uno";
				break;
			case 2:
				answer += "dos";
				break;
			case 3:
				answer += "tres";
				break;
			case 4:
				answer += "cuatro";
				break;
			case 5:
				answer += "cinco";
				break;
			case 6:
				answer += "seis";
				break;
			case 7:
				answer += "siete";
				break;
			case 8:
				answer += "ocho";
				break;
			case 9:
				answer += "nueve";
				break;
		}
	return answer;
	}
	
	public static boolean isLeapYear(String fecha)
	{
		// el a�o es bisiesto si es divisible por 4 o 400, pero no por 100
		int year = Integer.parseInt(fecha.substring(6, 10));
		if ((year % 4 != 0 || year % 400 != 0) && year % 100 == 0) return false;
		else return isValidDate(fecha);
	}

	public static boolean isValidDate(String date)
	{
		// Una fecha no debe ser nula y debe estar en un formato XX-YY-ZZZZ
		if (date.length() != 10 || date == null) return false;
		if (date.charAt(2) != '-' || date.charAt(5) != '-') return false;
		
		// X, Y , Z deben ser numeros
		for (int i = 0; i < date.length(); i++)
		{
			if (date.charAt(i) != '-' && !Character.isDigit(date.charAt(i))) return false;
		}
		
		int mes = Integer.parseInt(date.substring(3, 5));
		int anyo = Integer.parseInt(date.substring(6, 10));
		int dia = Integer.parseInt(date.substring(0, 2));
		
		// ZZZZ > 0
		if (anyo == 0) return false;
		
		// 01 <= YY <= 12
		if (mes <= 0 || mes > 12) return false;
		
		// 01 <= XX <= 31 || 30 || 28 || 29, *seg�n el mes*
		if (dia <= 0) return false;
		switch (mes)
		{
			case 2:
				if (isLeapYear(date) && dia > 29) return false;
				else if (dia > 28) return false;
			break;
			case 4:
			case 6:
			case 9:
			case 11:
				{
				if (dia > 30) return false;
				break;
				}
			default:
				if (dia > 31) return false;
		}
	return true;
	}
}