public class MakeLexicographicallySmallerBySwapping {
    //brute force
    class Solution {
        public int[] lexicographicallySmallestArray(int[] nums, int limit) {
            int n = nums.length;
    
            for(int i=0; i<n; i++){
                while(true){
                    int smallValue = nums[i];
                    int smallIdx = -1;
    
                    for(int j=i+1; j<n; j++){
                        if(Math.abs(nums[j] - smallValue) <= limit){
                            if(nums[j] < smallValue){
                                smallValue = nums[j];
                                smallIdx = j;
                            }
                        }
                    }
    
                    if(smallIdx != -1){
                        swap(nums, i, smallIdx);
                    }else{
                        break;
                    }
                }           
                
            }
            return nums;
        }
    
        private void swap(int[] nums, int i, int j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
