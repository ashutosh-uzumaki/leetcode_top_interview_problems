public class DeleteLeftAndRightMatchingChars {
    class Solution {
        public int minimumLength(String s) {
            int[] freq = new int[26];
            int deleted = 0;
    
            for(char c: s.toCharArray()){
                freq[c - 'a'] += 1;
    
                if(freq[c - 'a'] == 3){
                    freq[c - 'a'] -= 2;
                    deleted += 2;
                }
            }
    
            return s.length() - deleted;
        }
    }
}
