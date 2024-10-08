package two_pointers;
import java.util.*;
public class ThreeSum {
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> res = new ArrayList<>();
            int n = nums.length;
            
            for (int i = 0; i < n - 2; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                
                int j = i + 1;
                int k = n - 1;
                
                while (j < k) {
                    int sum = nums[i] + nums[j] + nums[k];
                    
                    if (sum > 0) {
                        k--;
                    } else if (sum < 0) {
                        j++;
                    } else {
                        res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        while (j < k && nums[j] == nums[j + 1]) j++;
                        while (j < k && nums[k] == nums[k - 1]) k--;
                        j++;
                        k--;
                    }
                }
            }
            
            return res;
        }
    }
    
}

//MISTAKE -> I SKIPPED THE DUPLICATE VALUE FOR FIRST NUMBER, BUT DID'NT DO FOR THE SECOND AND THIRD NUMBER.
