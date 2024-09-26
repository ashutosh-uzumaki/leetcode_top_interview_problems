package intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SummaryRanges {
    class Solution {
    public List<String> summaryRanges(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        List<String> ans = new ArrayList<>();
        while(i < nums.length){
            int start = nums[i];
            int end = nums[i];
            i++;
            while(i < nums.length && nums[i] - 1 == nums[i-1]){
                end = nums[i];
                i++;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(start);
            if(end != start){
                sb.append("->");
                sb.append(end);
            }
            ans.add(sb.toString());
        }
        return ans;
    }
}
}
