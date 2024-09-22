package hashing;
import java.util.*;
public class WordPattern {
    class Solution {
        public boolean wordPattern(String pattern, String s) {
            String[] words = s.split(" ");
            if(pattern.length() != words.length){
                return false;
            }
            HashMap<Character, String> ps = new HashMap<>();
            HashMap<String, Character> sp = new HashMap<>();
            int i = 0;
            for(char ch: pattern.toCharArray()){
                String word = words[i];
                System.out.println(word+" "+ch);
                if(ps.containsKey(ch) && !ps.get(ch).equals(word)){
                    return false;
                }else{
                    ps.put(ch, word);
                }
    
                if(sp.containsKey(word) && sp.get(word) != ch){
                    return false;
                }else{
                    sp.put(word, ch);
                }
                i++;
            }
            return true;
        }
    }
}
