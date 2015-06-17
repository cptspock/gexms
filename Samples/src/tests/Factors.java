package tests;

import java.util.Set;
import java.util.TreeSet;

public class Factors {
	public static void main(String[] args) {
		Factors s = new Factors();
		 s.getFactors(18);
		/*for (Integer a : result) {
			System.out.print(a + " ");
		}*/

	}
	
	public void getFactors(int n){
		int[] result =new int[n];
		int j = 0;
		for(int i = 1; i <= Math.sqrt(n); i++){
			if(n % i == 0){
				//System.out.println(""+(n/i)+"*"+i);
				System.out.print((n/i) + " " +i + " ");
				result[j++] = n/i;
				result[j++] = i;
			}
		}
		for (int i = 0; i < result.length; i++)
			System.out.print(result[i] + " ");
	}

	public Set<Integer> getFactors2(int number) {
		int[] result = new int[number];
		int j = 0;
		result[j++] = 1;
		int div = 0;
		int mod = 0;
		Set<Integer> temp = new TreeSet();
		for (int i = 2; i <= number / 2; i++) {
			div = number/i;
			mod = number % i;
			
			
			if (mod == 0 && (!temp.contains(i)) && (!temp.contains(div))) {
				
				result[j++] = div;
				result[j++] = i;
			}
			for (int k=0; k < result.length; k++) {
				temp.add(result[i]);
			}

		}
		result[j] = number;

		return temp;

	}
}
