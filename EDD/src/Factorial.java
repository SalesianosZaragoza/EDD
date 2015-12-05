

public class Factorial {

	public static void main(String[] args) {
		double resultado = factorialRecursivo(20);
		System.out.println("Mi factorial es "+resultado);
	}
	
	// Método Java no recursivo para calcular el factorial de un número
	public static double factorialIterativo(int n){
	    double fact=1;
	    int i;
	    if (n==0){
	        fact=1;
	    }else{
	    	for(i=1;i<=n;i++){
	    		fact=fact*i;
	    		System.out.println(fact);
	    	}
	    }
	 return fact;
	}
	
	// Método Java recursivo para calcular el factorial de un número
	public static double factorialRecursivo(int n){
	    if (n==0){
	        return 1;
	    }else{
	    	System.out.println("Factorial en la llamada "+n);
	    	return n*(factorialRecursivo(n-1));
	    }
	}
	
}
