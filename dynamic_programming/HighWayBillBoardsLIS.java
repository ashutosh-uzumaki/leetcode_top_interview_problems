package dynamic_programming;

import java.util.* ;
import java.io.*;

public class HighWayBillBoardsLIS {
  
class Solution {

	public static int highwayBillboard(int[] billboards, int[] revenue, int m, int x) {
	 	// Write your code here.
		int[] dp = new int[m + 1];
		dp[0] = revenue[0];
		int maxPossible = dp[0];
		for(int i=1; i<billboards.length; i++){
			int max = 0;
			for(int j = i-1; j>=0; j--){
				int distance = billboards[i] - billboards[j];
				if(distance > x){
					max = Math.max(max, dp[j]);
				}
			}
			dp[i] = max + revenue[i];
			maxPossible = Math.max(dp[i], maxPossible);
		}

		return maxPossible;
		
	}

}

}
