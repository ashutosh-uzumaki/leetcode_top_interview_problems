package greedy;

public class MakeDigitsMontoneIncreasing {
    class Solution {
        public int monotoneIncreasingDigits(int n) {
            char[] digits = Integer.toString(n).toCharArray();
            int changePosition = digits.length;
            for(int i=digits.length - 2; i>=0; i--){
                if(digits[i] > digits[i + 1]){
                    digits[i]--;
                    changePosition = i + 1;
                }
            }
    
            for(int i = changePosition; i < digits.length; i++){
                digits[i] = '9';
            }
    
            return Integer.parseInt(new String(digits));
        }
    }
}


//APPROACH FIND AT THE LOWEST POSITION WHERE CHANGE REQUIRED, AFTER DECREMENTING THE DIGITS FROM RIGHT
//DIGITS[I] > DIGITS[I + 1]
        //DIGITS[I]--
        //CHANGEPOSITION = I + 1