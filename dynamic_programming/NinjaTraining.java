package dynamic_programming;

public class NinjaTraining {
    public class Solution {
        public static int ninjaTraining(int n, int points[][]) {
    
            // Write your code here..
            return helper(n-1, 3, points);
        }
    
        public static int helper(int day, int task, int[][] points){
            if(day == 0){
                int maximumPoints = 0;
                for(int i=0; i<3; i++){
                    if(i != task){
                        maximumPoints = Math.max(maximumPoints, points[0][i]);
                    }
                }
                return maximumPoints;
            }
    
            int maximumScore = 0;
            for(int i=0; i<3; i++){
                if(i != task){
                    int currScore = points[day][i] + helper(day - 1, i, points);
                    maximumScore = Math.max(maximumScore, currScore);
                }
            }
    
            return maximumScore;
        }
    
    }
}
