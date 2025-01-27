import java.util.Arrays;

public class CountInversionCount {
    class Solution {
    // arr[]: Input Array
    // N : Size of the Array arr[]
    // Function to count inversions in the array.
    static long inversionCount(long arr[], int n) {
        // Your Code Here
        return mergeSort(arr, 0, n-1);
    }
    
    static long mergeSort(long[] arr, int start, int end){
        long count = 0;
        
        if(start < end){
            int mid = start + (end - start)/2;
            count += mergeSort(arr, start, mid);
            count += mergeSort(arr, mid+1, end);
            count += merge(arr, start, mid, end);
        }
        return count;
    }
    
    static long merge(long[] arr, int start, int mid, int end){
        long[] left = Arrays.copyOfRange(arr, start, mid + 1);
        long[] right = Arrays.copyOfRange(arr, mid + 1, end + 1);
        int i = 0, j = 0, k = start;
        long swaps = 0;
        while(i < left.length && j < right.length){
            if(left[i] <= right[j]){
                arr[k++] = left[i++];
            }else{
                arr[k++] = right[j++];
                swaps += (mid - i + 1 - start);
            }
        }
        while(i < left.length){
            arr[k++] = left[i++];
        }
        
        while(j < right.length){
            arr[k++] = right[j++];
        }
        return swaps;
    }
}
}
