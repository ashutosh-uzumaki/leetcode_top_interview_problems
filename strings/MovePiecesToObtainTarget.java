package strings;

public class MovePiecesToObtainTarget {
    class Solution {
        public boolean canChange(String start, String target) {
            int i = 0;
            int j = 0;
            int n = start.length();
            while(i < n || j < n){
                
                while(i < n && start.charAt(i) == '_'){
                    i++;
                }
    
                while(j < n && target.charAt(j) == '_'){
                    j++;
                }
    
                if(i == n || j == n){
                    return i == n && j == n;
                }
    
                if(start.charAt(i) != target.charAt(j)){
                    return false;
                }
    
                if(start.charAt(i) == 'L' && i < j){
                    return false;
                }
    
                if(start.charAt(i) == 'R' && i > j){
                    return false;
                } 
    
                i++;
                j++;
            }
    
            return true;
        }
    }
}

// INTUTION
//CAN SKIP _
// L CAN BE MOVED TO LEFT SO THE CURRENT L POSITION AT START SHOULD BE GREATER THAN L POSITION OF TARGET (I < J -> FALSE) 
// R CAN BE MOVED TO RIGHT SO THE CURRENT R POSITION AT START SHOULD BE LESS THAN R POSITION OF TARGET (I > J -> FALSE)
// WHILE _ SKIPPED AND START[I] != TARGET[J] RETURN FALSE
// IF ANY OF I OR J REACHES THE END AND NOT BOTH THEN IT'S FALSE
