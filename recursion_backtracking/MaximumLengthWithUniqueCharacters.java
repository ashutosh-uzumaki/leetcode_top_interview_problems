import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class MaximumLengthWithUniqueCharacters {
    class Solution {
    public int maxLength(List<String> arr) {
        return helper(arr, 0, new StringBuilder());
    }

    public int helper(List<String> arr, int idx, StringBuilder sb) {
        if (idx == arr.size()) {
            return sb.length();
        }

        int finalLength = sb.length();
        HashMap<Character, Integer> freq = new HashMap<>();

        for (char ch : sb.toString().toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        for (int i = idx; i < arr.size(); i++) {
            boolean isDuplicate = false;
            HashSet<Character> seen = new HashSet<>();
            for (char ch : arr.get(i).toCharArray()) {
                if (seen.contains(ch)) {
                    isDuplicate = true;
                    break;
                }
                seen.add(ch);
            }

            
            for (char ch : arr.get(i).toCharArray()) {
                if (freq.containsKey(ch)) {
                    isDuplicate = true;
                    break;
                }
            }

            if (!isDuplicate) {
                sb.append(arr.get(i)); 
                int length = helper(arr, i + 1, sb); 
                finalLength = Math.max(length, finalLength); 
                sb.setLength(sb.length() - arr.get(i).length()); 
            }
        }

        return finalLength;
    }
}

}
