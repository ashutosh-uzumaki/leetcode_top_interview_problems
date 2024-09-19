package matrix;

public class GameLife {
    class Solution {
        public void gameOfLife(int[][] board) {
            int rows = board.length;
            int cols = board[0].length;
            int[][] lifeBoard = new int[rows][cols];
    
            for(int i=0; i<rows; i++){
                for(int j=0; j<cols; j++){
                    int[] cntOfLiveAndDead = count(i, j, board);
                    int deadCnt = cntOfLiveAndDead[0];
                    int liveCnt = cntOfLiveAndDead[1];
                    if(board[i][j] == 1 && liveCnt < 2){
                        lifeBoard[i][j] = 0;
                    }else if(board[i][j] == 1 && liveCnt >= 2 && liveCnt <= 3){
                        lifeBoard[i][j] = 1;
                    }else if(board[i][j] == 1 && liveCnt > 3){
                        lifeBoard[i][j] = 0;
                    }else if(board[i][j] == 0 && liveCnt == 3){
                        lifeBoard[i][j] = 1;
                    }
                }
            }
            for(int i=0; i<rows; i++){
                for(int j=0; j<cols; j++){
                    // System.out.print(lifeBoard[i][j]+" ");
                    board[i][j] = lifeBoard[i][j];
                }
                // System.out.println();
            }
            board = lifeBoard;
        }
        public int[] count(int i, int j, int[][] board){
            int zeros = 0, ones = 0;
            if(i-1 >= 0){
                if(board[i-1][j] == 0){
                    zeros++;
                }else{
                    ones++;
                }
            }
            if(j-1 >= 0){
                if(board[i][j-1] == 0){
                    zeros++;
                }else{
                    ones++;
                }
            }
            if(i+1<board.length){
                if(board[i+1][j] == 0){
                    zeros++;
                }else{
                    ones++;
                }
            }
            if(j+1<board[0].length){
                if(board[i][j+1] == 0){
                    zeros++;
                }else{
                    ones++;
                }
            }
            if(i-1 >= 0 && j - 1 >= 0){
                if(board[i-1][j-1] == 0){
                    zeros++;
                }else{
                    ones++;
                }
            }
            if(i+1 < board.length && j+1 < board[0].length){
                if(board[i+1][j+1] == 0){
                    zeros++;
                }else{
                    ones++;
                }
            }
            if(i-1 >= 0 && j+1 < board[0].length){
                if(board[i-1][j+1] == 0){
                    zeros++;
                }else{
                    ones++;
                }
            }
    
            if(j-1 >= 0 && i+1 < board.length){
                if(board[i+1][j-1] == 0){
                    zeros++;
                }else{
                    ones++;
                }
            }
            return new int[]{zeros, ones};
        }
    }
}
