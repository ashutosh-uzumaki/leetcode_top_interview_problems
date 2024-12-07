package intervals;

public class MyCalendarOne {
    import java.util.ArrayList;
    import java.util.List;
    
    class MyCalendar {
        List<Pair> calendar;
    
        public MyCalendar() {
            calendar = new ArrayList<>();
        }
    
        public boolean book(int start, int end) {
            for (Pair event : calendar) {
                if (start < event.end && end > event.start) {
                    return false;
                }
            }
            calendar.add(new Pair(start, end));
            return true;
        }
    }
    
    class Pair {
        int start;
        int end;
    
        Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
     
}
