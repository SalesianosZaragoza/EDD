package testJunit;

import javax.swing.JFrame;

public class MiClase extends JFrame {

	public MiClase() {
		super();
		setTitle("mi_ventana");
		setVisible(true);
	}

	public int sumTwoNumbers(int n1, int n2) {
		return n1 + n2;
	}

	public void otrometodo() {
		sumTwoNumbers(5, 6);
	}

	public int sumTwoNumbers2(Integer n1, Integer n2) throws Exception {
		if (null == n1 || null == n2) {
			throw new Exception();
		}

		return n1 + n2;
	}

	public int sumTwoNumbers3(Integer n1, Integer n2) {
		return n1 + n2;
	}

	public int sumTwoNumbersIfTheyNotZero(Integer n1, Integer n2) throws Exception {
		if (n1 == 0 || n2 == 0) {
			throw new Exception("no puedo sumar con numeros de cero");
		}
		return n1 + n2;
	}



}
