package strings;

public class MinimumOperationsToConvertFromStr1toStr2 {
    class Solution {

        public static int minCostToGivenString(String str1, String str2) {
            int prefixLength = 0;
            if(str1.length() != str2.length()){
                return -1;
            }
            // Find the longest prefix of str2 in str1
            for (int i = 0; i < str1.length(); i++) {
                if (prefixLength < str2.length() && str1.charAt(i) == str2.charAt(prefixLength)) {
                    prefixLength++;
                }
            }
    
            // Minimum operations needed
            return str2.length() - prefixLength;
        }
    
    }
    
}
