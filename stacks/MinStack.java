package stacks;

import java.util.*;
public class MinStack {
    class Pair{
        int actualValue;
        int minValue;
    
        Pair(int actualValue, int minValue){
            this.actualValue = actualValue;
            this.minValue = minValue;
        }
    }
    
    class MinStacks {
        Stack<Pair> st;
        public MinStacks() {
            st = new Stack<>();
        }
        
        public void push(int val) {
            if(st.size() == 0){
                st.push(new Pair(val, val));
                return;
            }
            int minVal = Math.min(st.peek().minValue, val);
            st.push(new Pair(val, minVal));
        }
        
        public void pop() {
            st.pop();
        }
        
        public int top() {
            return st.peek().actualValue;
        }
        
        public int getMin() {
            return st.peek().minValue;
        }
    }
    
    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(val);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */
}
