package greedy;

import java.util.*;

public class SellAllCars {


class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner scn = new Scanner(System.in);
		int mod = (int)1e9 + 7;
		int testCases = scn.nextInt();
		while(testCases > 0){
		    int n = scn.nextInt();
		    int[] arr = new int[n];
		    for(int i=0; i<n; i++){
		        arr[i] = scn.nextInt();
		    }
		    
		    Arrays.sort(arr);
		    int reducePrice = 0;
		    long profit = 0;
		    for(int i=arr.length - 1; i>=0; i--){
		        arr[i] -= reducePrice;
		        if(arr[i] <= 0){
		            break;
		        }
		        reducePrice += 1;
		        profit += arr[i];
		        profit = profit % mod;
		    }
		    
		    System.out.println(profit);
		    testCases -= 1;
		}

	}
}

}
