import java.util.*;

public class PathSumTwo {
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return new ArrayList<>();
        }

        helper(root, targetSum, new ArrayList<>());
        return result;
    }

    public void helper(TreeNode root, int targetSum, List<Integer> currPath){
        if(root == null){
            return;
        }

        targetSum -= root.val;
        currPath.add(root.val);
        if(root.left == null && root.right == null){
            if(targetSum == 0){
                result.add(new ArrayList<>(currPath));
            }
            // return;
        }

        helper(root.left, targetSum, currPath);
        helper(root.right, targetSum, currPath);

        currPath.remove(currPath.size() - 1);
    }
}
}
