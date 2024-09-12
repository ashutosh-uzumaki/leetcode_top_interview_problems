package two_pointers;

public class ContainerWithMostWater {
    class Solution {
        public int maxArea(int[] height) {
            int i = 0;
            int j = height.length - 1;
            int maxAmount = Integer.MIN_VALUE;
    
            while(i < j){
                if(height[i] < height[j]){
                    int currAmount = (height[i]) * (j - i);
                    i++;
                    maxAmount = Math.max(currAmount, maxAmount);
                }else{
                    int currAmount = (height[j]) * (j - i);
                    j--;
                    maxAmount = Math.max(currAmount, maxAmount);
                }
            }
    
            return maxAmount;
        }
    }
}
