package stacks;
import java.util.*;
public class SumOfSubarrayRanges {
    class Solution {
        public long subArrayRanges(int[] nums) {
            Stack<Integer> stk = new Stack<Integer>();
            int n= nums.length;
            long[] left = new long[n];
            long[] right = new long[n];
            
            for(int i=0;i<n;i++)
            {
                while(!stk.empty() && nums[stk.peek()] >= nums[i])
                    stk.pop();
                left[i] = (stk.empty()) ? -1:stk.peek();
                stk.push(i);
            }
            stk.clear();
            for(int i=n-1;i>=0;i--)
            {
                while(!stk.empty() && nums[stk.peek()] > nums[i])
                    stk.pop();
                right[i] = (stk.empty()) ? n:stk.peek();
                stk.push(i);
            }
            long minimum_sum=0;
            for(int i=0;i<n;i++)
                minimum_sum += (i-left[i])*(right[i]-i)*nums[i];
            Arrays.fill(left,-1);
            Arrays.fill(right,n);
            stk.clear();
            for(int i=0;i<n;i++)
            {
                while(!stk.empty() && nums[stk.peek()] < nums[i])
                    stk.pop();
                left[i] = (stk.empty()) ? -1:stk.peek();
                stk.push(i);
            }
            stk.clear();
            for(int i=n-1;i>=0;i--)
            {
                while(!stk.empty() && nums[stk.peek()] <= nums[i])
                    stk.pop();
                right[i] = (stk.empty()) ? n:stk.peek();
                stk.push(i);
            }
            long maximum_sum=0;
            for(int i=0;i<n;i++)
                maximum_sum += (i-left[i])*(right[i]-i)*nums[i];
            
            return maximum_sum-minimum_sum;
            
        }
    }
}
