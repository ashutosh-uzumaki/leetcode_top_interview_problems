package binary_trees;

public class ValidBST {
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
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean helper(TreeNode root, long leftval, long rightval){
        if(root == null){
            return true;
        }

        if(root.val <= leftval || root.val >= rightval){
            return false;
        }

        boolean left = helper(root.left, leftval, root.val);
        boolean right = helper(root.right, root.val, rightval);

        return left && right;
    }
}
}
