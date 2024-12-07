package binary_searcch;

public class MedianInAMatrix {
    

//User function Template for Java

class Solution {
    int median(int matrix[][], int R, int C) {
        // code here
        int left = 0, right = (int)1e9;
        int median = 0;
        int size = R * C;
        while(left <= right){
            int mid = left + (right - left) / 2;
            int totalEle = 0;
            for(int row=0; row<R; row++){
                totalEle += countPossible(matrix, row, mid);
            }
            if(totalEle > size / 2){
                median = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return median;
    }
    
    int countPossible(int[][] matrix, int row, int target){
        int left = 0, right = matrix[0].length - 1;
        int ele = -1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(matrix[row][mid] <= target){
                ele = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return ele + 1;
    }
}
}
