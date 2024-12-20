package strings;

public class MinimumStepsToConvertXtoO {
    class Solution {
        public int minimumMoves(String s) {
            //whenever we encounter we change the next 3 consectuive chars to 'O' and move our i to after 3.
    
            int i = 0;
            int opsRequired = 0;
            while(i < s.length()){
                if(s.charAt(i) == 'X'){
                    opsRequired += 1;
                    i += 3;
                }else{
                    i+=1;
                }
            }
    
            return opsRequired;
        }
    }
}
