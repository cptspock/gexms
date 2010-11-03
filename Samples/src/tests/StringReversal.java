package tests;

public class StringReversal {
	public String reverse(String str) {
        if (null == str) throw new IllegalArgumentException("invalid argument: use another argument");        	
        	
        if (str.length() <= 1) {
            return str;
        }        
        return reverse(str.substring(1)) + str.charAt(0);
    }
	
	public static void main(String[] args){
		StringReversal sr = new StringReversal();
		System.out.println(sr.reverse(null));
	}
}