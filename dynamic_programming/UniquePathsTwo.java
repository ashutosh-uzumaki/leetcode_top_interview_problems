package dynamic_programming;

public class UniquePathsTwo {
    class Solution {
        public int uniquePathsWithObstacles(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int[][] dp = new int[m][n];
            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    dp[i][j] = -1;
                }
            }
            if(grid[0][0] == 1){
                return 0;
            }
    
            if(grid[m - 1][n - 1] == 1){
                return 0;
            }
    
            return helper(0, 0, m, n, grid, dp);
        }
    
        public int helper(int row, int col, int m, int n, int[][] grid, int[][] dp){
            if(row >= m || col >= n || grid[row][col] == 1){
                return 0;
            }
    
            if(row == m-1 && col == n-1){
                return 1;
            }
    
            if(dp[row][col] != -1){
                return dp[row][col];
            }
    
            return dp[row][col] = (helper(row + 1, col, m, n, grid, dp) + helper(row, col + 1, m, n, grid, dp));
        }
    }
}
