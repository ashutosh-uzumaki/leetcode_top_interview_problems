package binary_trees;

public class SymmetricBinaryTree {
    class Solution {
        // return true/false denoting whether the tree is Symmetric or not
        public static boolean isSymmetric(Node root) {
            // add your code here;
            if(root == null){
                return true;
            }
            
            return helper(root.left, root.right);
            
        }
        
        public static boolean helper(Node rootA, Node rootB){
            if(rootA == null && rootB == null){
                return true;
            }
            
            if(rootA == null || rootB == null){
                return false;
            }
            
            
            if(rootA.data != rootB.data){
                return false;
            }
            
            return helper(rootA.left, rootB.right) && helper(rootA.right, rootB.left);
        }
        
    }
}
