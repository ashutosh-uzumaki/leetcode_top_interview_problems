public class ChildrenSumProperty {
    class Solution
{
    //Function to check whether all nodes of a tree have the value 
    //equal to the sum of their child nodes.
    public static int isSumProperty(Node root)
    {
        // add your code here
        if(root == null){
            return 1;
        }
        int ans = helper(root);
        // System.out.println(ans);
        if(ans != root.data){
            return 0;
        }
        return 1;
    }
    
    public static int helper(Node root){
        if(root == null){
            return 0;
        }
        
        if(root.left == null && root.right == null){
            return root.data;
        }
        
        int leftVal = helper(root.left);
        int rightVal = helper(root.right);
        
        
        if(leftVal == -1 || rightVal == -1){
            return -1;
        }
        
        if(leftVal + rightVal != root.data){
            return -1;
        }
        
        return root.data;
    }
    
}
}
