package dynamic_programming;

import java.util.Arrays;

public class DungeonGame {
    class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m][n];
        for(int i=0; i<m; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        return getMinimumHp(0, 0, m, n, dungeon, dp);
    }

    public int getMinimumHp(int r, int c, int m, int n, int[][] dungeon, int[][] dp){
        if(r >= m || c >= n){
            return Integer.MAX_VALUE;
        }

        if(r == m-1 && c == n-1){
            return (dungeon[r][c] <= 0) ? (-dungeon[r][c] + 1) : 1;
        }

        if(dp[r][c] != Integer.MAX_VALUE){
            return dp[r][c];
        }

        int right = getMinimumHp(r, c + 1, m, n, dungeon, dp);
        int down = getMinimumHp(r + 1, c, m, n, dungeon, dp);

        int minHealthRequired = Math.min(right, down) - dungeon[r][c];

        return dp[r][c] = (minHealthRequired <= 0) ? 1: minHealthRequired; 
    }
}
}
