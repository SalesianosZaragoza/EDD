package fp;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.text.ParseException;
import java.util.*;

public class Calculator {

	public static Class classTypeOf(Object x){
		return x.getClass(); 
		//He utilizado el m�todo getClass que devuelve la clase del objeto indicado.
	}

	public static List<Integer> fibonacci(int n){
		List<Integer> serie = new java.util.ArrayList<Integer>();
			Integer n1=0;
			Integer n2=1;
			Integer resultado;
			serie.add(n2);
			if (n<=0)
				throw new ArithmeticException("No se puede realizar.");
			else{
				for(int i=1;i<n;i++){
					resultado=n1+n2;
					n1=n2;
					n2=resultado;
					serie.add(resultado);
				}
				return serie;
			}
		//He utilizado una serie de objetos Integer donde se van almacenando resultados, y dicho resultado va sumandose el resultado anterior.
	}

	public static int[] stepThisNumber(int number, int step){
		double cont;
		if(step<0){
			throw new ArithmeticException("No es v�lido.");
		}else{
			if(step==0 || number==0){
				int[] resultado=new int[0];
				return resultado;
			}else{
				cont = number/step;
				int largura = (int)(Math.floor(cont));
				int[] resultado = new int[largura];
				
				if(number%step==0){
					largura=largura-1;
					for(int i=0; i<largura; i++){
						resultado[i]=number-step;
						number=resultado[i];
					}
				}else{
					for(int i=0; i<largura; i++){
						resultado[i]=number-step;
						number=resultado[i];
					}
				}
				int solucion[] = new int [largura];
				for(int i=0; i<largura; i++){
					solucion[i]=resultado[i];
				}
			return solucion;
			}
		}
		//Me he asegurado de que el salto no es de 0 porque no avanzar�a, y, cuando he hecho eso, he calculado el tama�o del vector y he ido restando el salto al n�mero.
	}

	public static int[] divisors(int n) {
		if (n<1 || n>21){
			return null;
		}else{
			int largura = 0;
			int resultado[] = new int [n];
			for(int i=n; i>=1; i--){
				if(n%i==0 || n==i){
					resultado[largura]=i;
					largura++;
				}
			}
			int solucion[] = new int [largura];
			for(int i=0; i<largura; i++){
				solucion[i]=resultado[i];
			}
			return solucion;
		}
		//Me he asegurado de que el n�mero estaba entre 0 y 20. Una vez hecho esto, he declarado una largura para el vector, y un vector. A partir de ah�, cada vez que divid�a el n�mero por ese mismo n�mero o el resto era cero, la largura se ampliaba y se a�ad�a ese divisor al vector.
	}

	public static boolean checkIsPalindrome(String cadena) {
		int inicio = 0;
		int fin = cadena.length()-1;
		boolean Error = false;
		if(cadena==null)
			return false;
		else{
			while ((inicio<fin) || (!Error)){
				if (cadena.charAt(inicio)==cadena.charAt(fin)){				
					inicio++;
					fin--;
				}else{
					Error = true;
				}
			}
		}
		return Error;
		//He declarado dos variables de inicio y fin. Despu�s he ido recorriendo el String viendo si eran iguales los car�cteres.
	}

	public static String speakToMe(int n) {
		
		if((n<0) || (n>99)){
			throw new ArithmeticException("No es v�lido.");
		}else{
			
			String decenas="";
			String unidades="";
			String resultado="";

			switch (n){
				case 0:
					unidades="Cero";
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
				default:
					
					switch (n%10) {
					case 1:
						unidades="uno";
						break;
					case 2:
						unidades="dos";
						break;
					case 3:
						unidades="tres";
						break;
					case 4:
						unidades="cuatro";
						break;
					case 5:
						unidades="cinco";
						break;
					case 6:
						unidades="seis";
						break;
					case 7:
						unidades="siete";
						break;
					case 8:
						unidades="ocho";
						break;
					case 9:
						unidades="nueve";
						break;
					default:
						break;
					}
					switch (n/10) {
						case 1:
							decenas="Dieci";
							break;
						case 2:
							decenas="Veinti";
							break;
						case 3:
							decenas="Treinta";
							break;
						case 4:
							decenas="Cuarenta";
							break;
						case 5:
							decenas="Cincuenta";
							break;
						case 6:
							decenas="Sesenta";
							break;
						case 7:
							decenas="Setenta";
							break;
						case 8:
							decenas="Ochenta";
							break;
						case 9:
							decenas="Noventa";
							break;
						default:
							break;
						}
				break;
			}
			
			if(n/10>=1){
				if(n%10==0){
					resultado+=decenas+unidades;
				}else{
					resultado=decenas+" y "+unidades;
				}}else{
				resultado=unidades;
			}	
			return resultado;
		}
		//He consultado primero seg�n el n�mero para casos especiales, luego seg�n las decenas para la primera parte del texto, y a continuaci�n seg�n las unidades para la �ltima parte del texto. Al final le he preguntado por el n�mero, para ver si tengo que a�adir decenas o unidades al texto.
	}

	public static boolean isLeapYear(String fecha) {
		
		if(fecha.isEmpty())
			return false;
		else{
		String año=fecha;
        año = fecha.substring(6);
		int numEntero = Integer.parseInt(año);

		if ((numEntero%4 == 0) && ((numEntero%100 != 0) || (numEntero%400 == 0)))
			return true;
		else
			return false;
		}
		//Paso el String a un String en el que s�lo tengamos el a�o, y pasamos dicho String a Int. Ah� ya consultaremos mediante un If si es bisiesto o no.
	}

	public static boolean isValidDate(String date) {
		
		if (date.length() != 10)
			return false;
		else {
			Integer año, mes, dia;
			dia = Integer.parseInt(date.substring(0, 2));
			mes = Integer.parseInt(date.substring(3, 5));
			año = Integer.parseInt(date.substring(6));

			if (año != null && mes <= 12 && mes > 0 && dia > 0 && año > 0) {
				if ((mes == 4 || mes == 6 || mes == 7 || mes == 9 || mes == 11) && dia <= 30) {
					return true;
				} else {
					if ((mes == 2 && isLeapYear(date) && dia <= 29) || (mes == 2 && !(isLeapYear(date)) && dia <= 28)) {
						return true;
					} else {
						if ((mes != 2) && dia <= 31)
							return true;
						else
							return false;
					}
				}
			} else
				return false;
		}
		//
	}
}
