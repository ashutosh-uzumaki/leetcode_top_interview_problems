package binary_trees;

public class ConstructBinaryTreeFromPreorderAndPostOrder {
    class Solution {
        int idx = 0;
    
        public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
            // Start recursion with the full range of preorder and postorder arrays
            return buildTreeHelper(preorder, postorder, 0, postorder.length - 1);
        }
    
        public TreeNode buildTreeHelper(int[] preorder, int[] postorder, int start, int end) {
            if (start > end) {
                return null;
            }
    
            // The first element in preorder is the root
            TreeNode root = new TreeNode(preorder[idx]);
            idx++; // move to the next element in preorder for the next root
            
            // If there's only one element, no left or right subtree exists
            if (start == end) {
                return root;
            }
    
            // Find the index of the next node in postorder, which is the left subtree root
            int leftRootValue = preorder[idx];
            int leftRootIndex = -1;
            for (int i = start; i <= end; i++) {
                if (postorder[i] == leftRootValue) {
                    leftRootIndex = i;
                    break;
                }
            }
    
            // Recursively build the left and right subtrees
            root.left = buildTreeHelper(preorder, postorder, start, leftRootIndex);
            root.right = buildTreeHelper(preorder, postorder, leftRootIndex + 1, end - 1);
    
            return root;
        }
    }
    
}
