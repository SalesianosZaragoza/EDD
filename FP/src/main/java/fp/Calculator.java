package fp;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Calculator {


	/*
     * este metodo devuelve el Class del object que le pasamos
     */
	@Test
	public static Class classTypeOf(Object x) {
		throw  new NotImplementedException();
		Class clase = x.getClass();
		return clase;
	}


	/*
     * devuelve una lista con los n números de la serie de fibonacci.
     */
	@Test
	public static List<Integer> fibonacci(int n) {
		throw  new NotImplementedException();
		List<Integer> Fibonacci = new ArrayList<Integer>();
		int numero1 = 1;
		int numero2 = 1;
		
		Fibonacci.add(numero1);
		Fibonacci.add(numero2);
		int i = 0;
		while (i <= n - 3) {
		Fibonacci.add(Fibonacci.get(i) + Fibonacci.get(i + 1));
		i++;
		}
		return Fibonacci;
	}
	

	/*
	 * Escribir todos los números del number al 0 de step en step.
	 */
	@Test
	public static int[] stepThisNumber(int number, int step) {
		throw  new NotImplementedException();
				int[] numeros;
				List<Integer> numLista = new ArrayList();
				int numero = number - step;
				int i = 0;
				while (numero > 0) {
					numLista.add(numero);
					numero -= step;
					i++;
				}
				numeros = new int[i];
				for (int j = 0; j < numeros.length; j++) {
					numeros[j] = numLista.get(j);
				}
				return numeros;
	}

	/*
	 * Módulo al que se le pasa un número entero del 0 al 20 y devuelve los
	 * divisores que tiene.
	 */
	@Test
	public static int[] divisors(int n) {
		throw  new NotImplementedException();
		int divisores[];
		int cont = 0;
		
		List<Integer> lista = new ArrayList<Integer>();
		
		for (int i = n; i > 0; i--)
			if (n % i == 0) { 
				lista.add(i);
			}
		
		divisores = new int[cont];
		
		for (int i = 0; i < cont; i++)
		divisores[i] = lista.get(i); //divisores se les añade una lista
		
		return divisores;
	}

	/*
	 * Toma como parámetros una cadena de caracteres y devuelve cierto si la cadena resulta ser un palíndromo
	 */
	@Test
	public static boolean checkIsPalindrome(String cadena) {
		throw  new NotImplementedException();
		String s = cadena;
		boolean espalindrome = true;
			if (s != null) {
				s = s.replace(" ", "");
				s = s.replace(",", "");
				s = s.replace(".", "");
				s = s.replace("?", "");
				s = s.replace("¿", "");
				s = s.replace(":", "");
				s = s.replace("á", "a");
				s = s.replace("é", "e");
				s = s.replace("è", "e");
				s = s.replace("·", "");
				s = s.replace("í", "i");
				s = s.replace("ó", "o");
				s = s.replace("ú", "u");
				s = s.toLowerCase();
				int fin = s.length() - 1;
				int ini = 0;
		
				while (ini < fin) {
					if (s.charAt(ini) != s.charAt(fin)) {
						espalindrome = false;
					}
					ini++;
				fin--;
				}
			}
			return espalindrome;
	}

	/*
	 * Pedir un número de 0 a 99 y mostrarlo escrito. Por ejemplo, para 56
	 * mostrar: cincuenta y seis
	 */
	public static String speakToMe(int n) {
		throw  new NotImplementedException();
	
	}

	/*
	 * este metodo devuelve cierto si el año de la fecha es bisiesto fecha
	 * dd-MM-yyyy
	 */
	@Test
	public static boolean isLeapYear(String fecha) {
		throw  new NotImplementedException();
		String añoenletra = "";
				String calcdivisible = "";
				Integer añoennumero;
				int digitos;
				if (fecha != null && fecha != "") {
					
					for (int i = 6; i < fecha.length(); i++) {
						añoenletra += fecha.charAt(i);
					}
		
					
					añoennumero = Integer.valueOf(añoenletra);
					
					añoenletra = añoennumero.toString();
		
					for (int i = 2; i < añoenletra.length(); i++) {
						calcdivisible += añoenletra.charAt(i);
					}
		
					digitos = Integer.parseInt(calcdivisible);
		
					if ((añoennumero % 400) == 0) {
						return true;
		
				} else if ((añoennumero % 4) == 0 && (añoennumero % 100) != 0) {
						return true;
				} else {
			
					return false;
				}
			}
		
			return true;
	}

	/*
	 * este metodo devuelve cierto si la fecha es válida
	 */
	@Test
	public static boolean isValidDate(String date) {
		throw  new NotImplementedException();
		String anyo, mes, dia;
		int anyoNumero, mesNumero, diaNumero;
		
		String fecCorrecta = "dia(2)" + "/" + "mes(2)" + "/" + "anyo(4)";
			if (date.matches(fecCorrecta)) {
			// coge los digitos de cada fecha
			dia = date.substring(0, 2);
			mes = date.substring(3, 5);
			anyo = date.substring(date.length() - 4);
		
		// con el parseint pasamos los string a enteros
			diaNumero = Integer.parseInt(dia);
			mesNumero = Integer.parseInt(mes);
			anyoNumero = Integer.parseInt(anyo);
		//a partir de aqui ya podemos compararlos con valores 
		// preguntamos si los dias meses y anyos estan en un rango valido//
			int diaMaximo[]= {1,32};
			int MesMaximo[]= {1,12};
			
		if ((diaNumero >= diaMaximo[0] && diaNumero < diaMaximo[1]) && (mesNumero >= MesMaximo[0] && mesNumero <= MesMaximo[1]) && anyoNumero >= 0)
				return true;
		}else {
				return false;
		}
	}
}
