package dynamic_programming;

import java.util.Arrays;

public class PaintingTheWalls {
    class Solution {
    int[] cost;
    int[] time;
    int[][] memo;
    public int paintWalls(int[] cost, int[] time) {
        this.cost = cost;
        this.time = time;
        int walls = cost.length;
        memo = new int[walls + 1][walls + 1];
        for(int i=0; i<=walls; i++){
            Arrays.fill(memo[i], Integer.MAX_VALUE);
        }
        return  helper(0, walls);
    }

    public int helper(int idx, int walls){
        if(walls <= 0){
            return 0;
        }

        if(idx == time.length){
            return Integer.MAX_VALUE / 2;
        }


        if(memo[idx][walls] != Integer.MAX_VALUE){
            return memo[idx][walls];
        }

        int picked = helper(idx + 1, walls - time[idx] - 1) + cost[idx];
        int notPicked = helper(idx + 1, walls);

        return memo[idx][walls] = Math.min(picked, notPicked);
    }
}
}
