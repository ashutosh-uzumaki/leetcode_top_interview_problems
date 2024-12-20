package dynamic_programming;

import java.util.Arrays;

public class LISMinInsertionToSortArray {
    class Solution
{
    public int minInsertions(int arr[], int N) 
	{ 
        //code here.
        int[] dp =  new int[N];
        Arrays.fill(dp, 1);
        int maxLen = 1;
        for(int i=0; i<N; i++){
            for(int j=i-1; j>=0; j--){
                if(arr[i] >= arr[j]){
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        
        return N - maxLen;
	} 
}

}
