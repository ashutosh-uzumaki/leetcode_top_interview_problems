package matrix;

public class ValidSudokuBruteForce {
    class Solution {
        public boolean isValidSudoku(char[][] board) {
            boolean checkRows = validateRows(board);
            boolean checkCols = validateCols(board);
            boolean checkBox = validateBoxes(board);
    
            return checkRows && checkCols && checkBox;
        }
    
        public boolean validateRows(char[][] board){
            for(int i=0; i<9; i++){
                int[] cnt = new int[10];
                for(int j=0; j<9; j++){
                    if(board[i][j] == '.'){
                        continue;
                    }
                    if(cnt[board[i][j] - '0'] != 0){
                        return false;
                    }
                    cnt[board[i][j] - '0'] += 1;
                }
            }
            return true;
        }
    
        public boolean validateCols(char[][] board){
            for(int j=0; j<9; j++){
                int[] cnt = new int[10];
                for(int i=0; i<9; i++){
                    if(board[i][j] == '.'){
                        continue;
                    }
                    if(cnt[board[i][j] - '0'] != 0){
                        return false;
                    }
                    cnt[board[i][j] - '0'] += 1;
                }
            }
            return true;
        }
    
        public boolean validateBoxes(char[][] board){
            for(int startRow = 0; startRow < 7; startRow += 3){
                int endRow = startRow + 2;
                for(int startCol = 0; startCol < 7; startCol += 3){
                    int endCol = startCol + 2;
                    if(validateSubBox(board, startRow, endRow, startCol, endCol) == false){
                        return false;
                    }
                }
            }
            return true;
        }
    
        public boolean validateSubBox(char[][] board, int startRow, int endRow, int startCol, int endCol){
            int[] cnt = new int[10];
            for(int i=startRow; i<=endRow; i++){
                for(int j=startCol; j<=endCol; j++){
                    if(board[i][j] == '.'){
                        continue;
                    }
                    if(cnt[board[i][j]-'0'] != 0){
                        return false;
                    }
                    cnt[board[i][j]-'0'] += 1;
                }
            }
            return true;
        }
    
    }
}

//MISTAKE - IN VALIDATE SUB BOX, PUT ENDROW FOR STARTCOL
