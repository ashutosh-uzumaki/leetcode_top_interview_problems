package stacks;
import java.util.*;
public class RemoveKDigits {
    class Solution {
        public String removeKdigits(String num, int k) {
            if(num.length() == k){
                return "0";
            }
            Stack<Character> st = new Stack<>();
            for(int i=0; i<num.length(); i++){
                if(i == 0){
                    st.push(num.charAt(i));
                }else{
                    while(!st.isEmpty() && st.peek() > num.charAt(i) && k > 0){
                        k -= 1;
                        st.pop();
                    }
                    st.push(num.charAt(i));
                }
            }
    
            if(k > 0){
                while(!st.isEmpty() && k > 0){
                    st.pop();
                    k--;
                }
            }
    
            StringBuilder sb = new StringBuilder();
            while(st.size() > 0){
                sb.append(st.peek());
                st.pop();
            }
    
            int i = 0;
            String res = sb.reverse().toString();
            while(i < res.length() && res.charAt(i) == '0'){
                i++;
            }
            if(i == res.length()){
                return "0";
            }
            return res.substring(i);
        }
    }
}
