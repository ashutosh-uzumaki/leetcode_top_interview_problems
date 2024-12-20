package dynamic_programming;

public class MinimumCostToMakeStringsIdentical {
    class Solution {
        int[][] memo;
        public int findMinCost(String x, String y, int costX, int costY) {
            memo = new int[x.length() + 1][y.length() + 1];
            for(int i=0; i<=x.length(); i++){
                for(int j=0; j<=y.length(); j++){
                    memo[i][j] = -1;
                }
            }
            return helper(0, 0, costX, costY, x, y);
        }
        
        public int helper(int i, int j, int costX, int costY, String x, String y){
            if(i == x.length() && j == y.length()){
                return 0;
            }
            
            if(i == x.length()){
                return (y.length() - j) * costY;
            }
            
            if(j == y.length()){
                return (x.length() - i) *  costX;
            }
            
            if(memo[i][j] != -1){
                return memo[i][j];    
            }
            
            char a = x.charAt(i);
            char b = y.charAt(j);
            
            if(a == b){
                return memo[i][j] = helper(i + 1, j + 1, costX, costY, x, y);
            }
            
            int removeFromX = costX + helper(i + 1, j, costX, costY, x, y);
            int removeFromY = costY + helper(i, j + 1, costX, costY, x, y);
            
            return memo[i][j] = Math.min(removeFromX, removeFromY);
        }
    }
    
}
