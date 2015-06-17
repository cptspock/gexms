package tests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindAstrix {
	public static void main(String[] args) {
		int a, b;
		String s, s1, s2, s3, s4;
		BufferedReader input = new BufferedReader(new InputStreamReader(
				System.in));
		// InputStreamReader isr = new InputStreamReader(input);
		System.out
				.println("Enter the 1st string with * in the string at any position");
		try {
			s = input.readLine();

			System.out
					.println("Enter the 2st string with * in the string at any position");

			s1 = input.readLine();

			a = s.indexOf('*');
			b = s1.indexOf('*');
			System.out.println("index of string 1 is at " + a);
			System.out.println("index of string 2 is at:" + b);

			if (a != b)
				System.out.println("not possible");
			else {

				s2 = s.substring(0, +a);
				s3 = s1.substring(0, +b);
				System.out.println(s2);
				System.out.println(s3);

				s4 = s2.concat(s3);

				System.out.println(s4);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*
		 * String A = "*EXAMPLETEST", B = "THIRDEXAMPLE*"; int indexOfA =
		 * A.indexOf('*'), indexOfB = B.indexOf('*'); if (A.length() !=
		 * B.length() || indexOfA == -1 || indexOfB == -1 || indexOfA ==
		 * indexOfB) { System.out.println("NOT-POSSIBLE"); } else if (indexOfA >
		 * indexOfB) { System.out.println(_findMissingChar(A, B)); } else if
		 * (indexOfA < indexOfB) { System.out.println(_findMissingChar(B, A)); }
		 */
	}

	private static String _findMissingChar(String str1, String str2) {
		String[] parts = str1.split("\\*");
		int index = str2.indexOf(parts[0]);
		if (index >= 0) {
			return parts[0] + str2.charAt(index + 1) + parts[1];
		} else {
			index = str2.indexOf(parts[1]);
			return parts[0] + str2.charAt(index - 1) + parts[1];
		}
	}
}
