public class MaximumNumbersToChooseInARange {
    class Solution {
        public int maxCount(int[] banned, int n, int maxSum) {
            HashSet<Integer> set = new HashSet<>();
            for(int i=0; i<banned.length; i++){
                set.add(banned[i]);
            }
            int currSum = 0;
            int selectedNum = 0;
            for(int i=1; i<=n; i++){
                if(set.contains(i)){
                    continue;
                }
                currSum += i;
                if(currSum > maxSum){
                    return selectedNum;
                }
                selectedNum++;
            }
    
            return selectedNum;
        }
    }
}
