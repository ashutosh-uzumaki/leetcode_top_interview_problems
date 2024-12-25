package stacks;

import java.util.Stack;

public class LexicographicSubsequenceWithDistinctSub {
    class Solution {
    public String removeDuplicateLetters(String s) {
        int[] freq = new int[26]; // Frequency of each character
        boolean[] visited = new boolean[26]; // To check if a character is in the result
        Stack<Character> stack = new Stack<>();

        // Count the frequency of each character
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        for (char c : s.toCharArray()) {
            freq[c - 'a']--; // Decrement the frequency of the current character

            
            if (visited[c - 'a']) {
                continue;
            }

            
            while (!stack.isEmpty() && stack.peek() > c && freq[stack.peek() - 'a'] > 0) {
                visited[stack.pop() - 'a'] = false;
            }

            stack.push(c);
            visited[c - 'a'] = true;
        }


        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }

        return result.toString();
    }
}
}

//intution ->

//keep freq of each character to check if they appear later or not. if they appear later and already visited remove from stack and mark unvisited by reducing the frequency and add at the top of stack.
//while popping the freq should be checked for each character