package tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GenericsTest {

	public static <T extends Object & Comparable<? super T>> T max(
			List<? extends T> list, int begin, int end) {

		T maxElem = list.get(begin);

		for (++begin; begin < end; ++begin)
			if (maxElem.compareTo(list.get(begin)) < 0)
				maxElem = list.get(begin);
		return maxElem;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(4);
        list.add(3);
        list.add(10);
        list.add(25);
        System.out.println(GenericsTest.max(list, 0, 5));
        
        //copying list of one type to another type: ints(Integer) to objs(Object)
        List<Object> objs = Arrays.<Object>asList(2, 3.14, "four");
        List<Integer> ints = Arrays.asList(5, 6);
        Collections.copy(objs, ints);
        assert objs.toString().equals("[5, 6, four]");
        
        //sort
        Collections.sort(list);
        
        
        List<Number> objs2 = Arrays.<Number>asList(1,2);
        List<? super Integer> ints2 = objs2;
        String str = "";
        for (Object obj : ints2) str += obj.toString();
        assert str.equals("12");
        System.out.println(str);
        
        
        Integer[] ints3 = new Integer[] {1,2,3};
        Number[] nums = ints3;
        nums[2] = 3.14;
        
        
	}
}
