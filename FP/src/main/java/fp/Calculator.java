package fp;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.NotImplementedException;
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
		List<Integer> listaFibo = new ArrayList<Integer>();
		int n1 = 0, n2 = 1, n3 = 0;
		for (int i = 0; i < n; i++) {
			n3 = n1 + n2;
			n2 = n1;
			n1 = n3;
			listaFibo.add(n3);

		}

		return listaFibo;
	}

	/*
	 * Escribir todos los números del number al 0 de step en step.
	 */
	public static int[] stepThisNumber(int number, int step) {
		List<Integer> listaNumeros = new ArrayList<Integer>();
		while(number - step > 0){
			listaNumeros.add(number - step);
			number -= step;
		}
		int[] numeros = new int[listaNumeros.size()];
		for(int i = 0; i < numeros.length; i++){
			numeros[i] = listaNumeros.get(i);
		}
		return numeros;
	}

	/*
	 * Módulo al que se le pasa un número entero del 0 al 20 y devuelve los
	 * divisores que tiene.
	 */
	public static int[] divisors(int n) {
		if(n == 0)
			return null;
		int num = 0;
		for(int i = 1; i <= n; i++){
			if(n % i == 0)
				num++;
		}
		int[] divisores = new int[num];
		for(int i = n, j = 0; i > 0; i--){
			if(n % i == 0){
				divisores[j] = i;
				j++;
			}
		}
		return divisores;
	}

	/*
	 * Toma como parámetros una cadena de caracteres y devuelve cierto si la cadena resulta ser un palíndromo
	 */
	public static boolean checkIsPalindrome(String cadena) {
		if(cadena == null){
			return false;
		}
		else{
			cadena = cadena.toLowerCase();
			cadena = cadena.replace("á","a");
			cadena = cadena.replace("é","e");
			cadena = cadena.replace("í","i");
			cadena = cadena.replace("ó","o");
			cadena = cadena.replace("ú","u");
			cadena = cadena.replace("¿", "");
			cadena = cadena.replace("?", "");
			cadena = cadena.replace(":", "");
			cadena = cadena.replace(" ", "");
			cadena = cadena.replace(",", "");
			cadena = cadena.replace("·", "");
			cadena = cadena.replace(".", "");
			int fin = cadena.length() - 1;
			int ini = 0;
			boolean palindromo = true;

			while (ini < fin) {
				if (cadena.charAt(ini) != cadena.charAt(fin)){
					palindromo = false;
				}
				ini++;
				fin--;
			}
			return palindromo;
		}
	}

	/*
	 * Pedir un número de 0 a 99 y mostrarlo escrito. Por ejemplo, para 56
	 * mostrar: cincuenta y seis
	 */
	public static String speakToMe(int n) {
		String cero = "Cero";
        String[] uds = {"uno","dos","tres","cuatro","cinco","seis","siete","ocho","nueve"};
        String[] decs = {"Diez","Veinte","Treinta","Cuarenta","Cincuenta","Sesenta","Setenta","Ochenta","Noventa"};
        String[] teens = {"Once","Doce","Trece","Catorce","Quince","Dieciseis","Diecisiete","Dieciocho","Diecinueve"};
        String num = "";

        if (n == 0) {
            num += cero;
        } else if (n>10 && n<20) {
            num += teens[n%10-1];
        } else if (n > 9 && n%10 == 0) {
            num += decs[n/10-1];
        } else if (n < 10) {
            num += uds[n-1];
        } else {
            num = decs[n/10-1] + " y " + uds[n%10-1];
        }
        return num;
    }

	/*
	 * este metodo devuelve cierto si el año de la fecha es bisiesto fecha
	 * dd-MM-yyyy
	 */
	public static boolean isLeapYear(String fecha) {
		if((fecha == null)||(fecha == "")){
			return false;
		}
		else{
			String[] fechaSeparada = fecha.split("-");
			int anio = Integer.parseInt(fechaSeparada[2]);
			if((anio % 4 == 0) && ((anio % 100 != 0) || (anio % 400 == 0))){
				return true;
			}
			else{
				return false;
			}
		}
	}

	/*
	 * este metodo devuelve cierto si la fecha es válida
	 */
	public static boolean isValidDate(String date) {
	if (date.length() != 10)
		return false;

	int dia = Integer.parseInt(date.substring(0,2));
	int mes = Integer.parseInt(date.substring(3,5));
	int anyo = Integer.parseInt(date.substring(6));

	return (dia>=1 && dia<=31) && (mes>=1 && mes<=12) && (anyo>0);
	}
}
