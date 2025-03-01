public class KMPAlgorithm {
    class Solution {

        ArrayList<Integer> search(String pat, String txt) {
            // your code here
            ArrayList<Integer> indices = new ArrayList<>();
            int m = pat.length();
            int[]LPS = new int[m];
            int i = 1;
            int length = 0;
            
            while(i < m){
                if(pat.charAt(length) == pat.charAt(i)){
                    length += 1; i+=1;
                    LPS[i] = length;
                }else{
                    if(length != 0){
                        LPS[i] = LPS[length - 1];
                    }else{
                        LPS[i] = 0;
                        i += 1;
                    }
                }
            }
            
            
            int j =0;
            i = 0;
            int n = txt.length();
            while(j < n){
                while(i < m && j < n && pat.charAt(i) == txt.charAt(j)){
                    i += 1;
                    j += 1;
                }
                
                if (i == m) {  
                    indices.add(j - i); 
                    i = LPS[i - 1]; 
                } else if (j < n && pat.charAt(i) != txt.charAt(j)) {  
                    if (i != 0) {
                        i = LPS[i - 1];  
                    } else {
                        j++;  
                    }
                }
            }
            return indices;
        }
    } 
}
