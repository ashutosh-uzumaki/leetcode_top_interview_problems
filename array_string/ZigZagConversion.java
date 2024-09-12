public class ZigZagConversion {
    class Solution {
        public String convert(String s, int numRows) {
            StringBuilder[] sb = new StringBuilder[numRows];
            for(int i=0; i<numRows; i++){
                sb[i] = new StringBuilder();
            }
            if(numRows == 1){
                return s;
            }
            int i = 0;
            while(i < s.length()){
                for(int idx = 0; idx < numRows && i < s.length(); idx++){
                    sb[idx].append(s.charAt(i++));
                }
    
                for(int idx = numRows - 2; idx >= 1 && i < s.length(); idx--){
                    sb[idx].append(s.charAt(i++));
                }
            }
    
            for(i=1; i<sb.length; i++){
                sb[0].append(sb[i]);
            }
    
            return sb[0].toString();
        }
    }
}
