package fp;


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

	/*
	 * He ajustado el método para que diera de acuerdo con el Test, pero tras
	 * mucho rato mirando las series fibonacci en internet he visto que el
	 * resultado esperado del test esta mal Te mando el link de wikipedia para
	 * que lo veas aunque he consultado en más lugares.
	 * https://es.wikipedia.org/wiki/Sucesi%C3%B3n_de_Fibonacci
	 */
	public static List<Integer> fibonacci(int n) {
		if (n <= 0) {
			throw new ArithmeticException("not valid");
		} else {
			List<Integer> serie = new ArrayList<Integer>();
			int aux;
			int n1 = 0;
			int n2 = 1;
			// serie.add(n1);
			serie.add(n2);
			for (int i = 0; i < n - 1; i++) {
				aux = n1;
				n1 = n2;
				n2 = aux + n1;
				serie.add(n2);
			}
			return serie;
		}
	}

	/*
	 * Escribir todos los números del number al 0 de step en step.
	 */
	public static int[] stepThisNumber(int number, int step) {
		if (step < 0) {
			throw new ArithmeticException("not valid");
		} else {
			if (step == 0) {
				int[] enteros = { 0 };
				return enteros;
			} else {
				int division;
				if (number % step == 0) {
					division = (number / step) -1;
				} else {
					division = (number / (step));
				}
				int[] enteros = new int[division];
				int aux = number;
				for (int i = 0; i < division; i++) {
					aux = aux - step;
					if(aux <= 0){
					}else{
						enteros[i] = aux;
					}
				}
				return enteros;
			}
		}
	}

	/*
	 * Módulo al que se le pasa un número entero del 0 al 20 y devuelve los
	 * divisores que tiene.
	 */
	public static int[] divisors(int n) {
		if (n < 1 || n > 21) {
			return null;
		} else {
			int cont = 0;
			for (int i = 1; i <= n; i++)
				if (n % i == 0)
					cont++;
			int[] divisores = new int[cont];
			int pos = 0;
			for (int i = n; i >= 1; i--) {
				if (n % i == 0) {
					divisores[pos] = i;
					pos++;
				}
			}
			return divisores;
		}
	}

	/*
	 * Toma como parámetros una cadena de caracteres y devuelve cierto si la
	 * cadena resulta ser un palíndromo
	 */
	public static boolean checkIsPalindrome(String cadena) {
		if (cadena == null) {
			return false;
		} else {
			String acentos = "áàäéèëíìïóòöúùuñÁÀÄÉÈËÍÌÏÓÒÖÚÙÜÑçÇ";
			String noAcentos = "aaaeeeiiiooouuunAAAEEEIIIOOOUUUNcC";
			//Dos cadenas de la misma longitud para sustituir todas las letras con acentos en cadena.
			String signosDePuntuacion = ":;-_,.?¿¡!·";
			for (int i = 0; i < cadena.length(); i++) {
				int pos1 = acentos.indexOf(cadena.charAt(i));
				if(pos1 != -1){
					cadena = cadena.replace(acentos.charAt(pos1), noAcentos.charAt(pos1));
				}else{
					pos1 = signosDePuntuacion.indexOf(cadena.charAt(i));
					if(pos1 != -1){
						cadena = cadena.replace(signosDePuntuacion.charAt(pos1), ' ');
					}
				}
			}
			cadena = cadena.replace(" ", "");
			cadena = cadena.toLowerCase();
			String cadenaInvertida = "";
			for (int i = cadena.length()-1; i >= 0; i--) {
				cadenaInvertida = cadenaInvertida + cadena.charAt(i);
			}
			System.out.println(cadena);
			System.out.println(cadenaInvertida);
			if(cadena.equals(cadenaInvertida)){
				return true;
			}else{
				return false;
			}
		}
	}

	/*
	 * Pedir un número de 0 a 99 y mostrarlo escrito. Por ejemplo, para 56
	 * mostrar: cincuenta y seis
	 */
	public static String speakToMe(int n) {
		if (n < 0 || n > 99) {
			throw new ArithmeticException("not valid");
		} else {
			int decimal;
			int unidad;
			String numeroEscrito = "";
			String decenas[] = new String[9];
			decenas[0] = "Diez";
			decenas[1] = "Veinte";
			decenas[2] = "Treinta";
			decenas[3] = "Cuarenta";
			decenas[4] = "Cincuenta";
			decenas[5] = "Sesenta";
			decenas[6] = "Setenta";
			decenas[7] = "Ochenta";
			decenas[8] = "Noventa";

			String dieci = "dieci";
			String veinti = "veinti";

			String unidades[] = new String[10];
			unidades[0] = "Cero";
			unidades[1] = "uno";
			unidades[2] = "dos";
			unidades[3] = "tres";
			unidades[4] = "cuatro";
			unidades[5] = "cinco";
			unidades[6] = "seis";
			unidades[7] = "siete";
			unidades[8] = "ocho";
			unidades[9] = "nueve";

			if (n < 10) {
				numeroEscrito = unidades[n];
			} else {
				if (n == 11) {
					numeroEscrito = "once";
				}
				if (n == 12) {
					numeroEscrito = "doce";
				}
				if (n == 13) {
					numeroEscrito = "trece";
				}
				if (n == 14) {
					numeroEscrito = "catorce";
				}
				if (n == 15) {
					numeroEscrito = "quince";
				}
				if (n == 10 || n == 20 || n >= 30) {
					decimal = n / 10;
					unidad = n - (decimal * 10);
					if (unidad == 0) {
						numeroEscrito = decenas[decimal - 1];
					} else {
						numeroEscrito = decenas[decimal - 1] + " y " + unidades[unidad];
					}
				}
				if (n > 15 && n < 20) {
					decimal = n / 10;
					unidad = n - (decimal * 10);
					numeroEscrito = dieci + unidades[unidad];
				}
				if (n > 20 && n < 30) {
					decimal = n / 10;
					unidad = n - (decimal * 10);
					numeroEscrito = veinti + unidades[unidad];
				}
			}
			return numeroEscrito;
		}
	}

	/*
	 * este metodo devuelve cierto si el año de la fecha es bisiesto fecha
	 * dd-MM-yyyy
	 */
	public static boolean isLeapYear(String fecha) {
		int year;
		boolean leap = false;
		if(fecha == "" || fecha == null){
			System.out.println("Error al introducir la fecha");
		}else{
			try{
				year = Integer.parseInt(fecha.substring(6, 10));
				if(year%4 == 0){
					if(year%100 != 0){
						leap = true;
					}else{
						if(year%400 == 0){
							leap = true;
						}
					}
				}
			} catch (NumberFormatException ex) {
				System.out.println("No es bisiesto");
			}
		}
		if(leap == true)
			System.out.println("Es bisiesto");
		return leap;
	}

	/*
	 * este metodo devuelve cierto si la fecha es válida
	 */
	public static boolean isValidDate(String date) {
		boolean valid = true;
		int day;
		int month;
		int year;
		
		if(date.length() != 10){
			valid = false;
			System.out.println("No es una fecha");
		}else{
			try {
				day = Integer.parseInt(date.substring(0, 2));
				month = Integer.parseInt(date.substring(3, 5));
				year = Integer.parseInt(date.substring(6, 10));
				if((day >= 1 && day <= 31) && (month >= 1 && month <= 12) && year > 0){
					if((month == 4 || month == 6 || month == 9 || month == 11) && (day > 30 )){
						valid = false;
						System.out.println("¡Esta fecha no existe!");
					}else{
						if(month == 2 && day > 28){
							valid = false;
							System.out.println("¡Esta fecha no existe!");
						}else{
							if(month == 2 && isLeapYear(date) != true){
								valid = false;
								System.out.println("¡Esta fecha no existe!");
							}
						}
					}
				}else{
					valid = false;
					System.out.println("¡Esta fecha no existe!");
				}
				
			} catch (NumberFormatException ex) {
				valid = false;
				System.out.println("No es una fecha");
			}
		}
		return valid;
	}
}
