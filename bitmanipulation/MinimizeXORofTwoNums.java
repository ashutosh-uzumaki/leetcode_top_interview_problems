package bitmanipulation;

public class MinimizeXORofTwoNums {
    class Solution {
        public int minimizeXor(int num1, int num2) {
            int setBitCount = getSetBitCount(num2);
            int result = 0;
            for(int i=31; i>=0 && setBitCount > 0; i--){
                if((num1 & (1 << i)) != 0){
                    result |= (1 << i);
                    setBitCount--;
                }
            }
    
            for(int i=0; i<32 && setBitCount > 0; i++){
                if((result & (1 << i)) == 0){
                    result |= (1 << i);
                    setBitCount--;
                }
            }
            return result;
        }
    
        public int getSetBitCount(int num){
            int cnt = 0;
            while(num > 0){
                cnt ++;
                num = num & (num - 1);
            }
            return cnt;
        }
    }
}

//INTUTION -> TO PLACE M SET COUNT BITS IN X, ALWAYS PLACE THEM WHERE THERE ARE SET BITS IN NUM1 FROM HIGHER POSITION
//IF THERE ARE SOME LEFT SET BITS, PLACE THEM FROM LOWER BITS.
