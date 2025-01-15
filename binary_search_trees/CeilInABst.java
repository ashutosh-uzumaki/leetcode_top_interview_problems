public class CeilInABst {
    class Tree {
        // Function to return the ceil of given number in BST.
        int findCeil(Node root, int key) {
            if (root == null) return -1;
            // Code here
            
            if(root.data == key){
                return root.data;
            }
            int[] ceil = new int[1];
            ceil[0] = -1;
            helper(root, key, ceil);
            // System.out.println(ceil[0]);
            return ceil[0];
            
        }
        
        void helper(Node root, int key, int[] ceil){
            if(root == null){
                return;
            }
            
            if(root.data == key){
                ceil[0] = root.data;
                return;
            }
            
            if(root.data > key){
                ceil[0] = root.data;
                helper(root.left, key, ceil);
            }else{
                
                helper(root.right, key, ceil);
            }
        }
    }
    
}
