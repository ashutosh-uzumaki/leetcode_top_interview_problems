package intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeOverlappingIntervals {
    class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> mergedIntervals = new ArrayList<>();
        int[] currentInterval = intervals[0];

        for(int i=1; i<intervals.length; i++){
            if(intervals[i][0] <= currentInterval[1]){
                currentInterval[1] = Math.max(currentInterval[1], intervals[i][1]);
            }else{
                mergedIntervals.add(currentInterval);
                currentInterval = intervals[i];
            }
        }

        mergedIntervals.add(currentInterval);

        int size = mergedIntervals.size();
        int[][] merged = new int[size][2];
        for(int i=0; i<size; i++){
            merged[i] = mergedIntervals.get(i);
        }

        return merged;
    }
}
}
