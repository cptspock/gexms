package interviews;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Input:
 * "tree"
 *
 * Output:
 * "eert"
 *
 * Input:
 * "cccaaa"
 *
 * Output:
 * "cccaaa"
 * 
 * Order is not important if there are 2 characters with same count.
 */
	
public class SortCharsByFrequency {

	public String frequencySort(String s) {
		Map<Character, Integer> charMap = new HashMap<>();
		
		for (char c : s.toCharArray()) {
			charMap.put(c, charMap.getOrDefault(c, 0) + 1);
		}
		
		// create PQ using lambda which specifies to add keys in descending order of the values
		PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> charMap.get(b) - charMap.get(a));
		maxHeap.addAll(charMap.keySet());
		
		StringBuilder result = new StringBuilder();
		while (!maxHeap.isEmpty()) {
			char current = maxHeap.remove();
			for (int i = 0; i < charMap.get(current); i++) {
				result.append(current);
			}
		}
		return result.toString();
		
	}
	public static void main(String[] args) {
		System.out.println(new SortCharsByFrequency().frequencySort("treetree"));
	}

}
