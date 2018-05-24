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
		List<Integer>numbers = new ArrayList<Integer>();
		int n1 = 1;
		int n2 = 1;
		int aux;
		numbers.add(n1);
		numbers.add(n2);
		for (int i = 0; i < numbers.size(); i++) {
			aux = n1;
			n1 = n2;
			n2 = aux + n1;
			numbers.add(n2);
		}
		
		return numbers;
}
		   
	

	/*
	 * Escribir todos los números del number al 0 de step en step.
	 */
	public static int[] stepThisNumber(int number, int step) {
		List<Integer>restas = new ArrayList<Integer>();
			int cont = 0;
			while(number > step) {
				 restas.add(number - step);
				 number -= step;
				 
				
				
				
			}
			int vector[] = new int [restas.size()];
			for (int i = 0; i < vector.length; i++) {
				vector[i] = restas.get(i);
				
			}
			return vector;
		}

	/*
	 * Módulo al que se le pasa un número entero del 0 al 20 y devuelve los
	 * divisores que tiene.
	 */
	public static int[] divisors(int n) {
		int divisores[] = null;
				List<Integer> numeros = new ArrayList<Integer>();
				int posiciones = 0;
		
				if (n > 0) {
					for (int i = n; i > 0; i--) {
						if (n % i == 0) {
							numeros.add(i);
							posiciones++;
						}
					}
		
					divisores = new int[posiciones];
					for (int i = 0; i < posiciones; i++) {
						divisores[i] = numeros.get(i);
					}
				}
				return divisores;
				
	}
			
    


	/*
	 * Toma como parámetros una cadena de caracteres y devuelve cierto si la cadena resulta ser un palíndromo
	 */
	public static boolean checkIsPalindrome(String cadena) {
		int cadena1 = 0;
		int cadena2 = cadena.length()-1;
		boolean noes = false;
		while ((cadena1<cadena2) && (!noes)){
			 
			if (cadena.charAt(cadena1)==cadena.charAt(cadena2)){				
				cadena1++;
				cadena2--;
			} else {
				noes = true;
			}
		}
		if (!noes)
			return true;
		else
			return false;
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
	}

	/*
	 * este metodo devuelve cierto si la fecha es válida
	 */
	public static boolean isValidDate(String date) {
		 if(date.length()!=10)
						 			return false;
						 		else{
						 			Integer año,mes,dia;
						 			dia=Integer.parseInt(date.substring(0,2));
						 			mes=Integer.parseInt(date.substring(3,5));
						 			año=Integer.parseInt(date.substring(6));
						 
						 			if(año!=null && mes<=12 && mes>0 && dia>0 && año>0){
						 				if((mes==4 || mes==6 ||mes==7 || mes==9 || mes==11) && dia<=30){
						 					return true;
						 				}else{
						 					if((mes==2 && isLeapYear(date) && dia<=29)||(mes==2 && !(isLeapYear(date)) && dia<=28)){
						 						return true;
						 					}else{
						 						if((mes!=2) && dia<=31)
						 							return true;
						 						else 
						 							return false;
						 					}
						 				}
						 			}else
						 				return false;
						 		}
			 	}	
		return false;
		
	}
}
