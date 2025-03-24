public class BusyDaysInScheduledMeetings {
    class Solution {
        public int countDays(int days, int[][] meetings) {
             Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
    
            int freeDays = 0;
            int lastEnd = 0;
    
            for (int[] meeting : meetings) {
                if (meeting[0] > lastEnd + 1) {
                    freeDays += meeting[0] - (lastEnd + 1);
                }
                lastEnd = Math.max(lastEnd, meeting[1]);
            }
            if (lastEnd < days) {
                freeDays += days - lastEnd;
            }
    
            return freeDays;
        }
    }
}
