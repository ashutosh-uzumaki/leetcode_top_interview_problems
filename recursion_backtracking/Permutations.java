import java.util.ArrayList;
import java.util.List;

public class Permutations {
    class Solution {
    List<List<Integer>> permutations = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        helper(0, nums);
        return permutations;
    }

    public void helper(int i, int[] nums){
        if(i == nums.length){
            List<Integer> currPermutation = convertToList(nums);
            permutations.add(new ArrayList<>(currPermutation));
            return;
        }

        for(int j=i; j < nums.length; j++){
            swap(nums, i, j);
            helper(i + 1, nums);
            swap(nums, i, j);
        }
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public List<Integer> convertToList(int[] nums){
        List<Integer> perm = new ArrayList<>();
        for(int num: nums){
            perm.add(num);
        }

        return perm;
    }
}
}
