package tests;

/**
  * string reversal in place- without using a temp string variable
  * recursive algo is sleeker imo.
  */
public class StringReversalTwo {
	
	public static void main(String[] args){
		
		char[] s = {'a', 'b','c','d','e'};
		int firstpos = 0;
		int lastpos = s.length -1;
		
		while (firstpos < lastpos){
			char temp = s[firstpos];
			s[firstpos] = s[lastpos];
			s[lastpos] = temp;
			//s = s.replace(s.charAt(firstpos), s.charAt(lastpos));
			//s = s.replace(s.charAt(lastpos), temp);
			firstpos++;
			lastpos--;				
		}		
		System.out.println(s);
	}
}


