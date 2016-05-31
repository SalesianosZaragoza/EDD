import java.util.ArrayList;
import java.util.List;

public class CastingMain {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		String texto = "hola mundo";
		Integer entero = 10;
		Double doble = 20.0;
		list.add(texto);
		// list.add(entero);
		// list.add(doble);
		String string = list.get(0);
		try {
			throw new ColaVaciaException();
		} catch (ColaVaciaException e) {

		}
	}


}
