package binary_search_trees;

import java.util.ArrayList;
import java.util.List;

public class BalanceABinarySearchTree {
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
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> sortedElements = new ArrayList<>();
        inorder(root, sortedElements);

        return createBST(sortedElements, 0, sortedElements.size() - 1);
    }

    public void inorder(TreeNode root, List<Integer> sortedElements){
        if(root == null){
            return;
        }

        inorder(root.left, sortedElements);
        sortedElements.add(root.val);
        inorder(root.right, sortedElements);
    }

    public TreeNode createBST(List<Integer> elements, int start, int end){
        if(start > end){
            return null;
        }

        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(elements.get(mid));
        root.left = createBST(elements, start, mid - 1);
        root.right = createBST(elements, mid + 1, end);

        return root;
    }
}
}
