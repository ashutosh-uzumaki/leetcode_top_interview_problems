package stacks;

import java.util.*;

public class ReverseStack {
    

 class Solution {
    
    public static void reverseStack(Stack<Integer> stack) {
        // Base case: if the stack is empty, return
        if (stack.isEmpty()) {
            return;
        }

        // Remove the top element
        int top = stack.pop();

        // Reverse the remaining stack
        reverseStack(stack);

        // Insert the popped element at the bottom of the stack
        insertAtBottom(stack, top);
    }

    private static void insertAtBottom(Stack<Integer> stack, int element) {
        // Base case: if the stack is empty, push the element
        if (stack.isEmpty()) {
            stack.push(element);
            return;
        }

        // Remove the top element
        int top = stack.pop();

        // Recursively call to insert the element at the bottom
        insertAtBottom(stack, element);

        // Push the top element back
        stack.push(top);
    }

}

}
