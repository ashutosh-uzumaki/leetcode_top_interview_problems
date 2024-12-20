package dynamic_programming;

public class UniquePaths {
    class Solution {
        public int uniquePaths(int m, int n) {
            int[][] dp = new int[m][n];
            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    dp[i][j] = -1;
                }
            }
            return helper(0, 0, m-1, n-1, dp);
        }
    
        public int helper(int row, int col, int destinationRow, int destinationColumn, int[][] dp){
            if(row > destinationRow || col > destinationColumn){
                return 0;
            }
    
            if(row == destinationRow && col == destinationColumn){
                return 1;
            }
            if(dp[row][col] != -1){
                return dp[row][col];
            }
            return dp[row][col] = (helper(row+1, col, destinationRow, destinationColumn, dp)
                                    + helper(row, col+1, destinationRow, destinationColumn, dp));
        }
    }
}
