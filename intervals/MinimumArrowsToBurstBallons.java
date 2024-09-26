package intervals;

import java.util.*;
public class MinimumArrowsToBurstBallons {

class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int cnt = 1;
        int lastArrowPosition = points[0][1];

        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > lastArrowPosition) {
                cnt++;
                lastArrowPosition = points[i][1];
            }
        }

        return cnt;
    }
}

}

//MADE THE WRONG LOGIC. SHOULD SORT BY END AND CHECK IF IT STILL MERGES. INSTEAD I DID SORT W.R.T START.
