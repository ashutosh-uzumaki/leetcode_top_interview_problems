package dynamic_programming;

public class LargestDivisibleSubset {
    import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n];
        int[] prev = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);
        
        int maxIndex = 0;  
        int maxLength = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if (dp[i] > maxLength) {
                maxLength = dp[i];
                maxIndex = i;
            }
        }

        List<Integer> answer = new ArrayList<>();
        while (maxIndex >= 0) {
            answer.add(nums[maxIndex]);
            maxIndex = prev[maxIndex];
        }
        // Collections.reverse(answer); // Reverse to get the correct order
        return answer;
    }
}

}
