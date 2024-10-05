package binary_trees;

import java.util.ArrayList;
import java.util.List;

 class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }

public class InorderTraversal {
    class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        helper(root, inorder);
        return inorder;
    }

    public void helper(TreeNode root, List<Integer> inorder){
        if(root == null){
            return;
        }

        helper(root.left, inorder);
        inorder.add(root.val);
        helper(root.right, inorder);
    }
}
}
