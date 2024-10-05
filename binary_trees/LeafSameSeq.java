package binary_trees;

public class LeafSameSeq {
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
    List<Integer> treeOneLeaves = new ArrayList<>();
    List<Integer> treeTwoLeaves = new ArrayList<>();
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        getLeaves(root1, treeOneLeaves);
        getLeaves(root2, treeTwoLeaves);

        if(treeOneLeaves.size() != treeTwoLeaves.size()){
            return false;
        }
        for(int i=0; i<treeOneLeaves.size(); i++){
            if(!treeOneLeaves.get(i).equals(treeTwoLeaves.get(i))){
                return false;
            }
        }

        return true;
        
    }

    public void getLeaves(TreeNode root, List<Integer> leaves){
        if(root == null){
            return;
        }

        if(root.left == null && root.right == null){
            leaves.add(root.val);
            return;
        }

        getLeaves(root.left, leaves);
        getLeaves(root.right, leaves);
    }
}
}
