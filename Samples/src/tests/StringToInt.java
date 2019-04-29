package tests;

public class StringToInt {

    /**
     * @param args
     */
    public static void main(String[] args) {        
        char i = '9';
        System.out.println(i-'0');
        
        int j = 0;
        System.out.println(j+"0");
        
        long n = 70265765765758765L;
        System.out.println(new StringToInt().intToString(n));
        
        String s = "-99";
        System.out.println(new StringToInt().stringToInt(s));
    }
    
    public String intToString(long n) {
    	char[] temp = new char[50];
    	int i = 0;
    	while (n != 0) {
    		temp[i++] = (char)(n % 10 + '0');
    		n/=10;
    	}
    	
    	StringBuilder result = new StringBuilder();
    	while (i > 0) 
    		result.append(temp[--i]);
    	return result.toString();
    }
    
    public long stringToInt(String s) {
    	long result = 0;
    	for (int i = 0; i < s.length(); i++) {
    		result = result*10 + (s.charAt(i) - '0');
    	}
    	return result;
    }
}
