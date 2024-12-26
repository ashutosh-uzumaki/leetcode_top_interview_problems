package stacks;

import java.util.*;

public class GoodSubsequence {
    

class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            // Ensure that the stack contains the most competitive subsequence
            while (!st.isEmpty() && st.peek() > nums[i] && st.size() + (n - i - 1) >= k) {
                st.pop();
            }

            // Add the current element if the stack has space
            if (st.size() < k) {
                st.push(nums[i]);
            }
        }

        // Build the result array
        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            res[i] = st.pop();
        }

        return res;
    }
}
}
