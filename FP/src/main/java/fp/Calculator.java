package fp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Calculator {

	/*
	 * devuelve el Class del object que le pasamos
	 */
	public static Class classTypeOf(Object x) {
		return extracted(x);
	}

	private static Class extracted(Object x) {
		if (x instanceof String) {
			return String.class;
		} else if (x instanceof Integer) {
			return Integer.class;
		} else if (x instanceof Double) {
			return Double.class;
		} else if (x instanceof Float) {
			return Float.class;
		} else {
			return null;
		}
	}

	/*
	 * devuelve una lista con los números de fibonacci.
	 */

	public static List<Integer> fibonacci(int n) {
		int ListOfFibonacci[] = start(n);
		List<Integer> list = new ArrayList();
		for (int i = 0; i < n; i++) {
			list.add(new Integer(ListOfFibonacci[i]));
		}
		return list;
	}

	private static int[] start(int n) {
		int Number, num1, num2;

		do {
			Number = n;
		} while (Number <= 1);

		num1 = 1;
		num2 = 1;

		int FibonacciList[] = new int[n];
		System.out.print(num1 + " x ");
		FibonacciList[0] = num1;
		FibonacciList[1] = num2;

		for (int i = 2; i <= Number; i++) {
			FibonacciList[i - 1] = num2;
			num2 = num1 + num2;
			num1 = num2 - num1;
		}
		return FibonacciList;
	}

	/*
	 * Escribe todps los numeros de number a 0 con saltos de step
	 */
	public static int[] stepThisNumber(int number, int step) {
		int array[];

		int count = 0;
		int saved = 0;
		saved = number - step;

		while (saved >= 1) {
			saved = saved - step;
			count++;
		}

		array = new int[count];

		int first = number - step;

		int position = 0;
		while (first >= 1) {
			array[position] = first;
			first = first - step;
			if (first == 1) {
				array[++position] = first;
				break;
			}
			position++;
		}

		return array;
	}

	/*
	 * Módulo al que se le pasa un número entero del 0 al 20 y devuelve los
	 * divisores que tiene.
	 */

	public static int[] divisors(int num) {

		int number = num;
		int length;
		ArrayList arrayList = new ArrayList();
		int divisible[];
		int divisible2[];

		knowIfItIsDivisor(number, arrayList);

		int tamayo = arrayList.size();
		divisible = new int[tamayo + 1];
		divisible2 = new int[tamayo + 1];

		putDivisorsInAnArray(number, arrayList, divisible, tamayo);

		TurnAroundTheArrayList(arrayList, divisible, divisible2);

		return divisible2;

	}

	private static void knowIfItIsDivisor(int number, ArrayList arrayList) {
		for (int i = 1; i < number; i++) {
			if (number % i == 0) {
				arrayList.add(new Integer(i));
			}

		}
	}

	private static void putDivisorsInAnArray(int number, ArrayList arrayList, int[] divisible, int size) {

		for (int i = 0; i <= size; i++) {
			if (i == size) {
				divisible[i] = number;
			} else {
				divisible[i] = Integer.parseInt(String.valueOf(arrayList.get(i)));
			}

		}

	}

	private static void TurnAroundTheArrayList(ArrayList arrayList, int[] divisible, int[] divisible2) {

		for (int i = 0; i <= arrayList.size(); i++) {

			divisible2[i] = divisible[arrayList.size() - i];
		}

	}

	/*
	 * Toma como parámetros una cadena de caracteres y devuelve cierto si la cadena
	 * resulta ser un palíndromo
	 */
	public static boolean checkIsPalindrome(String chain) {
		return extracted3(chain);

	}

	private static boolean extracted3(String chain) {
		// throw new NotImplementedException();
		if (null == chain)
			return false;

		chain = chain.toLowerCase();
		chain = chain.trim();
		chain = chain.replace(" ", "");
		chain = chain.replace(",", "");
		chain = chain.replace(".", "");
		chain = chain.replace("?", "");
		chain = chain.replace("¿", "");
		chain = chain.replace(":", "");
		chain = chain.replace("è", "");
		chain = chain.replace("·", "");
		chain = chain.replace("á", "a");
		chain = chain.replace("é", "e");
		chain = chain.replace("í", "i");
		chain = chain.replace("ó", "o");
		chain = chain.replace("ú", "u");

		String reverse = new StringBuilder(chain).reverse().toString();
		return reverse.equals(chain);
	}

	/*
	 * Se pide un número entre 0 y 99 y se muestra escrito.
	 */

	public static String speakToMe(int n) {

		String numberInWords = "";
		int unidad;
		int ten;
		String between10and19 = "";
		String between20and90 = "";
		String unity = "";

		ten = n / 10;
		unidad = n % 10;

		unity = knowUnity(unidad, unity);

		between10and19 = ifnIsBetween10and19(unidad, ten, between10and19);

		between20and90 = ifnIsBetween20and90(ten, between10and19);

		numberInWords = establish_nInWords(n, numberInWords, unidad, between10and19, between20and90, unity);

		return numberInWords;

	}

	private static String establish_nInWords(int number, String numberInWords, int unidad, String between10and19,
			String between20and90, String unity) {
		if (number == 0) {
			unity = "Cero";
			numberInWords = unity;

		} else if (number < 10) {
			numberInWords = unity;

		} else if (number < 20) {
			if (unidad == 0)
				numberInWords = between10and19;
			else
				numberInWords = between10and19.concat(" y " + unity);

		} else if (number < 100) {
			if (unidad == 0)
				numberInWords = between20and90;
			else
				numberInWords = between20and90.concat(" y " + unity);
		}
		return numberInWords;
	}

	private static String ifnIsBetween20and90(int ten, String between10and19) {
		String between20and90 = "";
		if (ten == 2)
			between20and90 = "Veinte";
		else if (ten == 3)
			between20and90 = "Treinta";
		else if (ten == 4)
			between20and90 = "Cuarenta";
		else if (ten == 5)
			between20and90 = "Cincuenta";
		else if (ten == 6)
			between20and90 = "Sesenta";
		else if (ten == 7)
			between20and90 = "Setenta";
		else if (ten == 8)
			between20and90 = "Ochenta";
		else if (ten == 9)
			between20and90 = "Noventa";
		return between20and90;
	}

	private static String ifnIsBetween10and19(int unidad, int ten, String between10and19) {
		if (ten == 1 && unidad == 0)
			between10and19 = "Diez";
		else if (ten == 1 && unidad == 1)
			between10and19 = "Once";
		else if (ten == 1 && unidad == 2)
			between10and19 = "Doce";
		else if (ten == 1 && unidad == 3)
			between10and19 = "Trece";
		else if (ten == 1 && unidad == 4)
			between10and19 = "Catorce";
		else if (ten == 1 && unidad == 5)
			between10and19 = "Quince";
		else if (ten == 1 && unidad == 6)
			between10and19 = "Dieciseis";
		else if (ten == 1 && unidad == 7)
			between10and19 = "Diecisiete";
		else if (ten == 1 && unidad == 8)
			between10and19 = "Dieciocho";
		else if (ten == 1 && unidad == 9)
			between10and19 = "Diecinueve";

		return between10and19;
	}

	private static String knowUnity(int unidad, String unity) {

		if (unidad == 1)
			unity = "uno";
		else if (unidad == 2)
			unity = "dos";
		else if (unidad == 3)
			unity = "tres";
		else if (unidad == 4)
			unity = "cuatro";
		else if (unidad == 5)
			unity = "cinco";
		else if (unidad == 6)
			unity = "seis";
		else if (unidad == 7)
			unity = "siete";
		else if (unidad == 8)
			unity = "ocho";
		else if (unidad == 9)
			unity = "nueve";
		return unity;
	}

	/*
	 * devuelve cierto si el año de la fecha es bisiesto
	 * 
	 */

	public static boolean isLeapYear(String fecha) {

		String cutDate = fecha.substring((fecha.length() - 4), fecha.length());
		if (cutDate == null) {
			return false;
		}
		int fechaPasadaInt = Integer.parseInt(cutDate);
		if ((fechaPasadaInt % 4 == 0) && (fechaPasadaInt <= 2000)) {
			return true;

		} else if (fechaPasadaInt == 2100) {
			return false;
		} else {
			return false;
		}

	}

	/*
	 * devuelve cierto si la fecha es correcta
	 */
	public static boolean isValidDate(String date) {
		return extracted5(date);

	}

	private static boolean extracted5(String date) {
		// throw new NotImplementedException();
		try {
			SimpleDateFormat formatDate = new SimpleDateFormat("dd-MM-yyyy");
			formatDate.setLenient(false);
			formatDate.parse(date);
		} catch (ParseException e) {
			return false;
		}
		return true;
	}
}
