package intervals;

public class RemoveCoveredIntervals {
    class Solution {
        public int removeCoveredIntervals(int[][] intervals) {
            Arrays.sort(intervals, (a, b) -> {
                if (a[0] == b[0]) {
                    return Integer.compare(b[1], a[1]);
                } else {
                    return Integer.compare(a[0], b[0]);
                }
            });
            int coveredIntervals = 0;
            int start = intervals[0][0];
            int end = intervals[0][1];
            System.out.println(intervals[0][0]+" "+intervals[0][1]);
            int size = intervals.length;
            for(int i=1; i<size; i++){
                // System.out.println(intervals[i][0]+" "+intervals[i][1]+" "+start+" "+end);
                if(intervals[i][0] >= start && intervals[i][1] <= end){
                    // System.out.println(i);
                    coveredIntervals++;
                }else{
                    start = Math.min(start, intervals[i][0]);
                    end = Math.max(start, intervals[i][1]);
                }
            }
    
            return size - coveredIntervals;
        }
    }
}

//MISTAKE -> SORTED based on first value, but if the first values are same then sort based on descending order of second value.
