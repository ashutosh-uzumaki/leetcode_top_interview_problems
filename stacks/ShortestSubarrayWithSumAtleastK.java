package stacks;

import java.util.ArrayDeque;
import java.util.Deque;

public class ShortestSubarrayWithSumAtleastK {
    class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int minLength = Integer.MAX_VALUE;
        int n = nums.length;
        int[] prefixSum = new int[n];
        for(int i=0; i<n; i++){
            if(i == 0){
                prefixSum[i] = nums[i];
            }else{
                prefixSum[i] = prefixSum[i - 1] + nums[i];
            }
        }
        Deque<Integer> deque = new ArrayDeque<>();
        for(int j=0; j<n; j++){
            if(prefixSum[j] >= k){
                minLength = Math.min(minLength, j + 1);
            }

            while(!deque.isEmpty() && prefixSum[j] - prefixSum[deque.peekLast()] >= k){
                minLength = Math.min(minLength, j - deque.pollLast());
            }

            while(!deque.isEmpty() && prefixSum[j] <= prefixSum[deque.peekFirst()]){
                deque.pollFirst();
            }

            deque.addFirst(j);
        }

        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }
}
}
