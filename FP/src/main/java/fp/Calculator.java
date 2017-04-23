package fp;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("restriction")
public class Calculator {
	/*
     * este metodo devuelve el Class del object que le pasamos
     */
	public static Class<? extends Object> classTypeOf(Object x) {
		return x.getClass();
	}


	/*
     * devuelve una lista con los n números de la serie de fibonacci.
     */
	public static List<Integer> fibonacci(int n) {
		List<Integer>lista=new ArrayList<Integer>();
		Integer x=0,y=1;
		Integer resultado;
		lista.add(y);
		for(int i=1;i<n;i++){
			resultado=x+y;
			x=y;
			y=resultado;
			lista.add(resultado);
		}
		return lista;
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
		if(cadena==null)
			return false;
		else{
			String original = "áàäéèëíìïóòöúùuñÁÀÄÉÈËÍÌÏÓÒÖÚÙÜÑçÇ:;-_,.?¿¡!·";
		    String ascii = "aaaeeeiiiooouuunAAAEEEIIIOOOUUUNcC           ";
		    String output = cadena.toLowerCase();
		    String inverOutput="";
		    
		    for (int i=0; i<original.length(); i++) {//quita caracteres especiales
		        output = output.replace(original.charAt(i), ascii.charAt(i));
		    }
		    output=output.replace(" ", "");//quita espacios
		    
		    for(int i=output.length()-1;i>=0;i--)//invierte la cadena
		    	inverOutput+=output.charAt(i);
		    
		    if(output.equals(inverOutput))
		    	return true;
		    else
		    	return false;
		}
	}
					
	/*
	 * Pedir un número de 0 a 99 y mostrarlo escrito. Por ejemplo, para 56
	 * mostrar: cincuenta y seis
	 */
	public static String speakToMe(int n) {
		String primer_numero="";
		String Segundo_numero="";
		String resultado="";
		
		switch (n) { //casos excepcionales
			case 0:
				Segundo_numero="Cero";
				break;
			case 10:
				resultado="Diez";
				break;
			case 11:
				resultado="Once";
				break;
			case 12:
				resultado="Doce";
				break;
			case 13:
				resultado="Trece";
				break;
			case 14:
				resultado="Catorce";
				break;
			case 15:
				resultado="Quince";
				break;
			case 20:
				resultado="Veinte";
				break;
			default://si no es un caso excepcional la primera parte del numero
				switch (n/10) {
					case 1:
						primer_numero="Dieci";
						break;
					case 2:
						primer_numero="Veinti";
						break;
					case 3:
						primer_numero="Treinta";
						break;
					case 4:
						primer_numero="Cuarenta";
						break;
					case 5:
						primer_numero="Cincuenta";
						break;
					case 6:
						primer_numero="Sesenta";
						break;
					case 7:
						primer_numero="Setenta";
						break;
					case 8:
						primer_numero="Ochenta";
						break;
					case 9:
						primer_numero="Noventa";
						break;
					default:
						break;
					}
				switch (n%10) {//la segunda parte del numero
					case 1:
						Segundo_numero="uno";
						break;
					case 2:
						Segundo_numero="dos";
						break;
					case 3:
						Segundo_numero="tres";
						break;
					case 4:
						Segundo_numero="cuatro";
						break;
					case 5:
						Segundo_numero="cinco";
						break;
					case 6:
						Segundo_numero="seis";
						break;
					case 7:
						Segundo_numero="siete";
						break;
					case 8:
						Segundo_numero="ocho";
						break;
					case 9:
						Segundo_numero="nueve";
						break;
					default:
						break;
					}
				break;
		}
		
		if(n/10>0.9){ //si tiene dos cifras
			if(n%10==0)//y termina en 0
				resultado+=primer_numero+Segundo_numero;
			else
				resultado=primer_numero+" y "+Segundo_numero;
		}else{//si tiene una cifra
			resultado=Segundo_numero.replaceFirst(Segundo_numero.substring(0, 1),Segundo_numero.substring(0, 1).toUpperCase());

		}	
		return resultado;
	}

	/*
	 * este metodo devuelve cierto si el año de la fecha es bisiesto fecha
	 * dd-MM-yyyy
	 */
	public static boolean isLeapYear(String fecha) {
		throw  new NotImplementedException();
	}

	/*
	 * este metodo devuelve cierto si la fecha es válida
	 */
	public static boolean isValidDate(String date) {
		throw  new NotImplementedException();
	}
}
