package sliding_window;

public class DefuseTheBomb {
    class Solution {
        public int[] decrypt(int[] code, int k) {
            int n = code.length;
            int[] res = new int[n];
            if(k == 0){
                return res;
            }
            int i = -1;
            int j = -1;
            if(k > 0){
                i = 1;
                j = k;
            }else{
                i = n - Math.abs(k);
                j = n - 1;
            }
            int windowSum = 0;
            for(int ptr=i; ptr <= j; ptr++){
                windowSum += code[ptr];
            }
    
            for(k=0; k<n; k++){
                res[k] = windowSum;
    
                windowSum -= code[i % n];
                i++;
    
                windowSum += code[(j+1)%n];
                j++;
            }
    
            return res;
        }
    }
}

// FOR -VE K START = N - MATH.ABS(K) AS FOR PREVIOUS K ELEMENTS THE ELEMENTS START FROM N-1, N-2, N-3 ... K
// WHY WINDOWSUM += CODE[(J+1) % N] -> J MARKS THE END OF CURRENT WINDOW.
