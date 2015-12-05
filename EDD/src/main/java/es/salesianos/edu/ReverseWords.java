package es.salesianos.edu;

import org.apache.commons.lang3.StringUtils;

public class ReverseWords {

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




	public static void main(String[] args) {
		String text = "Esta casa es una ruina";

		System.out.println(reverseEveryWordOnASentence(text));
		System.out.println(reverseEveryWordOnASentenceWhitForLoops(text));

	}
}
