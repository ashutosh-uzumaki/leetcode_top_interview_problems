public class TrailingZeros {
    class Solution {
        public int trailingZeroes(int n) {
            int zeroCnt = 0;
            while(n > 0){
                n /= 5;
                zeroCnt += n;
            }
    
            return zeroCnt;
        }
    }
}
