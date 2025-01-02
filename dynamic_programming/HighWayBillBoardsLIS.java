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


//ONE FOR LOOP
//WITH M AS FOR LOOP
 
class Solution {

	public static int highwayBillboard(int[] billboards, int[] revenue, int m, int x) {
	 	// Write your code here.
		 HashMap<Integer, Integer> mp = new HashMap<>();
		 for(int i=0; i<billboards.length; i++){
			 mp.put(billboards[i], revenue[i]);
		 }

		 int[] dp = new int[m + 1];
		 int maxPossible = Integer.MIN_VALUE;
		 for(int i=1; i<=m; i++){
			 if(!mp.containsKey(i)){
				 dp[i] = dp[i - 1];
			 }else{
				 int boardNotInstalled = dp[i - 1];
				 int boardInstalled = mp.get(i);
				 if(i >= x + 1){
					 boardInstalled += dp[i - x - 1];
				 }
				 dp[i] = Math.max(boardInstalled, boardNotInstalled); 
			 }
			maxPossible = Math.max(maxPossible, dp[i]);
		 }

		 return maxPossible;
	}

}
