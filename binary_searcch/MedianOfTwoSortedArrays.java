package binary_searcch;

public class MedianOfTwoSortedArrays {
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            if(nums1.length > nums2.length){
                return findMedianSortedArrays(nums2, nums1);
            }
    
            int n = nums1.length;
            int m = nums2.length;
            int totalElements = n + m;
    
            int low = 0;
            int high = n;
            while(low <= high){
                int firstCut = low + (high - low)/2;
                int secondCut = (totalElements + 1) / 2 - firstCut;
    
    
                int leftMax1 = firstCut == 0 ? Integer.MIN_VALUE : nums1[firstCut - 1];
                int leftMax2 = secondCut == 0 ? Integer.MIN_VALUE : nums2[secondCut - 1];
    
                int rightMin1 = firstCut == n ? Integer.MAX_VALUE : nums1[firstCut];
                int rightMin2 = secondCut == m ? Integer.MAX_VALUE : nums2[secondCut];
    
                if(leftMax1 <= rightMin2 && leftMax2 <= rightMin1){
                    if(totalElements % 2 == 1){
                        return Math.max(leftMax1, leftMax2) * 1.0;
                    }else{
                        return (Math.max(leftMax1, leftMax2) + Math.min(rightMin1, rightMin2)) / 2.0;
                    }
                }
                if(leftMax1 > rightMin2){
                    high = firstCut - 1;
                }else{
                    low = firstCut + 1;
                }
            }
            return 0.0;
        }
    }
}

//INTUTION -> DIVIDE THE TWO ARRAYS IN TWO HALVES AND CHECK FOR THEIR VALIDATION WHERE LEFT PART SHOULD BE LESS THAN THEIR RIGHT COUNTER PARTS OF THE OTHER ARRAY.

