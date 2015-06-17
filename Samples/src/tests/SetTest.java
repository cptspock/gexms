package tests;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.TreeSet;

/**
 * HashSet - order is uncertain while iterating
 * LinkedHashSet - order is same as insertion order
 * TreeSet - elements are sorted always
 * @author ace
 *
 */
class Dog implements Comparable<Dog>{
	int size;
 
	public Dog(int s) {
		size = s;
	}
 
	public String toString() {
		return size + "";
	}
 
	@Override
	public int compareTo(Dog o) {
	        return size - o.size;
	}
}

public class SetTest {
	public static void main(String[] args) {
		LinkedHashSet<String> set1 = new LinkedHashSet<String>();
		set1.add("Bob");
		set1.add("Adam");
		set1.add("Ajay"); 
		Iterator<String> iterator = set1.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
			
		/*LinkedHashSet<Dog> dset = new LinkedHashSet<Dog>();
		dset.add(new Dog(2));
		dset.add(new Dog(1));
		dset.add(new Dog(3));
		dset.add(new Dog(5));
		dset.add(new Dog(4));
		Iterator<Dog> iterator2 = dset.iterator();
		while (iterator2.hasNext()) {
			System.out.print(iterator2.next() + " ");
		}*/
		
		Random r = new Random();
		 
		HashSet<Dog> hashSet = new HashSet<Dog>();
		TreeSet<Dog> treeSet = new TreeSet<Dog>();
		LinkedHashSet<Dog> linkedSet = new LinkedHashSet<Dog>();
	 
		// start time
		long startTime = System.nanoTime();
	 
		for (int i = 0; i < 1000; i++) {
			int x = r.nextInt(1000 - 10) + 10;
			hashSet.add(new Dog(x));
		}
		// end time
		long endTime = System.nanoTime();
		long duration = endTime - startTime;
		System.out.println("HashSet: " + duration);
	 
		// start time
		startTime = System.nanoTime();
		for (int i = 0; i < 1000; i++) {
			int x = r.nextInt(1000 - 10) + 10;
			treeSet.add(new Dog(x));
		}
		// end time
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("TreeSet: " + duration);
	 
		// start time
		startTime = System.nanoTime();
		for (int i = 0; i < 1000; i++) {
			int x = r.nextInt(1000 - 10) + 10;
			linkedSet.add(new Dog(x));
		}
		// end time
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("LinkedHashSet: " + duration);
		
	}

}
