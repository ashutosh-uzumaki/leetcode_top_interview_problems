package greedy;

public class NumberOfTeamsFormed {
    class Solution {
        public int numTeams(int[] rating) {
            int size = rating.length;
            int[] prefixMin = new int[size];
            int[] suffixMax = new int[size];
            int[] prefixMax = new int[size];
            int[] suffixMin = new int[size];
            int teamsFormed = 0;
            for(int i=1; i<size; i++){
                int lesserCnt = 0, greaterCnt = 0;
                for(int j=0; j<i; j++){
                    if(rating[j] < rating[i]){
                        lesserCnt++;
                    }else{
                        greaterCnt++;
                    }
                }
                prefixMin[i] = lesserCnt;
                prefixMax[i] = greaterCnt;
            }
    
            for(int i=size-2; i >= 0; i--){
                int lesserCnt = 0, greaterCnt = 0;
                for(int j=i+1; j<size; j++){
                    if(rating[j] < rating[i]){
                        lesserCnt++;
                    }else{
                        greaterCnt++;
                    }
                }
                suffixMin[i] = lesserCnt;
                suffixMax[i] = greaterCnt;
            }
    
            for(int i=1; i<size-1; i++){
                int left = prefixMin[i];
                int right = suffixMax[i];
    
                teamsFormed += (left * right);
            }
    
            for(int i=size-2; i>0; i--){
                int left = prefixMax[i];
                int right = suffixMin[i];
    
                teamsFormed += (left * right);
            }
    
            return teamsFormed;
        }
    }
}
