package tests;

/* Java does manipulate objects by reference, and all object variables are references. However, Java 
 doesn't pass method arguments by reference; it passes them by value.

 Java copies and passes the reference by value, not the object. Thus, method manipulation will alter 
 the objects, since the references point to the original objects. But since the references are copies, 
 swaps will fail. 

 As Figure 2 illustrates, the method references swap, but not the original references. 
 Unfortunately, after a method call, you are left with only the unswapped original references. 
 For a swap to succeed outside of the method call, we need to swap the original references, not the copies.
 */

public class PassByReference {

	public void swap(Point arg1, Point arg2) {
		/*
		 * arg1.x = 100; arg1.y = 100;
		 */
		/*
		 * Point temp = arg1; arg1 = arg2; arg2 = temp;
		 */
		Point temp = new Point();
		/*temp.x = arg1.x;
		temp.y = arg1.y;
		arg1.x = arg2.x;
		arg1.y = arg2.y;

		arg2.x = temp.x;
		arg2.y = temp.y;*/
		

	}

	public static void main(String[] args) {
		PassByReference p = new PassByReference();
		Point p1 = new Point();
		p1.x = 10;
		p1.y = 10;

		Point p2 = new Point();
		p2.x = 20;
		p2.y = 20;

		p.swap(p1, p2);
		System.out.println("p1.x= " + p1.x + "   p1.y= " + p1.y);
		System.out.println("p2.x= " + p2.x + "   p2.y= " + p2.y);
	}
}

class Point {
	int x;
	int y;
}
