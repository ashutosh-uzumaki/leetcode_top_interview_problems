package hashing;
import java.util.*;
public class GroupAnagrams {
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            List<List<String>> ans = new ArrayList<>();
    
            int size = strs.length;
            if(size == 0){
                return ans;
            }   
    
            HashMap<String, List<String>> sortedString = new HashMap<>();
            for(String word: strs){
                int[] cnt = new int[26];
                for(char ch: word.toCharArray()){
                    cnt[ch - 'a']++;
                }
                String sorted = Arrays.toString(cnt);
                if(!sortedString.containsKey(sorted)){
                    sortedString.put(sorted, new ArrayList<>());
                }
                sortedString.get(sorted).add(word);
            }
    
            for(Map.Entry<String, List<String>> values: sortedString.entrySet()){
                ans.add(new ArrayList<>(values.getValue()));
            }
            return ans;
        }
    }
}
