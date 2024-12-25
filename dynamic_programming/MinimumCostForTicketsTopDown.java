package dynamic_programming;

import java.util.HashMap;

public class MinimumCostForTicketsTopDown {
    class Solution {
    HashMap<Integer, Integer> travelNeeded = new HashMap<>();
    public int mincostTickets(int[] days, int[] costs) {
        for(int day: days){
            travelNeeded.put(day, 1);
        }
        return helper(0, days, costs);
    }

    public int helper(int currDay, int[] days, int[] costs){
        if(currDay > days[days.length - 1]){
            return 0;
        }


        if(!travelNeeded.containsKey(currDay)){
            return helper(currDay + 1, days, costs);
        }

        int oneDayCost = costs[0] + helper(currDay + 1, days, costs);
        int sevenDayCost = costs[1] + helper(currDay + 7, days, costs);
        int thirtyDayCost = costs[2] + helper(currDay + 30, days, costs);

        return Math.min(oneDayCost, Math.min(sevenDayCost, thirtyDayCost));


    }
}
}
