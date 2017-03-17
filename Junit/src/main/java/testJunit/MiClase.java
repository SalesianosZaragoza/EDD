package testJunit;

import javax.swing.JFrame;

public class MiClase extends JFrame {

	public MiClase() {
		super();
		setTitle("miventa");
		setVisible(true);
	}

	public int sumTwoNumbers(int n1, int n2) {
		return n1 + n2;
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

	public int sumTwoNumbers4(Integer n1, Integer n2) throws Exception {
		return n1 + n2;
	}



}
