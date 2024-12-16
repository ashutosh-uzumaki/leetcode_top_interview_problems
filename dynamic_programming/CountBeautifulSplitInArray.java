package dynamic_programming;

public class CountBeautifulSplitInArray {
    class Solution {
        public int beautifulSplits(int[] nums) {
            int n = nums.length;
            if(n < 3){
                return 0;
            }
            int count = 0;
            for (int i = 1; i < n - 1; i++) {
                // nums1 = nums[0:i]
                for (int j = i + 1; j < n; j++) {
                    // nums2 = nums[i:j], nums3 = nums[j:]
    
                    boolean nums1IsPrefixOfNums2 = isPrefix(nums, 0, i, i, j);
                    boolean nums2IsPrefixOfNums3 = isPrefix(nums, i, j, j, n);
    
                    // Count only if exactly one condition is true
                    if (nums1IsPrefixOfNums2 || nums2IsPrefixOfNums3) {
                        count++;
                    }
                }
            }
    
            return count;
        }
        private boolean isPrefix(int[] nums, int start1, int end1, int start2, int end2) {
            int len1 = end1 - start1;
            int len2 = end2 - start2;
    
            // A prefix must be shorter or equal in length
            if (len1 > len2) return false;
    
            // Compare element by element
            for (int k = 0; k < len1; k++) {
                if (nums[start1 + k] != nums[start2 + k]) {
                    return false;
                }
            }
    
            return true;
        }
    }
}

// Did in O(n ^ 3)
// Need to optimise using DP or Z - Array
