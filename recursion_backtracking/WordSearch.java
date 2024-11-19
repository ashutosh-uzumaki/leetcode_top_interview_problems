public class WordSearch {
    class Solution {
        int n;
        int rows;
        int cols;
        boolean[][] visited;
        char[][] board;
        String word;
        public boolean exist(char[][] board, String word) {
            n = word.length();
            rows = board.length;
            cols = board[0].length;
            this.board = board;
            this.word = word;
            visited = new boolean[rows][cols];
            for(int row=0; row < rows; row++){
                for(int col=0;  col < cols; col++){
                    if(board[row][col] == word.charAt(0)){
                        if(wordExistsHelper(row, col, 0)){
                            return true;
                        }
                    }
                }
            }
            return false;
        }
    
        public boolean wordExistsHelper(int row, int col, int idx){
            if(idx == n){
                return true;
            }
            if(row >= rows || col >= cols || row < 0 || col < 0 || visited[row][col]){
                return false;
            }
            System.out.println(row+" "+col+" "+idx);
            visited[row][col] = true;
            if(word.charAt(idx) == board[row][col]){
                idx++;
            }
            boolean right = (col + 1) < cols ? wordExistsHelper(row, col + 1, idx) : false;
            boolean down = (row + 1) < rows ? wordExistsHelper(row + 1, col, idx) : false;
            boolean up = (row >= 0) ? wordExistsHelper(row - 1, col, idx) : false;
            boolean left = (col >= 0) ? wordExistsHelper(row, col - 1, idx) : false;
            visited[row][col] = false;
            return (down || right || up || left);
        }
    }
}
