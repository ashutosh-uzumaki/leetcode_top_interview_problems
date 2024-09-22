package hashing;

public class Ransom {
    class Solution {
        public boolean canConstruct(String ransomNote, String magazine) {
            int[] ransomHash = new int[26];
            int[] magazineHash = new int[26];
    
            for(char ch: ransomNote.toCharArray()){
                ransomHash[ch-'a']++;
            }
    
            for(char ch: magazine.toCharArray()){
                magazineHash[ch-'a']++;
            }
    
            for(char ch: ransomNote.toCharArray()){
                int idx = ch - 'a';
                if(ransomHash[idx] > magazineHash[idx]){
                    return false;
                }
            }
            return true;
        }
    }
}
