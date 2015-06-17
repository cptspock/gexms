package tests;

public class StringToInt {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        char i = '9';
        System.out.println(i-'0');
        
        int j = 9;
        System.out.println((char)(j+'0'));
        
        int n = 702;
        System.out.println(new StringToInt().intToString(n));
        
        String s = "094";
        System.out.print(new StringToInt().stringToInt(s));

    }
    
    public String intToString(int n) {
    	char[] temp = new char[10];
    	int i=0;
    	while (n != 0) {
    		temp[i++] = (char)((n % 10) + '0');
    		n = n/10;
    		
    	}
    	
    	StringBuilder result = new StringBuilder();
    	while (i>0) 
    		result.append(temp[--i]);
    	 
    	return result.toString();
    }
    
    public int stringToInt(String s) {
    	int result = 0;
    	for (int i = 0; i < s.length(); i++) {
    		result = result*10 + (s.charAt(i) - '0');
    	}
    	return result;
    }

}
