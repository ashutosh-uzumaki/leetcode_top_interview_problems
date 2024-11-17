package dynamic_programming;

public class MatrixChainMultiplication {
    class Solution {
        static int[][] memo;
        static int matrixMultiplication(int arr[]) {
            // code here
            memo = new int[101][101];
            for(int i=0; i<101; i++){
                for(int j=0; j<101; j++){
                    memo[i][j] = -1;
                }
            }
            int n = arr.length;
            return mcmHelper(arr, 1, n-1);
        }
        
        static int mcmHelper(int[] arr, int i, int j){
            if(i == j){
                return 0;
            }
            
            if(memo[i][j] != -1){
                return memo[i][j];
            }
            
            int minimum = (int)1e9;
            for(int k=i; k < j; k++){
                int currVal = arr[i - 1]  * arr[k] * arr[j] + mcmHelper(arr, i, k) + mcmHelper(arr, k+1, j);
                minimum = Math.min(minimum, currVal);
            }
            
            return memo[i][j] = minimum;
        }
    }
}
