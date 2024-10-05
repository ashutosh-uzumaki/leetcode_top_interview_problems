package binary_trees;

import java.util.ArrayList;
import java.util.List;

public class PostorderTraversal {
    class Solution {
    List<Integer> res = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null){
            return res;
        }

        helper(root);
        return res;
    }

    public void helper(TreeNode root){
        if(root == null){
            return;
        }

        helper(root.left);
        helper(root.right);
        res.add(root.val);
    }
}
}
