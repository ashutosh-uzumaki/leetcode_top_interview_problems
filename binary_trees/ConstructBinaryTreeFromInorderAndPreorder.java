package binary_trees;

public class ConstructBinaryTreeFromInorderAndPreorder {
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
    int idx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, inorder, 0, preorder.length-1);
    }

    public TreeNode buildTreeHelper(int[] preorder, int[] inorder, int start, int end){
        if(start > end){
            return null;
        }
        int i = start;
        for(; i<=end; i++){
            if(preorder[idx] == inorder[i]){
                break;
            }
        }
        TreeNode root = new TreeNode(preorder[idx]);
        idx++;
        root.left = buildTreeHelper(preorder, inorder, start, i-1);
        root.right = buildTreeHelper(preorder, inorder, i+1, end);

        return root;
    }
}
}
