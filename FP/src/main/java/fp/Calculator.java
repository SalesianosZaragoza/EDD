package fp;

import java.util.List;
import java.util.ArrayList;

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
		ArrayList<Integer> fibonnaciArrayList = new ArrayList<Integer>();
		Integer n1 = 0; 
		Integer n2 = 1;
		fibonnaciArrayList.add(1);

        for (int i = 0; i < n - 1; i++) {
            int summa = n1 + n2;
            n1 = n2;
            n2 = summa;
            fibonnaciArrayList.add(summa);
        }

        return fibonnaciArrayList;
	}

	/*
	 * Escribir todos los números del number al 0 de step en step.
	 */
    public static int[] stepThisNumber (int number, int step) {
		ArrayList<Integer>numbersList = new ArrayList<Integer>();
        int res = number-step;
        while(res>0){
            numbersList.add(res);
            res-=step;
        }
        int numbers[] = new int[numbersList.size()];
        for(int i=0;i<numbers.length;i++){
            numbers[i] = numbersList.get(i);
        }
        return numbers;
    }

	/*
	 * Módulo al que se le pasa un número entero del 0 al 20 y devuelve los
	 * divisores que tiene.
	 */
    public static int[] divisors (int n) {
		if (n == 0) {
			return null;
		} else {
			int numbers[] = new int[n];
			int j = 0;

			for (int i = n; i > 0; i--)
				if (n % i == 0) {
					numbers[j] = i;
					j++;
				}

			int divisors[] = new int[j];
			for (int i = 0; i < j; i++) {
				divisors[i] = numbers[i];

			}
			return divisors;
		}
    }

	/*
	 * Toma como parámetros una cadena de caracteres y devuelve cierto si la cadena resulta ser un palíndromo
	 */
	public static boolean checkIsPalindrome(String cadena) {

		if (cadena == null)
			return false;
		else {
			String original = "áàäéèëíìïóòöúùuñÁÀÄÉÈËÍÌÏÓÒÖÚÙÜÑçÇ:;-_,.?¿¡!·";
			String ascii = "aaaeeeiiiooouuunAAAEEEIIIOOOUUUNcC           ";
			String output = cadena.toLowerCase();
			String inverOutput = "";

			for (int i = 0; i < original.length(); i++) {
				output = output.replace(original.charAt(i), ascii.charAt(i));
			}
			output = output.replace(" ", "");
			for (int i = output.length() - 1; i >= 0; i--)
				inverOutput += output.charAt(i);
			if (output.equals(inverOutput))
				return true;
			else
				return false;
		}
	}

	/*
	 * Pedir un número de 0 a 99 y mostrarlo escrito. Por ejemplo, para 56
	 * mostrar: cincuenta y seis
	 */
	public static String speakToMe(int n) {
		String number="";
        String zero = "Cero";
		String unit[] = {"uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve"};
		String ten[] = {"Diez", "Veinte", "Treinta", "Cuarenta", "Cincuenta", "Sesenta", "Setenta", "Ochenta", "Noventa"};
		if(n==0){
		    number+=zero;
		} else if(n<10){
		    number+=unit[n-1];
		} else if(n%10==0){
		    number+=ten[(n/10)-1];
		} else {
		    int elseUnit=n%10;
		    int elseTen=n/10;
		    number=ten[elseTen-1]+" y "+unit[elseUnit-1];
		}
		return number;
	}

	/*
	 * este metodo devuelve cierto si el año de la fecha es bisiesto fecha
	 * dd-MM-yyyy
	 */
	public static boolean isLeapYear(String date) {
		int year;
		if (date.isEmpty())
			return false;
		else {
			year = Integer.parseInt(date.substring(6));

			if (year % 4 == 0) {
				if (year % 100 != 0)
					return true;
				else if (year % 400 == 0)
					return true;
				else
					return false;
			} else
				return false;
		}
	}

	/*
	 * este metodo devuelve cierto si la fecha es válida
	 */
	public static boolean isValidDate(String date) {
		if (date.length() != 10)
			return false;
		else {
			Integer year, month, day;
			day = Integer.parseInt(date.substring(0, 2));
			month = Integer.parseInt(date.substring(3, 5));
			year = Integer.parseInt(date.substring(6));

			if (year != null && month <= 12 && month > 0 && day > 0 && year > 0) {
				if ((month == 4 || month == 6 || month == 7 || month == 9 || month == 11) && day <= 30) {
					return true;
				} else {
					if ((month == 2 && isLeapYear(date) && day <= 29) || (month == 2 && !(isLeapYear(date)) && day <= 28)) {
						return true;
					} else {
						if ((month != 2) && day <= 31)
							return true;
						else
							return false;
					}
				}
			} else
				return false;
		}
	}
}
