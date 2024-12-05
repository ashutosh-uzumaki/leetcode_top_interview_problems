package dynamic_programming;

public class FrogJump{
    static int[] memo;
    public static int frogJump(int n, int heights[]) {

        // Write your code here..
        memo = new int[n];
        Arrays.fill(memo, -1);
        return helper(0, n, heights);
    }

    public static int helper(int idx, int n, int[] heights){
        if(idx == n - 1){
            return 0;
        }
        if(memo[idx] != -1){
            return memo[idx];
        }

        int oneStep = Math.abs(heights[idx] - heights[idx + 1]) + helper(idx + 1, n, heights);
        int twoStep = (idx + 2 < n) ? Math.abs(heights[idx] - heights[idx + 2]) + helper(idx + 2, n, heights) : Integer.MAX_VALUE;

        return memo[idx] = Math.min(oneStep, twoStep);
    }

}
