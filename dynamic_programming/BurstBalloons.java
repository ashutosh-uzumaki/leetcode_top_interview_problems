package dynamic_programming;

import java.util.Arrays;

public class BurstBalloons {
    class Solution {
    int[][] memo;
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] balloons = new int[n + 2];
        balloons[0] = 1;
        balloons[n + 1] = 1;

        for(int i=0; i<nums.length; i++){
            balloons[i + 1] = nums[i];
        }

        memo = new int[n + 2][n + 2];
        for(int i=0; i<n + 2; i++){
            Arrays.fill(memo[i], -1);
        }

        return helper(balloons, 1, n);
    }

    public int helper(int[] balloons, int left, int right){
        if(left > right){
            return 0;
        }

        if(memo[left][right] != -1){
            return memo[left][right];
        }

        int maxCoins = 0;

        for(int i=left; i<=right; i++){
            int coins = balloons[left - 1] * balloons[i] * balloons[right + 1];

            int leftCoins = helper(balloons, left, i - 1);
            int rightCoins = helper(balloons, i + 1, right);

            maxCoins = Math.max(maxCoins, coins + leftCoins + rightCoins);
        }

        return memo[left][right] = maxCoins;
    }
}
}
