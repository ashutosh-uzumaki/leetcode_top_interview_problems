package strings;
public class ShiftingLetters {
    class Solution {
        public String shiftingLetters(String s, int[][] shifts) {
            int n = s.length();
            int[] diff = new int[n];
            for(int[] shift: shifts){
                int left = shift[0];
                int right = shift[1];
                int dir = shift[2];
    
                int x = 1;
                if(dir == 0){
                    x = -1;
                }
    
                diff[left] += x;
                if(right + 1 < n){
                    diff[right + 1] -= x;
                }
            }
    
            for(int i=1; i<n; i++){
                diff[i] = diff[i-1] + diff[i];
            }
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<n; i++){
                int shift = diff[i] % 26;
                if(shift < 0){
                    shift += 26;
                }
    
              char ch = (char)(((s.charAt(i) - 'a') + shift) % 26 + 'a');
            //   System.out.println(ch);
              sb.append(ch); 
            }
    
            return sb.toString();
        }
    }
}
