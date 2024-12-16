package greedy;

import java.util.PriorityQueue;

public class FinalArrayStateAfterKMultiplicationsOne {
    class Pair{
    int val;
    int idx;

    Pair(int val, int idx){
        this.val = val;
        this.idx = idx;
    }
}
class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if(a.val == b.val){
                return Integer.compare(a.idx, b.idx);
            }
            return Integer.compare(a.val, b.val);
            });
        int idx = 0;
        for(int num: nums){
            pq.add(new Pair(num, idx));
            idx++;
        }   

        while(k > 0){
            Pair pair = pq.poll();
            pair.val = pair.val * multiplier;
            pq.add(new Pair(pair.val, pair.idx));
            k--;
        }
        int i = 0;
        while(!pq.isEmpty()){
            Pair pair = pq.poll();
            nums[pair.idx] = pair.val;
        }

        return nums;
    }
}
}
