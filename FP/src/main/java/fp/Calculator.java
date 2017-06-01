package fp;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

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
		
	}

	/*
	 * Escribir todos los números del number al 0 de step en step.
	 */
	public static int[] stepThisNumber(int number, int step) {
		if(step==0){//para que no de nulo
			 			int numeros[]={0};
			 			return numeros;
			 		}else{
			 			int numeros[];
			 			
			 			if(number%step==0){
			 				numeros=new int [(number)/step-1];
			 			}
			 			else{
			 				numeros=new int [(number)/step];
			 			}
			 
			 
			 			int i=number,j=0;
			 			while((i-step)>(0)){
			 				i-=step;
			 				numeros[j]=i;
							j++;
			 			}
			 			return numeros;
			  		}
			 	}
		

	/*
	 * Módulo al que se le pasa un número entero del 0 al 20 y devuelve los
	 * divisores que tiene.
	 */
	public static int[] divisors(int n) {
		if(n==0){
			 return null;
			 		}else{
			 		int numeros[]=new int[n];
			 			int j=0;
			 			
			 			for(int i=n;i>0;i--)
			 				if(n%i==0){
			 					numeros[j]=i;
			 					j++;
			 				}
			 			int divisores[]=new int [j];
			 			for(int i=0;i<j;i++){
			 				divisores[i]=numeros[i];
			 			}
			 			
			 			return divisores;
			 		}
	}

	/*
	 * Toma como parámetros una cadena de caracteres y devuelve cierto si la cadena resulta ser un palíndromo
	 */
	public static boolean checkIsPalindrome(String cadena) {
		throw  new NotImplementedException();
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
	public static boolean isLeapYear(String fecha) {
		int año;
		 		if(fecha.isEmpty())
		 			return false;
		 		else{
		 			año=Integer.parseInt(fecha.substring(6));
		 			
		 			if(año%4==0){
		 				if(año%100!=0)
		 					return true;
		 				else
		 					if(año%400==0)
		 						return true;
		 					else 
		 						return false;
		 			}else
		 				return false;
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
}
