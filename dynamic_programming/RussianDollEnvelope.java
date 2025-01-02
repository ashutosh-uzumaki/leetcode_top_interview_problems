package dynamic_programming;

import java.util.Arrays;

public class RussianDollEnvelope {
    class Solution {
    public int solve(int[][] A) {
        Arrays.sort(A, (a, b) -> (a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]));
        int[] dp = new int[A.length];
        int ans = 1;
        for(int i=0; i<A.length; i++){
            dp[i] = 1;
            for(int j=i-1; j>=0; j--){
                if(A[j][0] < A[i][0] && A[j][1] < A[i][1]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(dp[i], ans);
        }

        return ans;
    }
}

}
