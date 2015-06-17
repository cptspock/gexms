package tests;

public class FindNumOfOnesBinary {
	public static int getNumOnes(int val) {
		int count = 0;
		if (val <= 0)
			return count;
		else {
			int mask = 0x0001;

			while (val != 0) {
				int c = mask & val;
				{
					if (c == 1)
						count++;
					val = val >>> 1;
				}

			}
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(FindNumOfOnesBinary.getNumOnes(255));

	}

}
