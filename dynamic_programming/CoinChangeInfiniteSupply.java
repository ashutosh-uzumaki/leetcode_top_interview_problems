package dynamic_programming;

public class CoinChangeInfiniteSupply {
    class Solution {
        int[][] sum;
        int mod = (int)1e6 + 7;
        public int coinchange2(int[] A, int B) {
            sum = new int[B + 1][A.length + 1];
            for(int i=0; i<=B; i++){
                for(int j=0; j<=A.length; j++){
                    sum[i][j] = -1;
                }
            }
            return helper(0, B, A);
        }
        public int helper(int idx, int B, int[] A){
            if(idx >= A.length || B < 0){
                return 0;
            }
    
            if(B == 0){
                return 1;
            }
    
            if(sum[B][idx] != -1){
                return sum[B][idx];
            }
    
            int cnt = 0;
            int take = (B >= A[idx]) ? helper(idx, B - A[idx], A) : 0;
            int skip = helper(idx + 1, B, A);
    
            return sum[B][idx] = (take + skip) % mod;
        }
    }
    
}
