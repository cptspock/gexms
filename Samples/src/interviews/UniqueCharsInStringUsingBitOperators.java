package interviews;

public class UniqueCharsInStringUsingBitOperators {
	public boolean isUniqueChars(String str) {
		// assuming string is in ascii 128 format (7-bit). Hence we need 2 checker variables each of 64 bit so we can cover 128 unique values.
		// if string is UTF-8, then use 4 checker variables to cover 256 unique values.
		long checker1 = 0;
		long checker2 = 0;

		for (int i = 0; i < str.length(); i++) {
			int bitIndex = str.charAt(i);
			int toCheck = bitIndex / 64;
			bitIndex %= 64;

			switch (toCheck) {
			case 0:
				if ((checker1 & (1 << bitIndex)) > 0) {
					return false;
				}
				checker1 |= 1 << bitIndex;
				break;

			case 1:
				if ((checker2 & (1 << bitIndex)) > 0) {
					return false;
				}
				checker2 |= 1 << bitIndex;
				break;
			}
		}
		return true;

	}

	public static void main(String[] args) {
		System.out.println(new UniqueCharsInStringUsingBitOperators().isUniqueChars("abcd%asld%"));
	}

}
