package tests;

public class RemoveAdjacentDuplicates {
	
	public static String removeAdjDups2(String s){
		StringBuilder temp = new StringBuilder();
		boolean foundDup = false;
		do {
			foundDup = false;
			for (int i=0; i <= s.length() - 1; i++) {
				if (i == s.length() - 1) temp.append(s.charAt(i));
				else if (s.charAt(i) != s.charAt(i+1)) {
					temp.append(s.charAt(i));
				}
				
				else {
					i = i + 1;
					foundDup = true;
				}
					
			}
			s = temp.toString();
			temp.delete(0, temp.length());
		} while (foundDup);
		return s;
	}
	
	private static String removeAdjDups(String str){
		if ( 0 == str.length() )return "-1";
		
		char lastchar = str.charAt(0);
		int position = 0;
		int i =1;
	    for ( i = 1; i < str.length();i++){
	    	if ( lastchar == str.charAt(i)){
	    		position++;
	    		continue;
	    	}else{
	    		lastchar = str.charAt(i);
	    	}
	    	if ( position > 0){
	    		break;
	    	}
	    }
	    if ( position == 0){
	    	return str;
	    }else{
	    	return removeAdjDups(
                           str.substring(0,i-(position+1))  + str.substring(i,str.length()));
	    }
	}
	
	public static void main(String[] args) {
		System.out.println(RemoveAdjacentDuplicates.removeAdjDups("ABBBBB"));
	}
	
	

}
