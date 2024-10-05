package binary_trees;

public class RootToLeafPathSum {
    /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return helper(root, targetSum);
    }

    public boolean helper(TreeNode root, int targetSum){
        if(root == null){
            return false;
        }
        targetSum -= root.val;
        if(root.left == null && root.right == null){
            if(targetSum == 0){
                return true;
            }
        }
        boolean left = helper(root.left, targetSum);
        boolean right = helper(root.right, targetSum);
        return left || right;
    }
}
}
