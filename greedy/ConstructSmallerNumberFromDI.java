package greedy;

public class ConstructSmallerNumberFromDI {
    class Solution {
        public String smallestNumber(String pattern) {
            int n = pattern.length();
            StringBuilder result = new StringBuilder();
            int[] num = new int[n + 1];
            int counter = 1;
    
            // First loop: Fill all positions with increasing sequence
            for (int i = 0; i <= n; i++) {
                num[i] = counter++;
            }
    
            for (int i = 0; i < n; i++) {
                if (pattern.charAt(i) == 'D') {
                    int j = i;
                    while (j < n && pattern.charAt(j) == 'D') {
                        j++;
                    }
                    reverse(num, i, j);
                    i = j;
                }
            }
    
            for (int i = 0; i <= n; i++) {
                result.append(num[i]);
            }
    
            return result.toString();
        }
    
        private static void reverse(int[] num, int start, int end) {
            while (start < end) {
                int temp = num[start];
                num[start] = num[end];
                num[end] = temp;
                start++;
                end--;
            }
        }
    }
}
