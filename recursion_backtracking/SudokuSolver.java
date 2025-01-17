public class SudokuSolver {
    class Solution {
        public void solveSudoku(char[][] board) {
            solve(board);
        }
        public boolean solve(char[][] board){
            for(int i = 0; i<board.length; i++){
                for(int j=0; j<board[0].length; j++){
                    if(board[i][j] == '.'){
                        for(char ch = '1'; ch <= '9'; ch++){
                            if(isSafeToPlace(board, i, j, ch)){
                                board[i][j] = ch;
                                if(solve(board)){
                                    return true;
                                }else{
                                    board[i][j] = '.';
                                }
                            }
                        }
                        return false;
                    }
                }
            }
            return true;
        }
    
        public boolean isSafeToPlace(char[][] board, int row, int col, char c){
            for(int i=0; i<9; i++){
                if(board[row][i] == c){
                    return false;
                }
    
                if(board[i][col] == c){
                    return false;
                }
    
                if(board[3 * (row/3) + i/3][3*(col/3) + i%3] == c){
                    return false;
                }
            }
            return true;
        }
    }
}
