package binary_search_trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AllNodeValuesInTwoBST {
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
    List<Integer> res;
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        res = new ArrayList<>();
        inorder(root1);
        inorder(root2);

        Collections.sort(res);

        return res;
    }

    public void inorder(TreeNode root){
        if(root == null){
            return;
        }

        inorder(root.left);
        res.add(root.val);
        inorder(root.right);
    }
}
}
