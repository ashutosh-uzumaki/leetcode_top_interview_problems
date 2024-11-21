package maths;

public class PowerXandN {
    class Solution {
        public double myPow(double x, int n) {
            if(x == 0){
                return 0;
            }
            if(n > 0){
                return helper(x, n);
            }else{
                return 1 / helper(x, -n);
            }
        }
    
        public double helper(double x, int n){
            if(n == 0){
                return 1;
            }
            double halfAns = helper(x, n/2);
            double ans = halfAns * halfAns;
            if(n % 2 != 0){
                return ans * x;
            }
            return ans;
        }
    } 
}
