public class BinaryTilt {
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
    int tiltedSum = 0;
    public int findTilt(TreeNode root) {
        subTreeSum(root);
        return tiltedSum;
    }

    public int subTreeSum(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftSubTreeSum = subTreeSum(root.left);
        int rightSubTreeSum = subTreeSum(root.right);

        int tilt = Math.abs(leftSubTreeSum - rightSubTreeSum);
        tiltedSum += tilt;

        return leftSubTreeSum + rightSubTreeSum + root.val;
    }
}
}

//MISTAKE -> CALCULATE THE LEFT SUB TREE SUM, RIGHT SUB TREE SUM AND THEN ADD THEIR DIFF TO TILTEDSUM.
