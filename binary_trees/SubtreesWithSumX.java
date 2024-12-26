package binary_trees;

public class SubtreesWithSumX {
    class Tree
{
    int cnt = 0;
    //Function to count number of subtrees having sum equal to given sum.
    int countSubtreesWithSumX(Node root, int X)
    {
	    //Add your code here.
	    helper(root, X);
	    return cnt;
	
    }
    
    int helper(Node root, int X){
        if(root == null){
            return 0;
        }
        
        int leftSum = helper(root.left, X);
        int rightSum = helper(root.right, X);
        
        int sum = leftSum + rightSum + root.data;
        if(sum == X){
            cnt++;
        }
        
        return sum;
    }
}
}
