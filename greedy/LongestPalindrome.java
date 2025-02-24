package greedy;

public class LongestPalindrome {
    class Solution {
        public int longestPalindrome(String s) {
            int maxLength = 0;
            int[] set = new int[128];
            int oddCount = 0;
            if(s.length() == 1){
                return 1;
            }
            for(char ch: s.toCharArray()){
                if(set[ch] != 0){
                    maxLength += 2;
                    set[ch] = 0;
                    oddCount--;
                }else{
                    set[ch] = 1;
                    oddCount++;
                }
            }
    
            if(oddCount > 0){
               maxLength += 1;
            }
            return maxLength;
        }
    }
}
