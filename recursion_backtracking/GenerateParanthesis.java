import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {
    class Solution {
    List<String> generatedParanthesis = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        helper(0, 0, n, new StringBuilder());
        return generatedParanthesis;
    }

    public void helper(int open, int close, int n, StringBuilder curr) {
        if (curr.length() == 2 * n) {
            generatedParanthesis.add(curr.toString());
            return;
        }

        if (open < n) {
            curr.append('(');
            helper(open + 1, close, n, curr);
            curr.deleteCharAt(curr.length() - 1);
        }

        if (close < open) {
            curr.append(')');
            helper(open, close + 1, n, curr);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}
}
