package binary_trees;

public class DiameterOfBinaryTree {
    class Solution {
        int maxDiameter = 0;
        public int diameterOfBinaryTree(TreeNode root) {
            if(root == null){
                return 0;
            }
            helper(root);
            return maxDiameter - 1;
        }
        public int helper(TreeNode root){
            if(root == null){
                return 0;
            }
    
            int leftHeight = helper(root.left);
            int rightHeight = helper(root.right);
    
            maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight + 1);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}


//MISTAKE - INSTEAD OF CHECKING FOR Math.max(diameter, leftHeight + rightHeight + 1) i checked for Math.max(leftHeight, rightHeight) + 1.
//This is incorrect because we are not considering the diameter of the tree which is the length of the left which passes through the root to right