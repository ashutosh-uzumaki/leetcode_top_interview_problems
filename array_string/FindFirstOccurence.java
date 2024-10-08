package array_string;

public class FindFirstOccurence {
    class Solution {
        public int strStr(String haystack, String needle) {
            int haystackLength = haystack.length();
            int needleLength = needle.length();
            
            if (needleLength == 0) {
                return 0;
            }
            
            if (haystackLength < needleLength) {
                return -1;
            }
            
            for (int i = 0; i <= haystackLength - needleLength; i++) {
                int j = 0;
                while (j < needleLength && haystack.charAt(i + j) == needle.charAt(j)) {
                    j++;
                }
                if (j == needleLength) {
                    return i;
                }
            }
            
            return -1;
        }
    }
    
}

//MISTAKE -> missed the test case when haystack length < needle length
