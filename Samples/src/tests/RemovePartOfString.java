package tests;

import java.util.HashMap;
import java.util.Map;

public class RemovePartOfString {
	
	public String removeCharacters(String s, String t) {
	    long start = System.nanoTime();
		boolean[] toRemove = new boolean[s.length()];
		/*for (int i=0; i < s.length(); i++) {
			toRemove[i] = false;
		}*/
		StringBuilder result = new StringBuilder();
		for (int i=0; i < s.length(); i++) {
			if (!t.contains(String.valueOf(s.charAt(i)))){
				//toRemove[i] = true;
				result.append(s.charAt(i));
				
			}
		}
		//StringBuilder result = new StringBuilder();
		/*for (int i=0; i < s.length(); i++) {
			if (toRemove[i] == false) {
				result.append(s.charAt(i));
			}
		}*/
		
		//System.out.println(System.currentTimeMillis() - startTime);
		System.out.println(System.nanoTime() - start);
		return result.toString();
	}
	
	public String removeCharacters2(String s, String t) {
	    long start = System.nanoTime();
		Map<Character, Integer> map = new HashMap<>();
		for (int i =0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
			}
			else {
				map.put(s.charAt(i), 1);
			}
		}
		
		for (int i=0; i < t.length(); i++) {
			if (map.get(t.charAt(i)) != null) {
				map.put(t.charAt(i), 0);
			}
		}
		StringBuilder result = new StringBuilder();
		for (int i=0; i < s.length(); i++) {
			if (map.get(s.charAt(i)) > 0) {
				result.append(s.charAt(i));
			}
		}
		System.out.println(System.nanoTime() - start);
		return result.toString();
	}

	public static void main(String[] args) {
		System.out.println(new RemovePartOfString().removeCharacters("Battle of the Vowels: Hawaii vs. Grozny", "aeiou"));
		System.out.println(new RemovePartOfString().removeCharacters2("Battle of the Vowels: Hawaii vs. Grozny", "aeiou"));
	}

}
