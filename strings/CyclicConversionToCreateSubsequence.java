package strings;

public class CyclicConversionToCreateSubsequence {
    class Solution {
        public boolean canMakeSubsequence(String str1, String str2) {
            int m = str1.length();
            int n = str2.length();
            int idx1 = 0;
            int idx2 = 0;
    
            while(idx1 < m && idx2 < n){
                if(str1.charAt(idx1) == str2.charAt(idx2)||
                str1.charAt(idx1) == str2.charAt(idx2) - 1
                || (str1.charAt(idx1) == 'z' && str2.charAt(idx2) == 'a')){
                    idx2++;
                } 
                idx1++;
            }
    
            return idx2 == n;
        }
    }
}
