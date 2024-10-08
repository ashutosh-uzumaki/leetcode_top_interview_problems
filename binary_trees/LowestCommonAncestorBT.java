public class LowestCommonAncestorBT {
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if(root == null){
                return null;
            }
    
            if(root == p || root == q){
                return root;
            }
    
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
    
            if(left != null && right != null){
                return root;
            }
    
            if(left != null){
                return left;
            }
            return right;
        }
    }
}


// MISTAKE -> I WAS RETURNING NULL WHEN LEFT == NULL && RIGHT == NULL BUT THERE MIGHT BE VALUE WHICH WE WILL BE RECEIVING EITHER FROM LEFT OR RIGHT.