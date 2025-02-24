package greedy;

import java.util.Arrays;

public class MinimumPlacesToMoveToPlaceStudents {
    class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int placesToBeMoved = 0;
        for(int i=0; i<seats.length; i++){
            placesToBeMoved += Math.abs(seats[i] - students[i]);
        }
        return placesToBeMoved;
    }
}
}
