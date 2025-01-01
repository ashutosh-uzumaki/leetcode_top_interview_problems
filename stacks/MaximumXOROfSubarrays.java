package stacks;

import java.util.Stack;

public class MaximumXOROfSubarrays {
    public class Solution {
    public int solve(int[] A) {

        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        for(int i=0; i<A.length; i++)
        {
            if(stack.isEmpty())
            {
                stack.push(A[0]);
            }
            else
            {
                while(!stack.isEmpty() && stack.peek()<=A[i])
                {
                    max = Math.max(max, stack.peek()^A[i]);
                    stack.pop();
                }
                if( !stack.isEmpty() )
                    max = Math.max(max, stack.peek()^A[i]);
                
                stack.push(A[i]);
            }
        }
        return max;
    }
}

}
