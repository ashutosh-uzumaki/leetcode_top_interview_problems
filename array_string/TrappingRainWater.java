package array_string;

public class TrappingRainWater {
    public int trap(int[] height) {
        int n = height.length;
        int[] prefixMax = new int[n];
        int[] suffixMax = new int[n];

        prefixMax[0] = height[0];
        suffixMax[n-1] = height[n-1];

        for(int i=1; i<n; i++){
            prefixMax[i] = Math.max(prefixMax[i-1], height[i]);
        }

        for(int i=n-2; i>=0; i--){
            suffixMax[i] = Math.max(suffixMax[i+1], height[i]);
        }

        int totalWaterStored = 0;
        for(int i=1; i<n-1; i++){
            int leftBound = prefixMax[i-1];
            int rightBound = suffixMax[i+1];
            int waterAtCurrentPillar = Math.min(leftBound, rightBound) - height[i];
            if(waterAtCurrentPillar > 0){
                totalWaterStored += waterAtCurrentPillar;
            }
        }

        return totalWaterStored;
    }
}
