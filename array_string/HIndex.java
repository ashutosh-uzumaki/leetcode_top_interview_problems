import java.util.Arrays;

public class HIndex {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int low = 0, high = citations.length - 1;
        int n = citations.length;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (citations[mid] >= (n - mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return n - low;
    }
}

//mistake - didn't account for sorted array of nature -> test case [11, 15] answer will be 2 as there are no h indexes.
// corrected sort the array and check for citations[mid] >= (n - mid).
// return n - low (from low till end of array count).
