import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class WorkWithStrings {

	public static String reverseEveryWordOnASentenceWhitForLoops(String text) {
		String[] splitStrings = text.split(" ");
		String reverse = "";
		for (int i = 0; i < splitStrings.length; i++) {
			if (i != 0)
				reverse += " ";
			for (int j = splitStrings[i].length() - 1; j >= 0; j--) {
				reverse += splitStrings[i].charAt(j);
			}
		}
		return reverse;
	}

	public static String reverseEveryWordOnASentence(String text) {
		String[] splittedSentence = StringUtils.split(text, ' ');
		String[] reversedWords = new String[splittedSentence.length];
		for (int i = 0; i < splittedSentence.length; i++) {
			String word = splittedSentence[i];
			reversedWords[i] = StringUtils.reverse(word);
		}
		return StringUtils.join(reversedWords, ' ');
	}


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

		System.out.println(reverseEveryWordOnASentence(text));
		System.out.println(reverseEveryWordOnASentenceWhitForLoops(text));

		System.out.println(reverseWordsWithCollections(text));
		System.out.println(reverseWordsInOneCodeLine(text));
		System.out.println(reverseRecursive(text));
	}
}
