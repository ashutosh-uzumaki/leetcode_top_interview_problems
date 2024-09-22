package hashing;

import java.util.*;
public class IsomorphicStrings {
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        
        HashMap<Character, Character> mapST = new HashMap<>();
        HashMap<Character, Character> mapTS = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            char first = s.charAt(i);
            char second = t.charAt(i);
            if (mapST.containsKey(first) && mapST.get(first) != second) {
                return false;
            }
            if (mapTS.containsKey(second) && mapTS.get(second) != first) {
                return false;
            }
            
            mapST.put(first, second);
            mapTS.put(second, first);
        }
        return true;
    }
}

}
