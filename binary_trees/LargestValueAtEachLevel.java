package binary_trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LargestValueAtEachLevel {
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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> largestValues = new ArrayList<>();

        if(root == null){
            return largestValues;
        }

        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);

        while(!nodes.isEmpty()){
            int size = nodes.size();
            int currLevelMax = Integer.MIN_VALUE;
            for(int i=0; i<size; i++){
                TreeNode currNode = nodes.poll();
                if(currNode.val > currLevelMax){
                    currLevelMax = currNode.val;
                }

                if(currNode.left != null){
                    nodes.add(currNode.left);
                }   
                if(currNode.right != null){
                    nodes.add(currNode.right);
                }
            }


            largestValues.add(currLevelMax);
        }
        return largestValues;
    }
}
}
