package tests;

import java.util.Set;
import java.util.TreeSet;

public class SetTest {
	public static void main(String[] args) {
		Set<String> set1 = new TreeSet<>();
		set1.add("Bob");
		set1.add("Adam");
		set1.add("Ajay");
		
		for (String s : set1) {
			System.out.println(s);
		}
	}

}
