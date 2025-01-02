package binary_trees;

public class LCAOfThreeNodes {
    /**********************************************************
	Following is the Binary Tree Node class.

	class BinaryTreeNode<T> {
	    T data;
	    BinaryTreeNode<T> left;
	    BinaryTreeNode<T> right;

	    public BinaryTreeNode(T data) {
		this.data = data;
	    }
	}
	
***********************************************************/

public class Solution {
    public static BinaryTreeNode<Integer> lcaOfThreeNodes(BinaryTreeNode<Integer> root, int node1, int node2,
            int node3) {
        // Write your code here.
		return helper(root, node1, node2, node3);
    }


	public static BinaryTreeNode<Integer> helper(BinaryTreeNode<Integer> root, int node1, int node2, int node3){
		if(root == null){
			return null;
		}

		if(root.data == node1 || root.data == node2 || root.data == node3){
			return root;
		}

		BinaryTreeNode<Integer> left = helper(root.left, node1, node2, node3);
		BinaryTreeNode<Integer> right = helper(root.right, node1, node2, node3);

		if(left != null && right != null){
			return root;
		}

		if(left != null){
			return left;
		}

		return right;
	}
}

}
