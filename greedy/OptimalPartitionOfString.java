package greedy;

public class OptimalPartitionOfString {
    class Solution {
        public int partitionString(String s) {
            int start = 0;
            int end = 0;
            int cnt = 0;
            int[] freq = new int[26];
            
            while (end < s.length()) {
                while (end < s.length() && freq[s.charAt(end) - 'a'] == 0) {
                    freq[s.charAt(end) - 'a']++;
                    end++;
                }
                cnt++;
                for (int i = start; i < end; i++) {
                    freq[s.charAt(i) - 'a']--;
                }
                start = end;
            }
    
            return cnt;
        }
    }
    
}
