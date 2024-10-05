package binary_trees;

public class BalancedBinaryTree {
    class Solution {
        boolean balancedTree = true;
        public boolean isBalanced(TreeNode root) {
            if(root == null){
                return true;
            }
    
            helper(root);
            return balancedTree;
        }
    
        public int helper(TreeNode root){
            if(root == null){
                return 0;
            }
            
            int leftHeight = helper(root.left);
            int rightHeight = helper(root.right);
            balancedTree = Math.abs(leftHeight - rightHeight) <= 1 ? balancedTree && true : balancedTree && false;
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
     
}
