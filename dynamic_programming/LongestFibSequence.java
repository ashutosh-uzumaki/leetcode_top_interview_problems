package dynamic_programming;
import java.util.HashMap;
public class LongestFibSequence {

class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        HashMap<Integer, Integer> indices = new HashMap<>();
        int[][] dp = new int[n][n];

        // Store indices of elements for quick lookup
        for (int i = 0; i < n; i++) {
            indices.put(arr[i], i);
        }

        int maxLen = 0;

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < j; i++) {
                int prevEle = arr[j] - arr[i];
                int idx = indices.getOrDefault(prevEle, -1);

                if (idx >= 0 && idx < i) {
                    dp[i][j] = dp[idx][i] + 1;
                } else {
                    dp[i][j] = 2;
                }

                maxLen = Math.max(maxLen, dp[i][j]);
            }
        }

        return maxLen > 2 ? maxLen : 0;
    }
}

}
