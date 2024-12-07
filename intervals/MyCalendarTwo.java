package intervals;

public class MyCalendarTwo {
    import java.util.ArrayList;
import java.util.List;

class MyCalendarTwo {
    List<Pair> events;     // Store all events
    List<Pair> overlaps;   // Store all overlaps (double bookings)

    public MyCalendarTwo() {
        events = new ArrayList<>();
        overlaps = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        for (Pair overlap : overlaps) {
            if (start < overlap.end && end > overlap.start) {
                return false;  // Triple booking detected
            }
        }

        for (Pair event : events) {
            if (start < event.end && end > event.start) {
                overlaps.add(new Pair(Math.max(start, event.start), Math.min(end, event.end)));
            }
        }
        
        events.add(new Pair(start, end));
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

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */

}
