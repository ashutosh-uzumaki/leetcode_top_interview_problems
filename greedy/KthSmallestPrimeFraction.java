package greedy;

import java.util.PriorityQueue;

public class KthSmallestPrimeFraction {
    class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> (arr[a[0]] * arr[b[1]] - arr[b[0]] * arr[a[1]]));
        int n = arr.length;
        for(int i=1; i<arr.length; i++){
            q.add(new int[]{0, i});
        }

        while(k > 1){
            int[] curr = q.poll();
            int a = curr[0];
            int b = curr[1];

            if(a + 1 < b){
                q.add(new int[]{a + 1, b});
            }
            k --;
        }

        int[] kthFraction = q.poll();
        return new int[]{arr[kthFraction[0]], arr[kthFraction[1]]};
    }
}
}
