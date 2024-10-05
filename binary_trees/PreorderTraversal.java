package binary_trees;

import java.util.ArrayList;
import java.util.List;



public class PreorderTraversal {
    class Solution{
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();
        helper(root, preorder);
        return preorder;
    }

    public void helper(TreeNode root, List<Integer> preorder){
        if(root == null){
            return;
        }

        preorder.add(root.val);
        helper(root.left, preorder);
        helper(root.right, preorder);
    }
}   
}
