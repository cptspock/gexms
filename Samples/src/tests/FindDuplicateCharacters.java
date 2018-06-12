package tests;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * Very important example due to Hashmap 
 * @author ace
 *
 */
public class FindDuplicateCharacters{

    public static void main(String args[]) {
        printDuplicateCharacters("Programming in java");
        printDuplicateCharacters("Combination");
        printDuplicateCharacters("Java");
        System.out.println(removeDuplicates2("Programming in java"));
        
    }

    /*
     * Find all duplicate characters in a String and print each of them.
     */
    public static void printDuplicateCharacters(String word) {
        char[] characters = word.toCharArray();

        // build HashMap with character and number of times they appear in String
        Map<Character, Integer> charMap = new HashMap<>();
        for (Character ch : characters) {
            if (charMap.containsKey(ch) && !Character.isWhitespace(ch)) {
                charMap.put(ch, charMap.get(ch) + 1);
            } else {
                charMap.put(ch, 1);
            }
        }
        
        for (Character key : charMap.keySet()) {
        	if ((charMap.get(key)) > 1) {
        		System.out.println("duplicate character: " + key);
        	}
        }
        for (int i : charMap.values()) {
        	
        }
        // Iterate through HashMap to print all duplicate characters of String
        Set<Map.Entry<Character, Integer>> entrySet = charMap.entrySet();
        System.out.printf("List of duplicate characters in String '%s' %n", word);
        for (Map.Entry<Character, Integer> entry : entrySet) {
            if (entry.getValue() > 1) {
                System.out.printf("%s : %d %n", entry.getKey(), entry.getValue());
            }
        }
    }
    
    public static String removeDuplicates2(String word) { 
    	char[] characters = word.toCharArray();
    	
    	Set<Character> result = new LinkedHashSet<Character>();
    	for (int i=0; i < word.length(); i++) {
    		result.add(characters[i]);
    	}
    	
    	StringBuilder s = new StringBuilder();
    	for (Character c : result) {
    		s.append(c);
    	}
    	return s.toString();
    }
    
    // very elegant solution provided indexOf(char) is allowed
    public static String removeDuplicates(String inputStr){
		StringBuilder strBuilder = new StringBuilder();
		for(char val : inputStr.toCharArray()){
			if(strBuilder.toString().indexOf(val) < 0){
				strBuilder.append(val);
			}
		}
		return strBuilder.toString();
	}

}