public class CounCompleteNodes {
    class Solution {
        int cnt = 0;
        public int countNodes(TreeNode root) {
            if(root == null){
                return 0;
            }
    
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }
}

// MISTAKE -> GOT CONFUSED WITH THE QUESTION AND WENT IN WRONG DIRECTION.
// HAD TO CHECK SOLUTION.
