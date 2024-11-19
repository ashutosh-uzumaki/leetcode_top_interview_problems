public class NQueesTwo {
    class Solution {
        int solutionPossible = 0;
        public int totalNQueens(int n) {
            char[][] board = new char[n][n];
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    board[i][j] = '.';
                }
            }
    
            helper(0, board, n);
            return solutionPossible;
        }
    
        public void helper(int col, char[][] board, int n){
            if(col == n){
                solutionPossible += 1;
                return;
            }
    
            for(int row=0; row<n; row++){
                if(isSafe(row, col, board)){
                    board[row][col] = 'q';
                    helper(col + 1, board, n);
                    board[row][col] = '.';
                }
            }
        }
    
        public boolean isSafe(int row, int col, char[][] board){
            int dupRow = row;
            int dupCol = col;
    
            while(dupRow >= 0 && dupCol >= 0){
                if(board[dupRow][dupCol] == 'q'){
                    return false;
                }
                dupRow--;
                dupCol--;
            }
    
            dupRow = row;
            dupCol = col;
    
            while(dupCol >= 0){
                if(board[dupRow][dupCol] == 'q'){
                    return false;
                }
                dupCol--;
            }
    
            dupRow = row;
            dupCol = col;
    
            while(dupRow < board.length && dupCol >= 0){
                if(board[dupRow][dupCol] == 'q'){
                    return false;
                }
                dupRow++;
                dupCol--;
            }
    
            return true;
        }
    }
}
