package maths;
import java.util.* ;
import java.io.*; 

public class SmallestNumberDivisibleContainingOnesAsDiigit {
    class Solution {
	public static int lengthOfNumber(int k) {
		if(k <= 0){
			return -1;
		}

		int num = 1;
		HashSet<Integer> seen = new HashSet<>();
		int remainder = 1 % k;
		int digitCnt = 1;
		seen.add(remainder);
		while(remainder != 0){
			remainder = (remainder * 10 + 1) % k;
			digitCnt++;
			if(seen.contains(remainder)){
				return -1;
			}
			seen.add(remainder);
		}
		return digitCnt;
	}
}
}
