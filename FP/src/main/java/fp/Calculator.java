package fp;

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
		int a = 0;
		int b = 1;
		int res = 0;
		List<Integer>serie = new ArrayList<Integer>();
		serie.add(b);
		
		for(int i = 0; i < n-1; i++) {
			res = a + b;
			a = b;
			b = res;
			serie.add(res);
		}
		return serie;
	}

	/*
	 * Escribir todos los números del number al 0 de step en step.
	 */
	public static int[] stepThisNumber(int number, int step) {
		int tamanyoArray = 0;
		int [] numeros;
		int i = 0;
		int auxnumber = number;
		
		while(auxnumber-step>0) {
			auxnumber -= step;
			tamanyoArray++;
		}
		numeros = new int[tamanyoArray];
		while(number-step>0) {
			numeros[i] = number - step;
			number -= step;
			i++;
		}
		return numeros;
	}

	/*
	 * Módulo al que se le pasa un número entero del 0 al 20 y devuelve los
	 * divisores que tiene.
	 */
	public static int[] divisors(int n) {
		if(n == 0) {
			return null;
		}
		int tamanyoArray = 0;
		int [] divisores;
		int k = 0;
		for(int i = n; i > 0; i--) {
			if(n%i==0) {
				tamanyoArray++;
			}
		}
		divisores = new int[tamanyoArray];
		for(int j = n; j > 0; j--) {
			if(n%j==0) {
				divisores[k] = j;
				k++;
			}
		}
		return divisores;
	}

	/*
	 * Toma como parámetros una cadena de caracteres y devuelve cierto si la cadena resulta ser un palíndromo
	 */
	public static boolean checkIsPalindrome(String cadena) {
		if(cadena==null) {
			return false;
		}
		String fraseEnMinusculas = cadena.toLowerCase();
		String frase3 = "";
		char [] vocalesTilde = {'á', 'é', 'í', 'ó', 'ú'};
		char [] vocales = {'a', 'e', 'i', 'o', 'u'};
		boolean contvocales = true;
		int cont = 0;
		
		frase3 = dejarSoloLetras(fraseEnMinusculas, frase3, vocalesTilde, vocales, contvocales);
		for(int i = 0; i < (frase3.length()/2); i++) {
			if(frase3.charAt(i)==frase3.charAt(frase3.length()-i-1)) {
				cont++;
			}
		}
		if(cont==frase3.length()/2) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private static String dejarSoloLetras(String fraseEnMinusculas, String frase3, char[] vocalesTilde, char[] vocales,
			boolean contvocales) {
		for(int i = 0; i < fraseEnMinusculas.length(); i++) {
			if(Character.isLetter(fraseEnMinusculas.charAt(i))) {
				for(int j = 0; j < vocales.length; j++) {
					if(fraseEnMinusculas.charAt(i)==vocalesTilde[j]) {
						frase3 += vocales[j];
						contvocales = false;
					}
				}
				if(contvocales) {
					frase3 += fraseEnMinusculas.charAt(i);
				}
			}
			contvocales = true;
		}
		return frase3;
	}

	/*
	 * Pedir un número de 0 a 99 y mostrarlo escrito. Por ejemplo, para 56
	 * mostrar: cincuenta y seis
	 */
	public static String speakToMe(int n) {
		String [] decenas = {"", "Diez", "Veinte", "Treinta", "Cuarenta", "Cincuenta", "Sesenta", "Setenta",
				"Ochenta", "Noventa"};
		String [] unidades = {"", "uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve"};
		
		switch (n) {
			case 0: return "Cero";
			case 11: return "Once";
			case 12: return "Doce";
			case 13: return "Trece";
			case 14: return "Catorce";
			case 15: return "Quince";
		}
		
		if(n/10==0) {
			return unidades[n];
		}else if(n%10==0) {
			return decenas[n/10];
		}else {
			return (decenas[n/10] + " y " + unidades[n%10]);
		}
	}

	/*
	 * este metodo devuelve cierto si el año de la fecha es bisiesto fecha
	 * dd-MM-yyyy
	 */
	public static boolean isLeapYear(String fecha) {
		if(fecha == "") {
			return false;
		}
		String anyo = fecha.substring(fecha.length()-4, fecha.length());
		int anyoNum = Integer.parseInt(anyo);
		if(anyoNum%4==0&&anyoNum%100==0&&anyoNum%400==0) {
			return true;
		}
		else if(anyoNum%4==0&&anyoNum%100!=0) {
			return true;
		}
		else {
			return false;
		}
	}

	/*
	 * este metodo devuelve cierto si la fecha es válida
	 */
	public static boolean isValidDate(String date) {
		String sDia = "";
		int dia = 0;
		String sMes = "";
		int mes = 0;
		String sAnyo = "";
		int anyo = 0;
		int posAnterior = 0;
    		int posicion = date.indexOf("-");
    		int contGuiones = 0;
    	
    		contGuiones = contarGuiones(date, contGuiones);
		if(contGuiones!=2) {
			return false;
		}
    	
    		sDia = date.substring(0,posicion);
    		dia = Integer.parseInt(sDia);
    		posAnterior = posicion;
    		posicion = date.indexOf("-", posicion+1);
    		sMes = date.substring(posAnterior+1, posicion);
    		mes = Integer.parseInt(sMes);
    		sAnyo = date.substring(posicion+1, date.length());
    		anyo = Integer.parseInt(sAnyo);
    	
    		return((dia>0&&dia<=31)&&(mes>0&&mes<=12)&&(anyo>0&&anyo<2020))?true:false;
	}
	
	private static int contarGuiones(String date, int contGuiones) {
		for(int i = 0; i < date.length(); i++) {
			if(date.charAt(i)=='-') {
				contGuiones++;
			}
		}
		return contGuiones;
	}
}
