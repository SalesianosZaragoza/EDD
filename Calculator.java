package fp;
import java.util.ArrayList;
import java.util.List;

public class Calculator {

 	public static Class classTypeOf(Object x) {
		return x.getClass();
 	}
 	
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
 	public static boolean checkIsPalindrome(String cadena) {


		String letrasSustiruir[] = { "[á]", "[é]", "[í]", "[ó]", "[ú]" };
		String letrasCambiadas[] = { "a", "e", "i", "o", "u" };
				
		if (cadena == null)
			return false;
		else {
			for (int i = 0; i < letrasCambiadas.length; i++) 
				cadena = cadena.replaceAll(letrasSustiruir[i], letrasCambiadas[i]);

			cadena = cadena.toLowerCase().replaceAll("//vocales", ""); 

			int numeroCadena = cadena.length();

			for (int i = 0; i < (numeroCadena / 2); i++) {
				if (cadena.charAt(i) != cadena.charAt(numeroCadena - i - 1)) 
																				
					return false;	
			}
			return true;
		}
		 

	} 
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
}

