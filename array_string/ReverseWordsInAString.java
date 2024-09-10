package array_string;

public class ReverseWordsInAString {
    class Solution {
        public String reverseWords(String s) {
            int end = s.length();
            StringBuilder reversedString = new StringBuilder();
    
            for(int i=s.length()-1; i>=0; i--){
                if(s.charAt(i) == ' '){
                    end = i;
                }else if(i == 0 || s.charAt(i-1) == ' '){
                    if(reversedString.length() > 0){
                        reversedString.append(' ');
                    }
                    reversedString.append(s.substring(i, end));
                }
            }
            return reversedString.toString();
        }
    }
}
