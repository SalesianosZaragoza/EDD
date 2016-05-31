import java.util.ArrayList;

public class Cola<E> {

	ArrayList<E> lista;

	public Cola() {
		lista = new ArrayList<E>();
	}

	public void encolar(E dato) {
		lista.add(dato);
	}

	public E desencolar() throws ColaVaciaException {
		if (lista.size() > 0) {
			return lista.remove(0);
		} else {
				throw new ColaVaciaException();
		}
	}

	public int numElementos() {
		return lista.size();
	}

}