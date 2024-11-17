package dynamic_programming;

public class MaximumIncreasingSumSubsequence {
    class Solution
{
	public int maxSumIS(int arr[])  
	{  
	    //code here.
	    int n = arr.length;
	    int[] lis = new int[n + 1];
	    int maxSum = arr[0];
	    
	    for(int i=0; i<n; i++){
	        lis[i] = arr[i];
	        for(int j=i-1; j>=0; j--){
	            if(arr[i] > arr[j] && (lis[i] < (lis[j] + arr[i]))){
	                lis[i] = lis[j] + arr[i];
	            }
	        }
	        maxSum = Math.max(lis[i], maxSum);
	    }
	    return maxSum;
	}  
}
}
