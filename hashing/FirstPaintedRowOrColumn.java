package hashing;
import java.util.*;
public class FirstPaintedRowOrColumn {
    class Solution {
        public int firstCompleteIndex(int[] arr, int[][] mat) {
            HashMap<Integer, Integer> paintTime = new HashMap<>();
    
            for(int i=0; i<arr.length; i++){
                paintTime.put(arr[i], i);
            }
            int m = mat.length;
            int n = mat[0].length;        
            int minTime = Integer.MAX_VALUE;
            for(int i=0; i<m; i++){
                int rowMax = Integer.MIN_VALUE;
                for(int j=0; j<n; j++){
                    rowMax = Math.max(rowMax, paintTime.get(mat[i][j]));
                }
                minTime = Math.min(minTime, rowMax);
            }
    
            for(int j=0; j<n; j++){
                int colMax = Integer.MIN_VALUE;
                for(int i=0; i<m; i++){
                    colMax = Math.max(colMax, paintTime.get(mat[i][j]));
                }
                minTime = Math.min(minTime, colMax);
            }
    
            return minTime;
    
        }
    }
}
