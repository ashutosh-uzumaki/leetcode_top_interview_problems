package dynamic_programming;

import java.util.Arrays;

public class MinimumCostToCutAStick {
    class Solution {
    int[][] dp;
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int m = cuts.length;
        dp = new int[102][102];
        for(int i=0; i<=101; i++){
            for(int j=0; j<=101; j++){
                dp[i][j] = -1;
            }
        }
        return helper(0, n, cuts, 0, m - 1);
    }

    public int helper(int startStick, int endStick, int[] cuts, int leftCut, int rightCut){
        if(leftCut > rightCut){
            return 0;
        }
        if(dp[leftCut][rightCut] != -1){
            return dp[leftCut][rightCut];
        }
        int cost = (int)1e9;
        for(int i=leftCut; i<=rightCut; i++){
            int leftStickCost = helper(startStick, cuts[i], cuts, leftCut, i - 1);
            int rightStickCost = helper(cuts[i], endStick, cuts, i + 1, rightCut);
            // System.out.println(leftStickCost+" "+rightStickCost+" "+endStick+" "+startStick);
            int currentCost = (endStick - startStick) + leftStickCost + rightStickCost;
            cost = Math.min(currentCost, cost);
        }

        return dp[leftCut][rightCut] = cost;
    }
}
}
