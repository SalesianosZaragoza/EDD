import org.apache.commons.lang3.StringUtils;

public class TestCommons {

	public static void main(String[] args) {
		String text = "   Mi cadena de texto  ";
		String upperCase = StringUtils.upperCase(text);
		String trim = StringUtils.trim(text);
		String lowerCaseThenTrim = StringUtils.trim(StringUtils.lowerCase(text)).concat("concatenada");
		System.out.println("Cadena inicial");
		System.out.println(text);
		System.out.println("Cadena en mayusculas");
		System.out.println(upperCase);
		System.out.println("Cadena sin espacios");
		System.out.println(trim);
		System.out.println("Cadena sin espacios y en minusculas");
		System.out.println(lowerCaseThenTrim);

	}

}
