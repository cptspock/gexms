package generics;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListDuplicates {

	public static void main(String[] args) throws NoSuchFieldException,
			SecurityException, IllegalArgumentException, IllegalAccessException {
		List<Integer> numbers = new CopyOnWriteArrayList<>();
		numbers.add(5);
		numbers.add(55);
		numbers.add(50);
		numbers.add(100);
		numbers.add(44);

		for (Integer num : numbers) {
			if (Collections.frequency(numbers, num) > 1) {
				System.out.println("list contains dups");
				break;
			}
		}
		System.out.println("list does not contain dups");

		ListIterator li = numbers.listIterator();

		StringBuffer s = new StringBuffer("abcdefghijklmno");
		s.substring(4, 8);

		Field innerCharArray = String.class.getDeclaredField("value");
		innerCharArray.setAccessible(true);

		char[] chars = (char[]) innerCharArray.get(s.toString());
		System.out.println(Arrays.toString(chars));

		String a = "test";
		String b = "test";
		
		"test".toUpperCase();
		System.out.println("a= " +a);
		System.out.println("b= " +b);

	}

}
