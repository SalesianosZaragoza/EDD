package fp;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

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
		ArrayList<Integer>fibonacci = new ArrayList<Integer>();
		int num1=1;
		int num2=0;
		int aux;
		for(int i=0;i<n;i++){
		    if(i==0){
		        fibonacci.add(num1);
		    } else {
		        fibonacci.add(num1+num2);
    		    aux=num1;
    		    num1=num1+num2;
    		    num2=aux;
		    }
		}
		return fibonacci;
	}

	/*
	 * Escribir todos los números del number al 0 de step en step.
	 */
	public static int[] stepThisNumber(int number, int step) {
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
	public static int[] divisors(int n) {
		ArrayList<Integer>divisorsList = new ArrayList<Integer>();
		int number = n;
		while (number != 0) {
			if (n % number == 0) {
				divisorsList.add(number);
			}
			number--;
		}
		int divisors[] = new int[divisorsList.size()];
		
		if(n==0){
			divisors=null;
		} else {
			for(int i=0;i<divisors.length;i++){
			    divisors[i] = divisorsList.get(i);
			}
		}
		return divisors;
	}

	/*
	 * Toma como parámetros una cadena de caracteres y devuelve cierto si la cadena resulta ser un palíndromo
	 */
	public static boolean checkIsPalindrome(String cadena) {
		 boolean is=true;
	        String copia="";
	        String cad="";
	        if(cadena!=null){
	            for(int k=cadena.length()-1;k>=0;k--){
	                if(cadena.charAt(k)!=',' && cadena.charAt(k)!=' ' && cadena.charAt(k)!='.' && cadena.charAt(k)!='¿' && cadena.charAt(k)!='?' && cadena.charAt(k)!=':' && cadena.charAt(k)!='·' && cadena.charAt(k)!='ª' && cadena.charAt(k)!='4'){
	                    copia+=cadena.charAt(k);
	                }
	            }
	            for(int k=0;k<cadena.length();k++){
	                if(cadena.charAt(k)!=',' && cadena.charAt(k)!=' ' && cadena.charAt(k)!='.' && cadena.charAt(k)!='¿' && cadena.charAt(k)!='?' && cadena.charAt(k)!=':' && cadena.charAt(k)!='·' && cadena.charAt(k)!='ª' && cadena.charAt(k)!='4'){
	                    cad+=cadena.charAt(k);
	                }
	            }
	            char vowels[][] = {{'A','a','À','Á','à','á'},{'E','e','È','É','è','é'},{'I','i','Í','Ì','í','ì'},{'O','o','Ò','Ó','ò','ó'},{'U','u','Ù','Ú','ù','ú'}};
	            ArrayList<Character>a = new ArrayList<Character>();
	            ArrayList<Character>e = new ArrayList<Character>();
	            ArrayList<Character>i = new ArrayList<Character>();
	            ArrayList<Character>o = new ArrayList<Character>();
	            ArrayList<Character>u = new ArrayList<Character>();
	            for(int k=0;k<vowels[0].length;k++){
	                a.add(vowels[0][k]);
	                e.add(vowels[1][k]);
	                i.add(vowels[2][k]);
	                o.add(vowels[3][k]);
	                u.add(vowels[4][k]);
	            }

	            for(int k=0;k<cad.length() && is;k++){
	                if(a.contains(cad.charAt(k)) && a.contains(copia.charAt(k))){
	                    is=true;
	                }else if(e.contains(cad.charAt(k)) && e.contains(copia.charAt(k))){
	                    is=true;
	                }else if(i.contains(cad.charAt(k)) && i.contains(copia.charAt(k))){
	                    is=true;
	                }else if(o.contains(cad.charAt(k)) && o.contains(copia.charAt(k))){
	                    is=true;
	                }else if(u.contains(cad.charAt(k)) && u.contains(copia.charAt(k))){
	                    is=true;
	                }else if((int)cad.charAt(k)>64 && (int)cad.charAt(k)<91){
	                    if((int)cad.charAt(k)==(int)copia.charAt(k) || (int)cad.charAt(k)==(int)(copia.charAt(k))-32){
	                        is=true;
	                    } else {
	                        is=false;
	                    }
	                }else if((int)cad.charAt(k)>96 && (int)cad.charAt(k)<123){
	                    if((int)cad.charAt(k)==(int)copia.charAt(k) || (int)cad.charAt(k)==(int)(copia.charAt(k))+32){
	                        is=true;
	                    } else {
	                        is=false;
	                    }
	                } else {
	                    is=false;
	                }
	            }
	        }
	        return is;
	}

	/*
	 * Pedir un número de 0 a 99 y mostrarlo escrito. Por ejemplo, para 56
	 * mostrar: cincuenta y seis
	 */
	public static String speakToMe(int n) {
		String numero="";
        String cero = "Cero";
		String unidades[] = {"uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve"};
		String decenas[] = {"Diez", "Veinte", "Treinta", "Cuarenta", "Cincuenta", "Sesenta", "Setenta", "Ochenta", "Noventa"};
		if(n==0){
		    numero+=cero;
		} else if(n<10){
		    numero+=unidades[n-1];
		} else if(n%10==0){
		    numero+=decenas[(n/10)-1];
		} else {
		    int unidad=n%10;
		    int decena=n/10;
		    numero=decenas[decena-1]+" y "+unidades[unidad-1];
		}
		return numero;
	}

	/*
	 * este metodo devuelve cierto si el año de la fecha es bisiesto fecha
	 * dd-MM-yyyy
	 */
	public static boolean isLeapYear(String fecha) {
		boolean is=false;
        String date = "";
        char letter;
        if(fecha.length()>1){
            for(int i=4;i>0;i--){
                letter = fecha.charAt(fecha.length()-i);
                date += letter;
            }
            int year = Integer.parseInt(date);
            if ((year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0))){
                is=true;
            }
        }
        return is;
    }

	/*
	 * este metodo devuelve cierto si la fecha es válida
	 */
	public static boolean isValidDate(String date) {
		boolean is=false;
        boolean day=false, month=false, year=false;
        String stringDate[] = {"","",""};
        int contChar=0;
        int posStringDate=0;
        if(date.length()>1){
            while(contChar<date.length()){
                if(date.charAt(contChar)=='-'){
                    posStringDate++;
                    contChar++;
                }
                stringDate[posStringDate]+=date.charAt(contChar);
                contChar++;
            }
            if(stringDate[0].length()>1 && stringDate[1].length()>1 && stringDate[2].length()>1 ){
                if(Integer.parseInt(stringDate[0])>0 && Integer.parseInt(stringDate[0])<=31){
                    day=true;
                }
                if(Integer.parseInt(stringDate[1])>0 && Integer.parseInt(stringDate[1])<=12){
                    month=true;
                }
                if(Integer.parseInt(stringDate[2])>0){
                    year=true;
                }
            }
        }
        if(day && month && year){
            is=true;
        }
        return is;
	}
}
