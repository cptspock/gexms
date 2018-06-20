package tests;

/*
 * "hello world"
 * i=0, j=0,k=0
 * k = 6
 * j = 4
 * 
 */
public class ReverseWordsInString3 {

	public static String reverseWords(String str) {
		int i = 0, j = str.length() -1, k = 0;
		char temp;
		char[] s = str.toCharArray();
		
		while (i < j) {
			temp = s[i];
			s[i] = s[j];
			s[j] = temp;
			i++;j--;
		}
		i = 0; j = 0;
		while (j < s.length) {
			while (j < s.length && s[j] != ' ') {
				j++;
			}
			k = j + 1;
			j = j - 1;
			
			while (i < j) {
				temp = s[i];
				s[i] = s[j];
				s[j] = temp;
				i++;j--;
			}
			i = k;
			j = i+1;
		}
		
		return String.valueOf(s);
	}
	
	public static void reverseString(char[] c, int i, int j) {
		char temp;
		while (i < j) {
			temp = c[i];
			c[i] = c[j];
			c[j] = temp;
			i++;j--;
		}
	}
	public static void main(String[] args) {
		System.out.println(ReverseWordsInString3.reverseWords("This is a  scam")); // dlrow olleh

	}

}
