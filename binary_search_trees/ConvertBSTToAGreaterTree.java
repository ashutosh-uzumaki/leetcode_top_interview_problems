package binary_search_trees;

public class ConvertBSTToAGreaterTree {
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
    int runningSum = 0;
    public TreeNode convertBST(TreeNode root) {
        if(root == null){
            return null;
        }

        construct(root);
        return root;
    }

    public void construct(TreeNode root){
        if(root == null){
            return;
        }

        construct(root.right);
        runningSum += root.val;
        root.val = runningSum;
        construct(root.left);
    }
}
}
