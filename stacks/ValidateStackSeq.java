package stacks;

public class ValidateStackSeq {
    class Solution {
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            // traverse pushed array like a stack --> increasing pointer when pushing element and decreasing pointer when popping 
            int l = 0, r = 0;
            for(int num: pushed) {
                pushed[l++] = num;
                while( l>0 && pushed[l-1] == popped[r]) {
                    l--;
                    r++;
                }
            }
            return l==0;
        }
    }
}
