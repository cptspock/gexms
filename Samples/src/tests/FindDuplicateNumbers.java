package tests;

import java.util.HashMap;
import java.util.Map;

public class FindDuplicateNumbers {
	
	public int[] findDuplicates(int[] arr) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i= 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i]) + 1);
			}
			else {
				map.put(arr[i], 1);
			}
		}
		
		int [] output = new int[map.entrySet().size()];
		int j = 0;
		/*for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			output[j++] = entry.getKey();
			if (entry.getValue() > 1) {
				System.out.println(entry.getKey() + " has " + entry.getValue() + " duplicates");
			}
		}*/
		for (Integer key : map.keySet()) {
			if (map.get(key) > 1)
				System.out.println(key + " has " + map.get(key) + " duplicates");
		}
		return output;
	}

	public static void main(String[] args) {
		int[] input = {5, 7, 2, 5, 10, 2, 7, 20, 6, 54, 5};
		int[] output = new FindDuplicateNumbers().findDuplicates(input);
		for (int i=0; i < output.length; i++)
			System.out.println(output[i]);
	}

}
