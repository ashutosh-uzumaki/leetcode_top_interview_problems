package two_pointers;

public class ArithmeticSlices {
    class Solution {
        public int numberOfArithmeticSlices(int[] nums) {
            int  n =  nums.length; 
            if(n < 3){
                return 0;
            }
    
            // int maxLength = 0;
            int currLength = 0;
            int count = 0;
            int diff = nums[1] - nums[0];
    
            for(int i=2; i<n; i++){
                int comingDiff = nums[i] - nums[i-1];
                if(comingDiff == diff){
                    currLength++;
                    count += currLength;
                }else{
                    diff = comingDiff;
                    currLength = 0;
                }
            }
    
            return count;
        }
    }
}
