package binary_search_trees;

import java.util.ArrayList;

class TreeNode<T>
{
   public:
    T data;
    TreeNode<T> left;
    TreeNode<T> right;

    TreeNode(T data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}

public class RemoveNodesOutsideRange {


 class Solution {

    public static TreeNode<Integer> removeOutsideRange(TreeNode<Integer> root, int min, int max) {

        // Write your code here.
        if(root == null){
            return null;
        }
        if(root.data < min){
            return removeOutsideRange(root.right, min, max);
        }else if(root.data > max){
            return removeOutsideRange(root.left, min, max);
        }else{
            root.left = removeOutsideRange(root.left, min, max);
            root.right = removeOutsideRange(root.right, min, max);

            return root;
        }
    }
}
}
