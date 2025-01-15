package binary_search_trees;

public class FloorInABst {
    class Solution {
        public static int floor(Node root, int x) {
            // Code here
            if(root == null){
                return -1;
            }
            
            if(root.data == x){
                return root.data;
            }
            
            int[] ceil = new int[1];
            ceil[0] = -1;
            helper(root, x, ceil);
            return ceil[0];
        }
        
        private static void helper(Node root, int x, int[] ceil){
            if(root == null){
                return;
            }
            
            if(root.data == x){
                ceil[0] = root.data;
                return;
            }
            
            if(root.data < x){
                ceil[0] = root.data;
                helper(root.right, x, ceil);
            }else{
                helper(root.left, x, ceil);
            }
        }
    }
}
