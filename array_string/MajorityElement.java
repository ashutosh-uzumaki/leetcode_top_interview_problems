package array_string;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int val = nums[0];
        int cnt = 1;
        for(int i=1; i<nums.length; i++){
            if(cnt == 0){
                val = nums[i];
            }
            if(nums[i] == val){
                cnt++;
            }else{
                cnt--;
            }
        }
        return val;
    }
}
