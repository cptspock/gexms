package interviews;

public class UniqueCharsInStringUsingBooleanArray {
	
	// Assume string using standard ASCII set (7-bit) which gives us 0-127 possible values
	// If str is UTF-8, then use array size of 256
	public boolean isUniqueChars(String str) {
		if (str.length() > 128) return false;
		boolean[] char_set = new boolean[128];
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			if (char_set[val]) return false;
			char_set[val] = true;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.print(new UniqueCharsInStringUsingBooleanArray().isUniqueChars("abbcd"));
	}

}
