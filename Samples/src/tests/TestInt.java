package tests;

public class TestInt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = Integer.MAX_VALUE;
		int j = Integer.MAX_VALUE;
		int k = (i+j)/2; //this gives -1 since it overflows hence use i/2 +j/2
		
		System.out.println(k);

	}

}
