package binary_trees;

public class MaxTimeToBurnTree {
    /**********************************************************	
	
	Following is the representation of Binary Tree Node:
 	
 	class BinaryTreeNode<T> {
		T data;
		BinaryTreeNode<T> left;
		BinaryTreeNode<T> right;
		
		public BinaryTreeNode(T data) {
			this.data = data;
		}
	}

*********************************************************/

public class Solution
{
	static int maxTime = 0;
public static int timeToBurnTree(BinaryTreeNode<Integer> root, int start)
    {
        // Write your code here.
		helper(root, start);
		return maxTime;
    }
public static int helper(BinaryTreeNode<Integer> root, int start){
	if(root == null){
		return -1;
	}

	if(root.data == start){
		dfs(root, 0);
		return 1;
	}

	int left = helper(root.left, start);
	if(left > 0){
		maxTime = Math.max(maxTime, left);
		dfs(root.right, left + 1);
		return left+1;
	}

	int right = helper(root.right, start);
	if(right > 0){
		maxTime = Math.max(maxTime, right);
		dfs(root.left, right + 1);
		return right + 1;
	}

	return -1;
}

public static void dfs(BinaryTreeNode<Integer> root, int time){
	if(root == null){
		return;
	}
	maxTime = Math.max(maxTime, time);
	dfs(root.left, time + 1);
	dfs(root.right, time + 1);
}
}
}
