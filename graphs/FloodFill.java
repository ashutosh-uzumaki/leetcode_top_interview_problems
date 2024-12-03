package graphs;

public class FloodFill {
    class Solution {
        public void dfs(int[][] image, int row, int col, int oldColor, int newColor){
            if(row < 0 || row >= image.length || col < 0 || col >= image[0].length){
                return;
            }
    
            if(image[row][col] != oldColor) return;
    
            image[row][col] = newColor;
            dfs(image, row - 1, col, oldColor, newColor);
            dfs(image, row + 1, col, oldColor, newColor);
            dfs(image, row, col + 1, oldColor, newColor);
            dfs(image, row, col - 1, oldColor, newColor);
        }
        public int[][] floodFill(int[][] image, int sr, int sc, int color) {
            int oldcolor = image[sr][sc];
            if(oldcolor != color){
                dfs(image, sr, sc, oldcolor, color);
            }
            return image;
        }
    }
}
