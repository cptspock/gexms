package tests;

public class Palindrome {

	public boolean isPalindrome(String pal) {
		int j = pal.length() - 1;
		int i = 0;
		while (i < j)
			if (pal.charAt(i++) == pal.charAt(j)) {
				j--;
			}
			else {
				return false;

			}
			
		return true;
	}
	
	public static void main(String[] args) {
		String pal = "level";
		System.out.println(new Palindrome().isPalindrome(pal));
		
	}

}
