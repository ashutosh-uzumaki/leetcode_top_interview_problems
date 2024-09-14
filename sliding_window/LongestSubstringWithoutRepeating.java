package sliding_window;

public class LongestSubstringWithoutRepeating {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            if(s.length() == 0){
                return 0;
            }
            int maxLength = 1;
            int right = 0;
            int left = 0;
            int[] cnt = new int[256];
            int n = s.length();
            while(right < n){
                cnt[s.charAt(right)]++;
                while(left <= right && cnt[s.charAt(right)] > 1){
                    cnt[s.charAt(left)]--;
                    left++;
                }
                maxLength = Math.max(maxLength, right - left + 1);
                right++;
            }
            return maxLength;
        }
    }
}

//MISTAKE - CONSIDERED ONLY FOR LOWERCASE ALPHABETS
