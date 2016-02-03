package es.salesianos.edu;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class ReverseSentences {

	public static String reverseRecursive(String str) {
		char charArray[] = str.toCharArray();
		for (int i = 0; i < str.length(); i++) {
			if (charArray[i] == ' ')
				return reverseRecursive(str.substring(i + 1)) + str.substring(0, i) + " ";
		}
		return str + " ";
	}

	public static String reverseWordsInOneCodeLine(String input) {
		return StringUtils.reverseDelimited(input, ' ');
	}

	public static String reverseWordsWithCollections(String input) {
		String[] splitted = input.split(" ");
		List<String> list = Arrays.asList(splitted);
		Collections.reverse(list);
		return String.join(" ", list);
	}

	public static void main(String[] args) {
		String text = "Esta casa es una ruina";

		System.out.println(reverseWordsWithCollections(text));
		System.out.println(reverseWordsInOneCodeLine(text));
		System.out.println(reverseRecursive(text));
	}

	public static void hola1() {
	}

	public static void hola2() {
	}

}
