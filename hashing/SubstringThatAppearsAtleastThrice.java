package hashing;

public class SubstringThatAppearsAtleastThrice {
    class Solution {
        public int maximumLength(String s) {
            char[] chars = s.toCharArray();
            int n = s.length();
            int[][] freq = new int[26][n + 1];
            int len = 1;
            for(int i = 0; i<n; i++){
                if(i > 0 && chars[i] == chars[i - 1]){
                    len += 1;
                }else{
                    len = 1;
                }
                freq[chars[i] - 'a'][len] += 1; 
            }
            int maxLen = -1;
            for(int i = 0; i<26; i++){
                for(int j=n; j>0; j--){
                    if(j < n){
                        freq[i][j] += freq[i][j + 1];
                    }
    
                    if(freq[i][j] >= 3){
                        maxLen = Math.max(j, maxLen);
                        break;
                    }
                }
            }
            return maxLen;
        }
    }
}
