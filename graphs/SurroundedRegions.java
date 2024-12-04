package graphs;

public class SurroundedRegions {
    class Solution {
        char[][] board;
        int m;
        int n;
        public void solve(char[][] board) {
            m = board.length;
            n = board[0].length;
            this.board = board;
    
            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    if(i == 0 || j == 0 || i == m - 1 || j == n - 1){
                        helper(i, j);
                    }
                }
            }
    
            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    if(board[i][j] == '*'){
                        board[i][j] = 'O';
                    }else{
                        board[i][j] = 'X';
                    }
                }
            }
        }
    
        public void helper(int row, int col){
            if(row < 0 || row >= m || col < 0 || col >= n || board[row][col] != 'O'){
                return;
            }
    
            board[row][col] = '*';
            helper(row, col + 1);
            helper(row, col - 1);
            helper(row + 1, col);
            helper(row - 1, col);
        }
    }
}
