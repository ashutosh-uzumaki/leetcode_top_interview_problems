package intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class InsertInterval {
    class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int size = intervals.length;
        int[][] expandedIntervals = new int[size + 1][2];
        int i = 0;
        while(i < size){
            expandedIntervals[i] = intervals[i];
            i++;
        }
        expandedIntervals[i++] = newInterval;
        Arrays.sort(expandedIntervals, (a, b) -> Integer.compare(a[0], b[0])); 
        i = 0;
        List<int[]> tempMerged = new ArrayList<>();
        int[] currentInterval = expandedIntervals[0];
        for(i=1; i <= size; i++){
            if(expandedIntervals[i][0] <= currentInterval[1]){
                currentInterval[1] = Math.max(expandedIntervals[i][1], currentInterval[1]);
            }else{
                tempMerged.add(currentInterval);
                currentInterval = expandedIntervals[i];
            }
        }
        tempMerged.add(currentInterval);
        int mergedLength = tempMerged.size();
        int[][] mergedResult = new int[mergedLength][2];
        for(i=0; i<mergedLength; i++){
            mergedResult[i] = tempMerged.get(i);
        }

        return mergedResult;
    }
}
}


// USING ARRAY LIST

    class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }

class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        intervals.add(newInterval);
        Collections.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval first, Interval second){
                if(first.start == second.start){
                    return first.end - second.end;
                }
                return first.start - second.start;
            }
        });

       
        Interval currentInterval = intervals.get(0);
        ArrayList<Interval> tempMerged = new ArrayList<>();
        for(int i=1; i<intervals.size(); i++){
            if(intervals.get(i).start <= currentInterval.end){
                currentInterval.end = Math.max(intervals.get(i).end, currentInterval.end);
            }else{
                tempMerged.add(currentInterval);
                currentInterval = intervals.get(i);
            }
        }
        tempMerged.add(currentInterval);
        return tempMerged;
    }
}
