package dynamic_programming;

public class CimbingStairs {
    class Solution {
        public int climbStairs(int n) {
            if(n <= 1){
                return n;
            }
    
            int oneStepJump = 1;
            int twoStepJump = 1;
    
            for(int i=2; i<=n; i++){
                int totalJump = oneStepJump + twoStepJump;
                oneStepJump = twoStepJump;
                twoStepJump = totalJump;
            }
    
            return twoStepJump;
        }
    }
}
