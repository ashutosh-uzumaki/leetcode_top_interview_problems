package hashing;
import java.util.HashMap;

public class LongestPalindromeWithTwoLetterWords {
    class Solution {
        public int longestPalindrome(String[] words) {
            int lengthOfPalindrome = 0;
            boolean encounteredOdd = false;
    
            HashMap<String, Integer> wordCount = new HashMap<>();
            for(String word: words){
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
    
            for(String word: words){
                if(word.charAt(0) != word.charAt(1)){
                    String reverseStringToFind = Character.toString(word.charAt(1)) + Character.toString(word.charAt(0));
                    if(wordCount.containsKey(reverseStringToFind)){
                        int wordFreq = wordCount.get(word);
                        int reverseWordFreq = wordCount.get(reverseStringToFind);
                        lengthOfPalindrome += (Math.min(wordFreq, reverseWordFreq) * 4);
                        wordCount.remove(word);
                        wordCount.remove(reverseStringToFind);
                    }
                }else{
                    int wordFreq = wordCount.getOrDefault(word, 0);
                    if(wordFreq % 2 == 0){
                        lengthOfPalindrome += (wordFreq * 2);
                    }else{
                        if(encounteredOdd){
                            lengthOfPalindrome += ((wordFreq - 1) * 2);
                        }else{
                            lengthOfPalindrome += (wordFreq * 2);
                            encounteredOdd = true;
                        }
                    }
                    wordCount.remove(word);
                }
            }
            return lengthOfPalindrome;
        }
    }
}
