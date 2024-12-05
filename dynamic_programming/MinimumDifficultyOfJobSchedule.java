package dynamic_programming;

public class MinimumDifficultyOfJobSchedule {
    class Solution {
        int[][] memo;
        public int minDifficulty(int[] jobDifficulty, int d) {
            int n = jobDifficulty.length;
            memo = new int[n+1][d+1];
            for(int i=0; i<=n; i++){
                for(int j=0; j<=d; j++){
                    memo[i][j] = -1;
                }
            }
            if(n < d){
                return -1;
            }
    
            return helper(jobDifficulty, 0, n, d);
        }
    
        public int helper(int[] jd, int idx, int n, int d){
            if(d == 1){
                int maxDifficult = jd[idx];
                for(int i=idx+1; i<n; i++){
                    maxDifficult = Math.max(maxDifficult, jd[i]);
                }
                return maxDifficult;
            }
            if(memo[idx][d] != -1){
                return memo[idx][d];
            }
            int maxDifficult = jd[idx];
            int finalAns = Integer.MAX_VALUE;
    
            for(int i = idx; i<= n-d; i++){
                maxDifficult = Math.max(maxDifficult, jd[i]);
                int curr = maxDifficult + helper(jd, i+1, n, d-1);
                finalAns = Math.min(curr, finalAns);
            }
    
            return memo[idx][d] = finalAns;
        }
    }
}
