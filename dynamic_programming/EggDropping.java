package dynamic_programming;

import java.util.Arrays;

class Solution {
    // Function to find minimum number of attempts needed in
    // order to find the critical floor.
    static int[][] memo;
    static int eggDrop(int n, int k) {
        // Your code here
        memo = new int[105][105];
        for(int i=0; i<=104; i++){
            for(int j=0; j<=104; j++){
                memo[i][j] = -1;
            }
        }
        return helper(n, k);
    }
    
    static int helper(int n, int k){
        if(n == 1 || k == 0 || k == 1){
            return k;
        }
        if(memo[n][k] != -1){
            return memo[n][k];
        }
        
        int moves = (int)1e9;
        for(int i=1; i <= k; i++){
            int breaks = helper(n - 1, i - 1);
            int doesNotBreak = helper(n, k - i);
            
            int opsTaken = 1 + Math.max(breaks, doesNotBreak);
            moves = Math.min(moves, opsTaken);
            
        }
        
        return memo[n][k] = moves;
    }
}