package binary_trees;

public class CousinsInABinaryTree {
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
    TreeNode xParent = null;
    TreeNode yParent = null;
    int xDepth = -1, yDepth = -1;
    public boolean isCousins(TreeNode root, int x, int y) {
        getDepthAndParent(0, null, root, x, y);
        return xDepth == yDepth && xParent != yParent;
    }

    public void getDepthAndParent(int depth, TreeNode parent, TreeNode root, int x, int y){
        if(root == null){
            return;
        }

        if(root.val == x){
            xParent = parent;
            xDepth = depth;
        }else if(root.val == y){
            yParent = parent;
            yDepth = depth;
        }

        getDepthAndParent(depth + 1, root, root.left, x, y);
        getDepthAndParent(depth + 1, root, root.right, x, y);

    }
}
}
