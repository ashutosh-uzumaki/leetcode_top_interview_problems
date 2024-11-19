import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    class Solution {
    List<List<Integer>> combinations;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        combinations = new ArrayList<>();
        solve(candidates, 0, 0, target, new ArrayList<>());
        return combinations;
    }

    public void solve(int[] candidates, int idx, int sum, int target, List<Integer> currentCombination) {
        if (sum == target) {
            combinations.add(new ArrayList<>(currentCombination));
            return;
        }

        if (sum > target || idx == candidates.length) {
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            currentCombination.add(candidates[i]);
            solve(candidates, i, sum + candidates[i], target, currentCombination);
            currentCombination.remove(currentCombination.size() - 1);
        }
    }
}

}
