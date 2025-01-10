public class WordSubsets {
    class Solution {
        public List<String> wordSubsets(String[] words1, String[] words2) {
            List<String> subsets = new ArrayList<>();
            int[] cnt = new int[26];
            for(String word: words2){
                int[] currWord = getCount(word);
                for(int i=0; i<26; i++){
                    cnt[i] = Math.max(currWord[i], cnt[i]);
                }
            }
    
    
            for(String word: words1){
                int[] currWord = getCount(word);
                boolean isSubset = true;
                for(int i=0; i<26; i++){
                    if(currWord[i] < cnt[i]){
                        isSubset = false;
                        break;
                    }
                }
    
                if(isSubset){
                    subsets.add(word);
                }
            }
            return subsets;
        }
    
        public int[] getCount(String s){
            int[] cnt = new int[26];
            for(char c: s.toCharArray()){
                cnt[c - 'a'] += 1;
            }
            return cnt;
        }
    }
}
