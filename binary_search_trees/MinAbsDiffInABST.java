package binary_search_trees;

public class MinAbsDiffInABST {
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
    int minDiff = Integer.MAX_VALUE;
    int prev = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        if(root == null){
            return 0;
        }

        helperMinDiff(root);
        return minDiff;
    }

    public void helperMinDiff(TreeNode root){
        if(root == null){
            return;
        }

        helperMinDiff(root.left);
        if(prev == Integer.MAX_VALUE){
            prev = root.val;
        }else{
            minDiff = Math.min(Math.abs(root.val - prev), minDiff);
        }
        prev = root.val;
        helperMinDiff(root.right);
    }
}
}
