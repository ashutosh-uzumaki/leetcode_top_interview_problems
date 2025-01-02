package dynamic_programming;

public class TileWithMX1 {
    class Solution
{
    public int countWays(int n, int m)
    {
        int mod = (int)1e9 + 7;
        // Code here
        int[] dp = new int[n + 1];
        for(int i=0; i<=n; i++){
            if(i < m){
                dp[i] = 1;
            }else{
                dp[i] = (dp[i - 1] + dp[i - m])%mod;
            }
        }
        
        return dp[n]%mod;
    }
}
}
