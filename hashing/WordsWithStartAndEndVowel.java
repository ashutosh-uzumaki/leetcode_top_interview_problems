package hashing;

import java.util.HashSet;

public class WordsWithStartAndEndVowel {
    class Solution {
    HashSet<Character> vowels;
    public int[] vowelStrings(String[] words, int[][] queries) {
        vowels = new HashSet<>();
        vowels.add('a'); vowels.add('e'); vowels.add('i'); vowels.add('o'); vowels.add('u');
        int[] prefixCnt = new int[words.length];
        for(int i=0; i<words.length; i++){
            String word = words[i];
            char startChar = word.charAt(0);
            char endChar = word.charAt(word.length() - 1);
            if(vowels.contains(startChar) && vowels.contains(endChar)){
                prefixCnt[i] = (i == 0) ? 1 : prefixCnt[i - 1] + 1;
            }else{
                prefixCnt[i] = (i == 0) ? 0 :prefixCnt[i - 1];
            }
        }
        int[] cnt = new int[queries.length];
        int i = 0;
        for(int[] query: queries){
            int left = query[0];
            int right = query[1];

            if(left == 0){
                cnt[i] = prefixCnt[right];
            }else{
                cnt[i] = prefixCnt[right] - prefixCnt[left - 1];
            }
            i++;
        }
        return cnt;
    }
}
}
