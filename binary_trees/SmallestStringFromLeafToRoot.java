public class SmallestStringFromLeafToRoot {
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
    String smallestString = String.valueOf((char)('z' + 1));
    public String smallestFromLeaf(TreeNode root) {
        if(root == null){
            return "";
        }

        helper(root, new StringBuilder());
        return smallestString;
    }

    public void helper(TreeNode root, StringBuilder currPathString){
        if(root == null){
            return;
        }

        currPathString.append((char)(root.val + 'a'));
        if(root.left == null && root.right == null){
            String leafString = currPathString.reverse().toString();
            if(leafString.compareTo(smallestString) < 0){
                smallestString = leafString;
            }
            currPathString = currPathString.reverse();
        }

        helper(root.left, currPathString);
        helper(root.right, currPathString);
        currPathString.deleteCharAt(currPathString.length() - 1);
    }
}
}
