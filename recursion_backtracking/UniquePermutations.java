import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UniquePermutations {
    class Solution {
    List<List<Integer>> permutations = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        helper(0, nums);
        return permutations;
    }

    public void helper(int i, int[] nums){
        if(i == nums.length){
            List<Integer> curr = new ArrayList<>();
            for(int num: nums){
                curr.add(num);
            }
            permutations.add(new ArrayList<>(curr));
            return;
        }

        HashMap<Integer, Boolean> mp = new HashMap<>();
        for(int j = i; j < nums.length; j++){
            if(!mp.containsKey(nums[j])){
                swap(nums, i, j);
                helper(i + 1, nums);
                swap(nums, i, j);
            }
            mp.put(nums[j], true);
        }
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;   
    }
}
}
