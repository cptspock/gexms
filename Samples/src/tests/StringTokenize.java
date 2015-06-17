package tests;

import java.util.StringTokenizer;

public class StringTokenize {
	
	public static void main(String[] args) {
		String s = "hi, welcome to salesforce. Be happy at work.";
		StringTokenizer st = new StringTokenizer(s, " ");
		String result = null;
		int count =0;
		while (st.hasMoreTokens()) {
			result = st.nextToken();
			count++;
		}
		System.out.print(count);
	}

}
