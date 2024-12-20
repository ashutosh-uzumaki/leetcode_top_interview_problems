package strings;

public class StringToInteger {
    class Solution {
        public int myAtoi(String s) {
            if(s.length() <= 0){
                return 0;
            }
    
            int idx = 0;
            while(idx < s.length() && s.charAt(idx) == ' '){
                idx++;
            }
            int sign = 1;
            if(idx < s.length() && s.charAt(idx) == '-'){
                sign *= -1;
                idx++;
            }else if(idx < s.length() && s.charAt(idx) == '+'){
                sign *= 1;
                idx++;
            }
            // System.out.println(idx);
            int sum = 0;
            while (idx < s.length()) {
                if (!Character.isDigit(s.charAt(idx))) {
                    return sum * sign;
                }
                if (sum > (Integer.MAX_VALUE - (s.charAt(idx) - '0')) / 10) {
                    if (sign == 1) {
                        return Integer.MAX_VALUE;
                    } else {
                        return Integer.MIN_VALUE;
                    }
                }
                sum = sum * 10 + (s.charAt(idx) - '0');
                idx++;
            }
            return sum * sign;
        }
    }
}
