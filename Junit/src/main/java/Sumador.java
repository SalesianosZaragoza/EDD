
public class Sumador {
	/*
	 * este metodo suma tres numeros
	 */
	public int sumar(Integer n1, Integer n2, Integer n3) {
		if (null == n1 || null == n2 || null == n3) {
			return 0;
		}
		return n1 + n2 + n3;
	}
}
