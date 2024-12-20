package hashing;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                String rowHash = board[i][j] + "_ROW_" + i;
                String colHash = board[i][j] + "_COL_" + j;
                String boxHash = board[i][j] + "_BOX_" + (i / 3) + "-" + (j / 3);

                if (seen.contains(rowHash) || seen.contains(colHash) || seen.contains(boxHash)) {
                    return false;
                }

                seen.add(rowHash);
                seen.add(colHash);
                seen.add(boxHash);
            }
        }
        return true;
    }
}
}
