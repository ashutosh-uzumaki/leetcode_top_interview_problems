package dynamic_programming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MaximumProfitOfTwoNonOverlapEvents {
    class Event{
    int start;
    int end;
    int profit;

    Event(int start, int end, int profit){
        this.start = start;
        this.end = end;
        this.profit = profit;
    }
}
class Solution {
    int[][] memo;
    public int maxTwoEvents(int[][] events) {
        int size = events.length;
        memo = new int[size + 1][3];
        for(int i=0; i<=size; i++){
            memo[i][0] = -1;
            memo[i][1] = -1;
            memo[i][2] = -1;
        }
        List<Event> eventList = new ArrayList<>();
        for(int[] event: events){
            eventList.add(new Event(event[0], event[1], event[2]));
        }

        Collections.sort(eventList, new Comparator<Event>(){
            @Override
            public int compare(Event first, Event second){
                return first.start - second.start;
            }
        });
        
        return helper(0, 2, eventList);
    }

    public int helper(int idx, int eventsRemaining, List<Event> eventList){
        if(idx >= eventList.size() || eventsRemaining == 0){
            return 0;
        }

        if(memo[idx][eventsRemaining] != -1){
            return memo[idx][eventsRemaining];
        }

        int nextIdx = getNextIdx(idx+1, eventList, eventList.get(idx).end);

        int take =  eventList.get(idx).profit + helper(nextIdx, eventsRemaining - 1, eventList);
        int notTake = helper(idx + 1, eventsRemaining, eventList);

        return memo[idx][eventsRemaining] = Math.max(take, notTake);
    }

    public int getNextIdx(int low, List<Event> eventList, int target){
        int high = eventList.size() - 1;
        int idx = eventList.size() + 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(eventList.get(mid).start > target){
                idx = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return idx;
    }
}
}
