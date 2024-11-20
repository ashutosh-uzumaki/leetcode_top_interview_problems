package greedy;

import java.util.Arrays;

public class BagOfTokens {
    class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int i = 0;
        int j = tokens.length - 1;
        int maxScore = 0;
        int score = 0;
        while(i <= j){
            if(power >= tokens[i]){
                power -= tokens[i];
                score += 1;
                maxScore = Math.max(score, maxScore);
                i+=1;
            }else if(score >= 1){
                power += tokens[j];
                score -= 1;
                j-=1;
            }else{
                return maxScore;
            }
        }
        return maxScore;
    }
}
}
