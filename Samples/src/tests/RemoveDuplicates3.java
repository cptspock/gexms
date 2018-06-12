package tests;

public class RemoveDuplicates3 {

	public static char[] removeDuplicates(String s) {

		if (s == null)
			return null;
		char[] str = s.toCharArray();
		int len = str.length;
		if (len < 2)
			return str;

		int tail = 1;

		for (int i = 1; i < len; ++i) {
			int j;
			for (j = 0; j < tail; ++j) {
				if (str[i] == str[j])
					break;
			}
			if (j == tail) {
				str[tail] = str[i];
				++tail;
			}
		}
		
		if (tail < len)
			str[tail] = 0;
		return str;
	}
	
	public static char[] removeDuplicates2(String s){
		char[] arr = s.toCharArray();
	    int end = arr.length;

	    for (int i = 0; i < end; i++) {
	        for (int j = i + 1; j < end; j++) {
	            if (arr[i] == arr[j]) {                  
	                arr[j] = arr[end-1];
	                end--;
	                j--;
	            }
	        }
	    }
	    
	    if (end < arr.length) {
	    	for (int i = end; i < arr.length; i++){
	    		arr[i] = 0;
	    	}
	    }
	    return arr;
	}
	
	public static char[] removeDuplicates3(String s){
		char[] arr = s.toCharArray();
	    int end = arr.length;

	    for (int i = 0; i < end; i++) {
	        for (int j = i + 1; j < end; j++) {
	            if (arr[i] == arr[j]) {                  
	            	for (int k = j + 1; k < end; k++) {
	            		int n = j + 1;
	            		arr[j] = arr[k];
	            		n++;
	            	}
	            		   
	                end--;
	                j--;
	            }
	        }
	    }
	    
	    if (end < arr.length) {
	    	for (int i= end; i<arr.length; i++){
	    		arr[i] = 0;
	    	}
	    		
	    }

	    //char[] whitelist = new char[end];
	    /*for(int i = 0; i < end; i++){
	        whitelist[i] = arr[i];
	    }*/
	    //System.arraycopy(arr, 0, whitelist, 0, end);
	    return arr;
	}

	public static void main(String[] args) {
		char[] result = RemoveDuplicates3.removeDuplicates2("aaaaa");

		for (char c : result) {
			System.out.print(c);
		}
	}
}