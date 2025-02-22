public class RecoverBinaryTreeFromPreorderTraversal {
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
    int n;
    int idx = 0;
    public TreeNode recoverFromPreorder(String traversal){
        n = traversal.length(); 
        return helper(traversal, 0); 
    }

    public TreeNode helper(String traversal, int depth){
        if(idx >= n){
            return null;
        }

        int j = idx;
        int dash = 0;
        while(j < n && traversal.charAt(j) == '-'){
            j++;
            dash++;
        }

        if(depth != dash){
            return null;
        }

        idx = j;

        int num = 0;
        while(idx < n && Character.isDigit(traversal.charAt(idx))){
            num = (num * 10) + (traversal.charAt(idx) - '0');
            idx++;
        }

        TreeNode root = new TreeNode(num);
        root.left = helper(traversal, depth + 1);
        root.right = helper(traversal, depth + 1);

        return root;        
    }
}
}
