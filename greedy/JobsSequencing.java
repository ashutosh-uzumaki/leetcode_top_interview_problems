package greedy;

import java.util.ArrayList;
import java.util.Arrays;

public class JobsSequencing {
    class Solution {
    // Function to find the maximum profit and the number of jobs done.
    ArrayList<Integer> JobScheduling(Job jobs[], int n) {
        // Your code here
        ArrayList<Integer> result = new ArrayList<>();
        boolean[] slot = new boolean[n];
        Arrays.sort(jobs, (job1, job2) -> job2.profit - job1.profit);
        int jobsPerformed = 0;
        int totalProfitEarned = 0;
        for(int i=0; i<jobs.length; i++){
            int idx = jobs[i].deadline;
            if(idx > n){
                idx = n;
            }
            
            while(idx > 0){
                if(slot[idx - 1] == false){
                    slot[idx - 1] = true;
                    jobsPerformed += 1;
                    totalProfitEarned += jobs[i].profit;
                    break;
                }
                idx -= 1;
            }
        }
        
        result.add(jobsPerformed);
        result.add(totalProfitEarned);
        
        return result;
    }
}

}
