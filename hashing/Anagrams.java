public class Anagrams {
    class Solution {
        public boolean isAnagram(String s, String t) {
            int[] hash = new int[26];
            for(char ch: s.toCharArray()){
                hash[ch-'a']++;
            }
    
            for(char ch: t.toCharArray()){
                hash[ch-'a']--;
            }
    
            for(int i=0; i<26; i++){
                if(hash[i] != 0){
                    return false;
                }
            }
            return true;
        }
    }
}
