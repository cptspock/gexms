package tests;

public class ReverseWordsInString {

	public static String reverseWordByWord(String str){
        int strLeng = str.length()-1;
        String reverse = "", temp = "";

        for(int i = 0; i <= strLeng; i++){
            temp += str.charAt(i);
            if((str.charAt(i) == ' ') || (i == strLeng)){
                for(int j = temp.length()-1; j >= 0; j--){
                    reverse += temp.charAt(j);
                    if((j == 0) && (i == strLeng)) 
                        reverse += " ";
                }
                temp = "";
            }
        }

        return reverse;
    }
	
	public static void main(String[] args) {
		System.out.println(ReverseWordsInString.reverseWordByWord("hello brave new world"));
	}
}
