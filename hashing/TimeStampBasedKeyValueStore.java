import java.util.HashMap;
import java.util.TreeMap;

public class TimeStampBasedKeyValueStore {
    class TimeMap {
    HashMap<String, TreeMap<Integer, String>> store;
    public TimeMap() {
        store = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        store.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if(!store.containsKey(key)){
            return "";
        }
        TreeMap<Integer, String> value = store.get(key);
        Integer closestTimeStamp = value.floorKey(timestamp);
        return (closestTimeStamp != null) ? value.get(closestTimeStamp) : "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
}
