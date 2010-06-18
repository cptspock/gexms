package tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListTest {
	
	public static void main(String argsp[]) {
		List<Integer> newList = new ArrayList<Integer>();
		newList.add(new Integer(100));
		newList.add(new Integer(10));
		Collections.reverse(newList);
		
		for (Integer i : newList){
			System.out.println(i);
		}
	}

}
