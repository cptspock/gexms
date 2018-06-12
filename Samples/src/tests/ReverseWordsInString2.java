package tests;

import java.util.StringTokenizer;

public class ReverseWordsInString2 {

	public String reverseWords(String sentence) {
		if ((sentence != null) && (!sentence.equals(""))) {
			StringTokenizer tokenizer = new StringTokenizer(sentence, " ");
			String temp = null;
			sentence = "";
			while (tokenizer.hasMoreTokens()) {
				temp = tokenizer.nextToken();
				sentence = sentence.concat(reverse(temp)).concat(" ");
			}
		}
		return sentence;
	}

	public static void main(String[] args) {
		System.out.println(new ReverseWordsInString2().reverseWords("This is a test for reversing"));
	}

	private String reverse(String s) {
		char[] temp = s.toCharArray();
		char c;
		for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
			c = temp[i];
			temp[i] = temp[j];
			temp[j] = c;
		}
		s = String.valueOf(temp);
		return s;
	}
}
