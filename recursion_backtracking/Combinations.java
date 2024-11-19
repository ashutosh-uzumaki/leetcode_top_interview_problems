public class Combinations {
    class Solution {
        List<List<Integer>> combinations;
        public List<List<Integer>> combine(int n, int k) {
            combinations = new ArrayList<>();
            helper(1, n, k, new ArrayList<>());
            return combinations;
        }
    
        public void helper(int idx, int n, int k, List<Integer> currCombination){
            if(currCombination.size() == k){
                combinations.add(new ArrayList<>(currCombination));
                return;
            }
    
            for(int i=idx; i<=n; i++){
                currCombination.add(i);
                helper(i+1, n, k, currCombination);
                currCombination.remove(currCombination.size() - 1);
            }
        }
    }
}
