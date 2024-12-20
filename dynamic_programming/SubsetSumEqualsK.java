package dynamic_programming;
import java.util.*;
public class SubsetSumEqualsK {

    static int[][] memo;
    static int mod = (int) 1e9 + 7;
    public static int findWays(int[] num, int tar) {
        memo = new int[num.length][tar + 1];
        for (int i = 0; i < num.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        return helper(0, num, tar) % mod;
    }

    private static int helper(int idx, int[] num, int tar) {
        if(tar < 0){
            return 0;
        }
        if (idx == num.length) {
            if(tar == 0){
                return 1;
            }
            return 0;
        }

        if (memo[idx][tar] != -1) {
            return memo[idx][tar];
        }

        int take = helper(idx + 1, num, tar - num[idx]);
        int notTake = helper(idx + 1, num, tar);

        return memo[idx][tar] = (take + notTake) % mod;
    }
}
