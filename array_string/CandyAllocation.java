package array_string;
import java.util.*;
public class CandyAllocation {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);
        if(n == 1){
            return candies[0];
        }

        for(int i=1; i<n; i++){
            if(ratings[i] > ratings[i-1]){
                candies[i] += candies[i-1];
            }
        }

        for(int i=n-2; i>=0; i--){
            if(ratings[i] > ratings[i+1] && candies[i] <= candies[i + 1]){
                candies[i] = candies[i+1] + 1;
            }
        }

        int totalCandies = 0;
        for(int i=0; i<n; i++){
            totalCandies += candies[i];
        }
        return totalCandies;
    }
}

//MISTAKES -> READ THE QUESTION WRONG. 
//HIGHER RATING CANDIDATES SHOULD HAVE HIGHER CANDIES THAN IT'S NEIGHBOURS. INSTEAD OF INCREASING BY 1 WITH NEIGHBOR, I INCREASED BY CANDIES PRESENT WITH THE NEIGHBOR.
