package sliding_window;
public class MaxSumOfTwoNonOverlappingSubarrays {
    class Solution {
        public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
            int firstAns = helper(nums, firstLen, secondLen);
            int secondAns = helper(nums, secondLen, firstLen);
    
            return Math.max(firstAns, secondAns);
        }
    
        public int helper(int[] nums, int firstLen, int secondLen){
            int size = nums.length;
            int[] prefixSum = new int[size];
            int[] suffixSum = new int[size];
            int sum = 0;
            for(int i=0; i<size; i++){
                if(i < firstLen){
                    sum += nums[i];
                    prefixSum[i] = sum;
                }else{
                    sum += nums[i] - nums[i - firstLen];
                    prefixSum[i] = Math.max(prefixSum[i-1], sum);
                }
            }
            sum = 0;
            for(int i=size-1; i>=0; i--){
                if(i + secondLen >= size){
                    sum += nums[i];
                    suffixSum[i] = sum;
                }else{
                    sum += nums[i] - nums[i + secondLen];
                    suffixSum[i] = Math.max(suffixSum[i+1], sum);
                }
            }
    
            
            int ans = 0;
            for(int i=firstLen - 1; i<size-secondLen; i++){
                ans = Math.max(ans, prefixSum[i] + suffixSum[i+1]);
            }
    
            return ans;
        }
    }
}
