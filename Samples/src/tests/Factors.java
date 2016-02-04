package tests;

import java.util.Set;
import java.util.TreeSet;

public class Factors {
	public static void main(String[] args) {
		Factors s = new Factors();
		int[] result = s.getFactors(18);
		for (int i = 0; i < result.length; i++)
			System.out.println(result[i]);
	}

	public int[] getFactors(int n) {
		int[] result = new int[(int) Math.sqrt(n) * 2];
		int j = 0;
		for (int i = 1; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				result[j++] = n / i;
				result[j++] = i;
			}
		}
		int count = 0;
		for (int i = 0; i < result.length; i++) {
			if (result[i] != 0) {
				count++;
			}
		}

		int[] finalresult = new int[count];
		for (int i = 0; i < result.length; i++) {
			if (result[i] != 0)
				finalresult[i] = result[i];
		}
		return finalresult;
	}

	public Set<Integer> getFactors2(int number) {
		int[] result = new int[number];
		int j = 0;
		result[j++] = 1;
		int div = 0;
		int mod = 0;

		Set<Integer> temp = new TreeSet();
		for (int i = 2; i <= number / 2; i++) {
			div = number / i;
			mod = number % i;
			if (mod == 0 && (!temp.contains(i)) && (!temp.contains(div))) {
				result[j++] = div;
				result[j++] = i;
			}
			for (int k = 0; k < result.length; k++) {
				temp.add(result[i]);
			}
		}
		result[j] = number;
		return temp;
	}
}