package matrix;

public class SetMatrixZeros {
    class Solution {
        public void setZeroes(int[][] mat) {
            int rows = mat.length;
            int cols = mat[0].length;
            boolean firstRowZero = false;
            boolean firstColZero = false;
            for(int i=0; i<cols; i++){
                if(mat[0][i] == 0){
                    firstRowZero = true;
                }
            }
    
            for(int i=0; i<rows; i++){
                if(mat[i][0] == 0){
                    firstColZero = true;
                }
            }
    
            for(int i=1; i<rows; i++){
                for(int j=1; j<cols; j++){
                    if(mat[i][j] == 0){
                        mat[i][0] = 0;
                        mat[0][j] = 0;
                    }
                }
            }
    
            for(int i=1; i<rows; i++){
                for(int j=1; j<cols; j++){
                    if(mat[i][0] == 0 || mat[0][j] == 0){
                        mat[i][j] = 0;
                    }
                }
            }
    
            if(firstRowZero){
                for(int i=0; i<cols; i++){
                    mat[0][i] = 0;
                }
            }
    
            if(firstColZero){
                for(int i=0; i<rows; i++){
                    mat[i][0] = 0;
                }
            }
        }
    }
}

//MISTAKE -> AFTER MARKING THE ROWS & COLS WITH ZERO, I STARTED WITH 0TH ROW & 0TH COL, BUT I SHOULD HAVE STARTED WITH 1ST ROW AND 1ST COLUMN AND THEN CHECK FOR THE CORRESPONDING 0TH ROW || 0TH COL.
