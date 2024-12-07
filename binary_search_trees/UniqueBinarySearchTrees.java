package binary_search_trees;

public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for(int i=2; i<=n; i++){
            for(int j=0; j<i; j++){
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }
}

// dp[j] -> left subtree
// dp[i - j - 1] -> right subtree
// catalan numbers
// dp[i] -> number of possible trees at ith number
