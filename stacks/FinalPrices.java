package stacks;

import java.util.Arrays;
import java.util.Stack;

public class FinalPrices {
    class Solution {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> st = new Stack<>();
        int size = prices.length;
        int[] newPrices = new int[size];
        Arrays.fill(newPrices, -1);
        for(int i=0; i<size; i++){
            while(st.size() > 0 && prices[st.peek()] >= prices[i]){
                newPrices[st.peek()] = prices[st.peek()] - prices[i];
                st.pop();
            }
            st.push(i);
        }

        while(st.size() > 0){
            newPrices[st.peek()] = prices[st.peek()];
            st.pop();
        }

        return newPrices;
    }
}
}
