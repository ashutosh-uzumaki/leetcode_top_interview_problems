package stacks;

public class MinimumRemovalForBalancedString {
    class Solution {
        public String minRemoveToMakeValid(String s) {
            // Stack<Character> st = new Stack<>();
            int i = 0;
            StringBuilder target = new StringBuilder();
            int open = 0, close = 0;
            while(i < s.length()){
                if(s.charAt(i) == '('){
                    open++;
                    target.append(s.charAt(i));
                }else if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z'){
                    target.append(s.charAt(i));
                }else{
                    if(close < open){
                        close++;
                        target.append(s.charAt(i));
                    }
                }
                i++;
            }
    
            int balance = 0;
            i = target.length() - 1;
            StringBuilder balancedString = new StringBuilder();
            while(i >= 0){
                char ch = target.charAt(i);
                if(ch == '('){
                    if(balance > 0){
                        balance--;
                        balancedString.append(ch);
                    }
                }
                else if(ch == ')'){
                        balance++;
                        balancedString.append(ch);
                    }else{
                        balancedString.append(ch);
                    }
                i-=1;
            }
            return balancedString.reverse().toString();
        }
    }
}

//INTUTION - FIRST REMOVE THE EXCESS CLOSING BY STARTING FROM LEFT TO RIGHT (CLOSE < OPEN)
// THEN REMOVE THE EXCESS OPENING BRACKET BY VISITING FROM RIGHT TO LEFT (CLOSE > 0)
