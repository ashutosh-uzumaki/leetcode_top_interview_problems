public class FlattenTreeToLL {
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
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }

        TreeNode temp = root.right;
        flatten(root.left);
        root.right = root.left;
        root.left = null;
        while(root.right != null){
            root = root.right;
        }
        root.right = temp;
        flatten(root.right);
    }
}
}

// WAS NOT ABLE TO SOLVE IT ON MY OWN. HAVE TO REVISE ONCE.
// Although I tried was not able to set root.right at right place and not able to think of moving root to it's last root.
