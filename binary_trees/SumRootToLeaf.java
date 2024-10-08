public class SumRootToLeaf {
    class Solution {
        public int sumNumbers(TreeNode root) {
            return helper(root, 0);
        }
    
        public int helper(TreeNode root, int val){
            if(root == null){
                return 0;
            }
    
            val = val * 10 + root.val;
    
            if(root.left == null && root.right == null){
                return val;
            }
    
            int left = helper(root.left, val);
            int right = helper(root.right, val);
    
            return left + right;
        }
    }
}

//MISTAKE -> WAS NOT RETURNING AT THE LEAF NODE, WHICH WAS MAKING THE SUM DOUBLE.
