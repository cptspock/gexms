package tests;

public class Palindrome {

	public boolean isPalindrome(String pal) {
		pal = pal.replaceAll("[^a-zA-Z]", "");
		int j = pal.length() - 1;
		int i = 0;
		while (i < j)
			if (!(pal.charAt(i++) == pal.charAt(j--))) {
				return false;
			}
			else {
				continue;
			}
		return true;
	}
	
	public static void main(String[] args) {
		//String pal = "Avid.. diva.#''@$";
		//String pal = "ana";
		String pal = "asdkjfhas";
		System.out.println(new Palindrome().isPalindrome(pal.toLowerCase()));
	}

}
