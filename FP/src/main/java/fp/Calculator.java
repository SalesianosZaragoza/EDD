package fp;

import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
		List<Integer> lista = new ArrayList<Integer>();
		int cont = 1;
		lista.add(cont);
		lista.add(cont);
		
		for (int i = 2; i < n; i++) {
			lista.add(lista.get(i - 2) + lista.get(i - 1));
		}
		
		return lista;
	
	}

	/*
	 * Escribir todos los números del number al 0 de step en step.
	 */
	public static int[] stepThisNumber(int number, int step) {
		int cont = 0, num = number;
		
		while(num-step>0) {
			num-=step;
			cont++;			
		}
		
		int i = 0;
		int [] nums = new int[cont];
		
		while(number-step>0) {
			nums[i]= number-step;
			number-=step;
			i++;		
		}
		return nums;
		}

	/*
	 * Módulo al que se le pasa un número entero del 0 al 20 y devuelve los
	 * divisores que tiene.
	 */
	public static int[] divisors(int n) {
		if (n == 0) 
			return null;
		
		List<Integer> div = new ArrayList<>();
		for (int i = n; i > 0; i--) {
			if ((n % i) == 0) 
				div.add(i);
		}

		int stringDiv[] = new int[div.size()];

		for (int i = 0; i < div.size(); i++) {
			stringDiv[i] = div.get(i);
		}
		return stringDiv;
	}

	/*
	 * Toma como parámetros una cadena de caracteres y devuelve cierto si la cadena resulta ser un palíndromo
	 */
	public static boolean checkIsPalindrome(String cadena) {
		if (cadena == null) {
            return false;
        }else {
            cadena = cadena.toLowerCase().replace("á", "a").replace("é", "e").replace("í", "i").replace("ó", "o")
                    .replace("ú", "u").replace(".", "").replace(" ", "").replace(":", "").replace("?", "").replace("¿","")
                    .replace(",", "") .replace("¡", "") .replace("!", "");
            String cambio = new StringBuilder(cadena).reverse().toString();
            return cambio.equals(cadena);
        }
	}

	/*
	 * Pedir un número de 0 a 99 y mostrarlo escrito. Por ejemplo, para 56
	 * mostrar: cincuenta y seis
	 */
	public static String speakToMe(int n) {
		int valor;
        int unidades, decenas;
        String cadena = "";
        valor = n;
        unidades = valor % 10;
        decenas = valor / 10;
        switch (decenas) {
            case 0:
                cadena = "";
                break;
            case 1:
                cadena = "Diez";
                break;
            case 2:
                cadena = "Veinte";
                break;
            case 3:
                cadena = "Treinta";
                break;
            case 4:
                cadena = "Cuarenta";
                break;
            case 5:
                cadena = "Cincuenta";
                break;
            case 6:
                cadena = "Sesenta";
                break;
            case 7:
                cadena = "Setenta";
                break;
            case 8:
                cadena = "Ochenta";
                break;
            case 9:
                cadena = "Noventa";
                break;
        }
        if ((n > 10)&&unidades>0) {
            cadena = cadena + " y ";
        } else {
            cadena = cadena + "";
        }
        switch (unidades) {
            case 0:
                cadena = cadena + "";
                break;
            case 1:
                cadena = cadena + "uno";
                break;
            case 2:
                cadena = cadena + "dos";
                break;
            case 3:
                cadena = cadena + "tres";
                break;
            case 4:
                cadena = cadena + "cuatro";
                break;
            case 5:
                cadena = cadena + "cinco";
                break;
            case 6:
                cadena = cadena + "seis";
                break;
            case 7:
                cadena = cadena + "siete";
                break;
            case 8:
                cadena = cadena + "ocho";
                break;
            case 9:
                cadena = cadena + "nueve";
                break;
        }
        if(n==0) 
        	return "Cero";
        else 
        	return cadena;	
	}

	/*
	 * este metodo devuelve cierto si el año de la fecha es bisiesto fecha
	 * dd-MM-yyyy
	 */
	public static boolean isLeapYear(String fecha) {
		if(fecha=="") {
			return false;
		}
		
		String year = fecha.substring(fecha.length()-4);
		int año = Integer.parseInt(year);
		
        if ((año % 4 == 0) && ((año % 100 != 0) || (año % 400 == 0)))
            return true;
        else
            return false;
	}

	/*
	 * este metodo devuelve cierto si la fecha es válida
	 */
	public static boolean isValidDate(String date) {
		try {
            SimpleDateFormat ff = new SimpleDateFormat("dd/MM/yyyy");
            ff.setLenient(false);
            ff.parse(date);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }
}

