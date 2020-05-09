package fp;

import java.util.ArrayList;
import java.util.List;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

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
		List<Integer> lista;
		lista = new ArrayList<Integer>();
		
		lista.add(1);
		lista.add(1);
		for (int i = 2; i < n; i++) {
			lista.add(lista.get(i-2)+lista.get(i-1));
		}
		
		return lista;
	}

	/*
	 * Escribir todos los números del number al 0 de step en step.
	 */
	public static int[] stepThisNumber(int number, int step) {
		int num[];
		if(step != 0)
			if(number%step == 0)
				num = new int[number/step - 1];
			else
				num = new int[number/step];
		else
			num = new int[0];
		for (int i = 0; i < num.length; i++) {
			number -= step;
			if(number != 0) {
				num[i] = number;
			}
		}
		
		return num;
	}

	/*
	 * Módulo al que se le pasa un número entero del 0 al 20 y devuelve los
	 * divisores que tiene.
	 */
	public static int[] divisors(int n) {
		int[] divisores;
		int longitudArray = 0;
		
		for(int i = n; i >=1 ; i--){
	        if(n%i==0){
	        	longitudArray++;
	        }
	    }
		if(n != 0)
			divisores = new int [longitudArray];
		else
			divisores = null;
		for(int i = n, cont = 0; i >=1 ; i--){
	        if(n%i==0){
	        	divisores[cont++] = i;
	        }
	    }
		
		return divisores;
	}

	/*
	 * Toma como parámetros una cadena de caracteres y devuelve cierto si la cadena resulta ser un palíndromo
	 */
	public static boolean checkIsPalindrome(String cadena) {
		if(cadena == null)
			return false;
		String inversa = "";
		cadena = cadena.toLowerCase().replace("á", "a").replace("é", "e").replace("è", "e").replace("í", "i").replace("ó", "o")
				.replace("ú", "u").replace(" ", "").replace(".", "").replace(",", "").replace("·", "").replace("?", "").replace("¿","").replace(":", "");
		
		for (int i = cadena.length()-1; i >= 0; i--) {
			inversa += cadena.charAt(i);
		}
		return inversa.equals(cadena);
	}

	/*
	 * Pedir un número de 0 a 99 y mostrarlo escrito. Por ejemplo, para 56
	 * mostrar: cincuenta y seis
	 */
	public static String speakToMe(int n) {
		String habla = "";
		if(n <= 29) {
			switch(n){
			case 0:
				habla = "Cero";
				break;
			case 1:
				habla = "Uno";
				break;
			case 2:
				habla = "Dos";
				break;
			case 3:
				habla = "Tres";
				break;
			case 4:
				habla = "Cuatro";
				break;
			case 5:
				habla = "Cinco";
				break;
			case 6:
				habla = "Seis";
				break;
			case 7:
				habla = "Siete";
				break;
			case 8:
				habla = "Ocho";
				break;
			case 9:
				habla = "Nueve";
				break;
			case 10:
				habla = "Diez";
				break;
			case 11:
				habla = "Once";
				break;
			case 12:
				habla = "Doce";
				break;
			case 13:
				habla = "Trece";
				break;
			case 14:
				habla = "Catorce";
				break;
			case 15:
				habla = "Quince";
				break;
			case 16:
				habla = "Dieciséis";
				break;
			case 17:
				habla = "Diecisiete";
				break;
			case 18:
				habla = "Dieciocho";
				break;
			case 19:
				habla = "Diecinueve";
				break;
			case 20:
				habla = "Veinte";
				break;
			case 21:
				habla = "Veintiuno";
				break;
			case 22:
				habla = "Veintidós";
				break;
			case 23:
				habla = "Veintitrés";
				break;
			case 24:
				habla = "Veinticuatro";
				break;
			case 25:
				habla = "Veinticinco";
				break;
			case 26:
				habla = "Veintiséis";
				break;
			case 27:
				habla = "Veintisiete";
				break;
			case 28:
				habla = "Veintiocho";
				break;
			case 29:
				habla = "Veintinueve";
				break;
			}
		}else {
			int decena = n/10;
			int unidad =  n%10;
			String[] decenas = {"Treinta", "Cuarenta", "Cincuenta", "Sesenta", "Setenta", "Ochenta", "Noventa"};
			String[] unidades = {" y uno", " y dos", " y tres", " y cuatro"," y cinco", " y seis", " y siete",
					" y ocho", " y nueve"};
			if(unidad == 0)
				habla = decenas[decena-3];
			else {
				habla = decenas[decena-3] + unidades[unidad - 1];
			}
			
			
		}
		
		return habla;
	}

	/*
	 * este metodo devuelve cierto si el año de la fecha es bisiesto fecha
	 * dd-MM-yyyy
	 */
	public static boolean isLeapYear(String fecha) {
		if(fecha != "") {
			int anio = Integer.parseInt(fecha.substring(fecha.length() - 4, fecha.length()));
			if ((anio % 4 == 0) && ((anio % 100 != 0) || (anio % 400 == 0)))
				return true;
			else
				return false;
		}else {
			return false;
		}
	}

	/*
	 * este metodo devuelve cierto si la fecha es válida
	 */
	public static boolean isValidDate(String date) {
		if(date.equals(""))
			return false;
		String[] split = date.split("-");
		int cont = 0;
		boolean valida = true;
		if(split.length == 3) {
			valida = noTodoCeros(split, cont, valida);
			if(Integer.parseInt(split[0]) > 31)
				valida = false;
			if(Integer.parseInt(split[1]) > 12) {
				valida = false;
			}
			if((split[0].length() != 2) || (split[1].length() != 2) || (split[2].length() != 4))
				valida = false;
		}else {
			valida = false;
		}
		return valida;
	}

	private static boolean noTodoCeros(String[] split, int cont, boolean valida) {
		for (int i = 0; i < split.length; i++) {
			for (int j = 0; j < split[i].length(); j++) {
				if(split[i].charAt(j) != '0') {
					cont++;
				}
			}
			if(cont == 0)
				valida = false;
			cont = 0;
		}
		return valida;
	
	}
}
