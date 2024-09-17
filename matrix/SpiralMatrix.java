package matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;
        int top = 0, bottom = rows-1, left = 0, right = cols-1;
        int direction = 0;
        while(top <= bottom && left <= right){
            if(direction == 0){
                for(int i=left; i<=right; i++){
                    ans.add(matrix[top][i]);
                }
                top++;
            }else if(direction == 1){
                for(int i=top; i<=bottom; i++){
                    ans.add(matrix[i][right]);
                }
                right--;
            }else if(direction == 2){
                for(int i=right; i>=left; i--){
                    ans.add(matrix[bottom][i]);
                }
                bottom--;
            }else{
                for(int i=bottom; i>=top; i--){
                    ans.add(matrix[i][left]);
                }
                left++;
            }
            direction = (direction + 1) % 4;
        }
        return ans;
    }
}
}
