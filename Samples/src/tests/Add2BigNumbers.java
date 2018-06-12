package tests;

import java.math.BigInteger;

public class Add2BigNumbers {
	public static String add(String addend1, String addend2) {
		int carry = 0;
	    StringBuilder buf = new StringBuilder();
	    for ( int i1 = addend1.length() - 1, i2 = addend2.length() - 1;
	          i1 >= 0 || i2 >= 0 || carry != 0;
	          i1--, i2-- ) {
	        int digit1 = i1 < 0 ? 0 :
	                     Integer.parseInt(Character.toString(addend1.charAt(i1))); // convert Character to Integer
	        int digit2 = i2 < 0 ? 0 :
	                     Integer.parseInt(Character.toString(addend2.charAt(i2)));

	        int digit = digit1 + digit2 + carry;
	        if (digit > 9) {
	            carry = 1;
	            digit -= 10;
	        } else {
	            carry = 0;
	        }

	        buf.append(digit);
	    }
	    return buf.reverse().toString();
	}
	
	public static void main(String[] args) {
		String s1 = "7654729850328997631007285998163550104";
        String s2 = "980139243970186632651869926335829102";
		//String s1 = "55";
		//String s2 = "20";
			
        BigInteger a1 = new BigInteger("7654729850328997631007285998163550104");
        BigInteger a2 = new BigInteger("980139243970186632651869926335829102");
        
        System.out.println(a1.add(a2));
        
        System.out.println(add(s1, s2));
	

	}

}
