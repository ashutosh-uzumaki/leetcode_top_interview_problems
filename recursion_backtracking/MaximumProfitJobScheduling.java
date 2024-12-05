import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MaximumProfitJobScheduling {
    class Job{
    int start;
    int end;
    int profit;

    Job(int start, int end, int profit){
        this.start = start;
        this.end = end;
        this.profit = profit;
    }

}
class Solution {
    int[] memo;
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<Job> jobs = new ArrayList<>();
        memo = new int[startTime.length];
        Arrays.fill(memo, -1);
        for(int i=0; i<startTime.length; i++){
            jobs.add(new Job(startTime[i], endTime[i], profit[i]));
        }

        Collections.sort(jobs, new Comparator<Job>(){
            @Override
            public int compare(Job a, Job b){
                return a.start - b.start;
            }
        });

        return helper(0, jobs);
    }

    public int helper(int idx, List<Job> jobs){
        if(idx >= jobs.size()){
            return 0;
        }

        if(memo[idx] != -1){
            return memo[idx];
        }

        int nextIndex = getNextIndex(jobs, idx + 1, jobs.get(idx).end);

        int take = helper(nextIndex, jobs) + jobs.get(idx).profit;
        int notTake = helper(idx+1, jobs);
        return memo[idx] = Math.max(take, notTake);
    }

    public int getNextIndex(List<Job> jobs, int startIndex, int endTime){
        int low = startIndex;
        int ans = jobs.size() + 1;
        int high = jobs.size() - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(jobs.get(mid).start >= endTime){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return ans;
    }
}
}
