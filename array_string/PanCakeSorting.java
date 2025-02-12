import java.util.ArrayList;
import java.util.List;

public class PanCakeSorting {
    class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> flipsRequired = new ArrayList<>();
        int n = arr.length;

        for(int i=n-1; i>=0; i--){
            int maxEleIdx = i;
            for(int j=i-1; j>=0; j--){
                if(arr[j] > arr[maxEleIdx]){
                    maxEleIdx = j;
                }
            }

            if(maxEleIdx != i){
                flipsRequired.add(maxEleIdx + 1);
                reverseArray(arr, 0, maxEleIdx);
                reverseArray(arr, 0, i);
                flipsRequired.add(i + 1);
            }
        }    
        return flipsRequired;
    }

    public void reverseArray(int[] arr, int start, int end){
        while(start <= end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

}
}

//intution -> prefix sorting, put the max ele at it's correct position
// step 1 -> find th max position
// step 2 -> bring it to front
// step 3 -> now put at i

