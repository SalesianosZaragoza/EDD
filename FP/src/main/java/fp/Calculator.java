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
	public static List<Integer> fibonacci(int n) {
		List<Integer> listaFibonacci = new ArrayList<Integer>();

		if (n == 1)
			listaFibonacci.add(1); // para poner el primer numero

		if (n > 1) {
			listaFibonacci.add(1 + 1); // sumamos al primer numero otro

			if (n > 2)
				for (int i = 2; i < n; i++) // bucle desde 2, formula de los fibonacci = (numero1-1) + (numero2-2)
					listaFibonacci.add(listaFibonacci.get(listaFibonacci.size() - 1)
							+ listaFibonacci.get(listaFibonacci.size() - 2));
				}
		
		return listaFibonacci;
		
	}

	/*
	 * Escribir todos los números del number al 0 de step en step.
	 */
	public static int[] stepThisNumber(int number, int step) {
		int numeros[] = null;
		List<Integer> listaNumeros = new ArrayList<Integer>();

		if (step != 0) {

			for (int i = 1; i <= number / step; i++)
				if (number - step * i > 0) // Si la resta de los numeros es mayor que cero que lo multiplque
					listaNumeros.add(number - step * i);

			numeros = new int[listaNumeros.size()]; // instanciamos el vector de enteros numeros

			for (int i = 0; i < listaNumeros.size(); i++)
				numeros[i] = listaNumeros.get(i); // asignamos la lista al vector, como lo hemos echo en otro test
		}

		return numeros;


		} 

	/*
	 * Módulo al que se le pasa un número entero del 0 al 20 y devuelve los
	 * divisores que tiene.
	 */
	public static int[] divisors(int n) {
		int divisores[] = null;
		int contador = 0;

		List<Integer> lista = new ArrayList<Integer>();

		for (int i = n; i > 0; i--)
			if (n % i == 0) { // cada vez el numero se divida para i y sea distinto de 0, sumara uno al
								// contador y se añadiraa la lista
				contador++;
				lista.add(i);
			}

		divisores = new int[contador]; // servira para tener un vector de enteros, con las veces de contador

			for (int i = 0; i < contador; i++)
			divisores[i] = lista.get(i); // asignamos lista a los divisores

		return divisores;

	}  

	/*
	 * Toma como parámetros una cadena de caracteres y devuelve cierto si la cadena resulta ser un palíndromo
	 */
	public static boolean checkIsPalindrome(String cadena) {

		String letrasSustiruir[] = { "[á]", "[é]", "[í]", "[ó]", "[ú]" };
		String letrasCambiadas[] = { "a", "e", "i", "o", "u" };
				
		if (cadena == null)
			return false;
		else {
			for (int i = 0; i < letrasCambiadas.length; i++) // reemplazamos las letras
				cadena = cadena.replaceAll(letrasSustiruir[i], letrasCambiadas[i]);

			cadena = cadena.toLowerCase().replaceAll("//vocales", ""); // las convertimos a minisculas todas

			int numeroCadena = cadena.length();

			for (int i = 0; i < (numeroCadena / 2); i++) {
				if (cadena.charAt(i) != cadena.charAt(numeroCadena - i - 1)) // preguntamos si es distinto de las
																				// vocales, que nos da false
					return false;	
			}
			return true;
		}
		 

	} 

	/*
	 * Pedir un número de 0 a 99 y mostrarlo escrito. Por ejemplo, para 56
	 * mostrar: cincuenta y seis
	 */
	public static boolean speakToMe(int n) {

		int numero = 0;
		int decimal = 0;
		int unidad = 0;
		String Decimales[] = { "Diez", "Veinte ", "treinta ", "cuarenta ", "Cincuenta ", "Sesenta", "Setenta",
				"Ochenta", "Noventa" };
		String unidades[] = { "Cero", "Uno", "Dos", "Tres", "Cuatro", "Cinco", "Seis", "Siete", "Ocho", "Nueve" };

		while (numero > 99 || numero < 0)
			if (numero < 10) {
			System.out.println(unidades[numero]);
			} else if (numero == 11)
				System.out.println("Once");

		if (numero == 12)
				System.out.println("Doce");

		if (numero == 13)
			System.out.println("Trece");

		if (numero == 14)
			System.out.println("Catorce");

			if (numero == 15) {
				System.out.println("Quince");

			if (numero == 10 || numero > 15) {
				decimal = numero / 10;
				unidad = numero - (decimal * 10);
				if (unidad == 0)
					System.out.println(Decimales[decimal - 1]);
				else
					System.out.println(Decimales[decimal - 1] + "y " + unidades[unidad]);

			}
		}
		return true;
	}


		
	/*
	 * este metodo devuelve cierto si el año de la fecha es bisiesto fecha
	 * dd-MM-yyyy
	 */
	public static boolean isLeapYear(String fecha) {
		if (fecha != "" && fecha != null) {
			String anio = fecha.substring(fecha.length() - 4);

			int anioNumero = Integer.parseInt(anio); // convertimos el anio en entero

			boolean mesBisiesto = ((anioNumero % 4 == 0) && (anioNumero % 100 != 0)) || (anioNumero % 400 == 0); // comparamos
																													// el
																													// anioNumero
																													// si
																													// es
																													// bisiesto
																													// o
																													// no,
																													// si
																													// estra
																													// cada
																													// cuatro
																													// años

			if (!mesBisiesto)
				return false;
		}
		return true;
	}

	/*
	 * este metodo devuelve cierto si la fecha es válida
	 */
	public static boolean isValidDate(String date) {
		String anio, mes, dia;
		int anioNumero, mesNumero, diaNumero;

		String fechaCorrecta = "dia(2)" + "-" + "mes(2)" + "-" + "anio(4)";
		if (date.matches(fechaCorrecta)) {
			// funcion substring para coger los digitos de cada fecha
			dia = date.substring(0, 2);
			mes = date.substring(3, 5);
			anio = date.substring(date.length() - 4);

			// los pasamos a enteros porque son strings
			diaNumero = Integer.parseInt(dia);
			mesNumero = Integer.parseInt(mes);
			anioNumero = Integer.parseInt(anio);

			// preguntamos si el dia es mayor que 1 y menor 32 // para los meses si es entre
			// 1 y 12 // para los anios mayor que 0
			if ((diaNumero >= 1 && diaNumero < 32) && (mesNumero >= 1 && mesNumero <= 12) && anioNumero >= 0)
				return true;
		}
		return false;

	} 
}
