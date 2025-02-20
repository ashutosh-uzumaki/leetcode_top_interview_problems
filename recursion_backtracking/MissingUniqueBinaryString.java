import java.util.*;

public class MissingUniqueBinaryString {
    class Solution {
        HashSet<String> presentNums;
    
        public String findDifferentBinaryString(String[] nums) {
            int n = nums.length;
            presentNums = new HashSet<>();
            for (String num : nums) {
                presentNums.add(num);
            }
            return findMissingNum(new StringBuilder(), 0, n);
        }
    
        private String findMissingNum(StringBuilder current, int index, int n) {
            if (index == n) { // Base condition when length of string is n
                String candidate = current.toString();
                if (!presentNums.contains(candidate)) {
                    return candidate;
                }
                return null; // Invalid path
            }
    
            // Try '0' at current position
            current.append('0');
            String result = findMissingNum(current, index + 1, n);
            if (result != null) {
                return result;
            }
            current.deleteCharAt(current.length() - 1);
    
            // Try '1' at current position
            current.append('1');
            result = findMissingNum(current, index + 1, n);
            if (result != null) {
                return result;
            }
            current.deleteCharAt(current.length() - 1);
    
            return null;
        }
    }
    
}
