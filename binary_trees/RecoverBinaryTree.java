package binary_trees;

import java.util.HashMap;

public class RecoverBinaryTree {
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
class FindElements {
    HashMap<Integer, Integer> cnt = new HashMap<>();
    public FindElements(TreeNode root) {
        if(root == null){
            return;
        }
        root.val = 0;
        cnt.put(0, 1);
        helper(root, 0);
    }

    public void helper(TreeNode root, int x){
        if(root == null){
            return;
        }

        if(root.left != null){
            root.val = 2 * x + 1;
            cnt.put(root.val, 1);
            helper(root.left, root.val);
        }

        if(root.right != null){
            root.val = 2 * x + 2;
            cnt.put(root.val, 1);
            helper(root.right, root.val);
        }
    }
    
    public boolean find(int target) {
        if(cnt.containsKey(target)){
            return true;
        }
        return false;
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
}
