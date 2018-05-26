package fp;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Calculator {

	/*
	 * este metodo devuelve el Class del object que le pasamos
	 */
	public static Class classTypeOf(Object x) {
		if (x instanceof String) {
			return String.class;
		}else if(x instanceof Integer) {
			return Integer.class;
		}else if(x instanceof Double) {
			return Double.class;
		}else if(x instanceof Float) {
			return Float.class;
		}else {
			return null;
		}
	}

	/*
	 * devuelve una lista con los n números de la serie de fibonacci.
	 */
	public static List<Integer> fibonacci(int n) {
		int ListOfFibonacciNumbers[] = start(n);
		List<Integer> list = new ArrayList();
		for (int i = 0; i < n; i++) {
			list.add(new Integer(ListOfFibonacciNumbers[i]));

		}
		return list;
	}

	private static int[] start(int n) {
		int StartNumber, number1, number2;
		
		do {
			StartNumber = n;
		} while (StartNumber <= 1);

		number1 = 1;
		number2 = 1;

		int FibonacciList[] = new int[n];
		System.out.print(number1 + " x ");
		FibonacciList[0] = number1;
		FibonacciList[1] = number2;
		
		for (int i = 2; i <= StartNumber; i++) {
			FibonacciList[i - 1] = number2;
			number2 = number1 + number2;
			number1 = number2 - number1;

		}
		return FibonacciList;
	}

	/*
	 * Escribir todos los números del number al 0 de step en step.
	 */
	public static int[] stepThisNumber(int number, int step) {
		int array[];

		int operacion;

		int count = 0;
		int guardado = 0;
		guardado = number - step;

		while (guardado >= 1) {
			guardado = guardado - step;
			count++;
		}
		System.out.println("numero de operaciones:::" + count);

		array = new int[count];

		int first = number - step;

		int pos = 0;
		while (first >= 1) {
			array[pos] = first;
			first = first - step;
			if (first == 1) {
				array[++pos] = first;
				System.out.println("F--> dentro del bucle " + first);
				break;
			}
			System.out.println("F-->" + first);
			pos++;

		}

		for (int i = 0; i <= array.length - 1; i++) {
			System.out.println(array[i]);
		}
		System.out.println("salgo");

		return array;
	}

	/*
	 * Módulo al que se le pasa un número entero del 0 al 20 y devuelve los
	 * divisores que tiene.
	 */

	public static int[] divisors(int num) {

		int numero = num;
		int logitud;
		ArrayList al = new ArrayList();
		int divisibles[];
		int divisibles2[];

		knowIfItIsDivisor(numero, al);

		int tamayo = al.size();
		divisibles = new int[tamayo + 1];
		divisibles2 = new int[tamayo + 1];

		putDivisorsInAnArray(numero, al, divisibles, tamayo);

		TurnAroundTheArrayList(al, divisibles, divisibles2);

		return divisibles2;

	}

	private static void knowIfItIsDivisor(int numero, ArrayList al) {
		for (int i = 1; i < numero; i++) {
			if (numero % i == 0) {
				al.add(new Integer(i));
			}

		}
	}

	private static void putDivisorsInAnArray(int numero, ArrayList al, int[] divisibles, int tamayo) {

		for (int i = 0; i <= tamayo; i++) {
			if (i == tamayo) {
				divisibles[i] = numero;
			} else {
				divisibles[i] = Integer.parseInt(String.valueOf(al.get(i)));
			}

		}

	}

	private static void TurnAroundTheArrayList(ArrayList al, int[] divisibles, int[] divisibles2) {

		for (int i = 0; i <= al.size(); i++) {

			divisibles2[i] = divisibles[al.size() - i];
		}

	}

	/*
	 * Toma como parámetros una cadena de caracteres y devuelve cierto si la cadena
	 * resulta ser un palíndromo
	 */
	public static boolean checkIsPalindrome(String cadena) {
		// throw  new NotImplementedException();
		if (null == cadena)
			return false;

		cadena = cadena.toLowerCase();
		cadena = cadena.trim();
		cadena = cadena.replace(" ", "");
		cadena = cadena.replace(",", "");
		cadena = cadena.replace(".", "");
		cadena = cadena.replace("?", "");
		cadena = cadena.replace("¿", "");
		cadena = cadena.replace(":", "");
		cadena = cadena.replace("è", "");
		cadena = cadena.replace("·", "");
		cadena = cadena.replace("á", "a");
		cadena = cadena.replace("é", "e");
		cadena = cadena.replace("í", "i");
		cadena = cadena.replace("ó", "o");
		cadena = cadena.replace("ú", "u");

		String reverse = new StringBuilder(cadena).reverse().toString();
		return reverse.equals(cadena);


	}

	/*
	 * Pedir un número de 0 a 99 y mostrarlo escrito. Por ejemplo, para 56 mostrar:
	 * cincuenta y seis
	 */

	public static String speakToMe(int n) {

		String nInWords = "";
		int unidad;
		int decena;
		String between10and19 = "";
		String between20and90 = "";
		String unity = "";

		decena = n / 10;
		unidad = n % 10;

		unity = knowUnity(unidad, unity);

		between10and19 = ifnIsBetween10and19(unidad, decena, between10and19);

		between20and90 = ifnIsBetween20and90(decena, between10and19);

		nInWords = establish_nInWords(n, nInWords, unidad, between10and19, between20and90, unity);

		return nInWords;

	}

	private static String establish_nInWords(int n, String nInWords, int unidad, String between10and19,
			String between20and90, String unity) {
		if (n == 0) {
			unity = "Cero";
			nInWords = unity;

		} else if (n < 10) {
			nInWords = unity;

		} else if (n < 20) {
			if (unidad == 0)
				nInWords = between10and19;
			else
				nInWords = between10and19.concat(" y " + unity);

		} else if (n < 100) {
			if (unidad == 0)
				nInWords = between20and90;
			else
				nInWords = between20and90.concat(" y " + unity);
		}
		return nInWords;
	}

	private static String ifnIsBetween20and90(int decena, String between10and19) {
		String between20and90 = "";
		if (decena == 2)
			between20and90 = "Veinte";
		else if (decena == 3)
			between20and90 = "Treinta";
		else if (decena == 4)
			between20and90 = "Cuarenta";
		else if (decena == 5)
			between20and90 = "Cincuenta";
		else if (decena == 6)
			between20and90 = "Sesenta";
		else if (decena == 7)
			between20and90 = "Setenta";
		else if (decena == 8)
			between20and90 = "Ochenta";
		else if (decena == 9)
			between20and90 = "Noventa";
		return between20and90;
	}

	private static String ifnIsBetween10and19(int unidad, int decena, String between10and19) {
		if (decena == 1 && unidad == 0)
			between10and19 = "Diez";
		else if (decena == 1 && unidad == 1)
			between10and19 = "Once";
		else if (decena == 1 && unidad == 2)
			between10and19 = "Doce";
		else if (decena == 1 && unidad == 3)
			between10and19 = "Trece";
		else if (decena == 1 && unidad == 4)
			between10and19 = "Catorce";
		else if (decena == 1 && unidad == 5)
			between10and19 = "Quince";
		else if (decena == 1 && unidad == 6)
			between10and19 = "Dieciseis";
		else if (decena == 1 && unidad == 7)
			between10and19 = "Diecisiete";
		else if (decena == 1 && unidad == 8)
			between10and19 = "Dieciocho";
		else if (decena == 1 && unidad == 9)
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
	 * este metodo devuelve cierto si el año de la fecha es bisiesto fecha
	 * dd-MM-yyyy
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
	 * este metodo devuelve cierto si la fecha es válida
	 */
	public static boolean isValidDate(String date) {
		//throw new NotImplementedException();
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
