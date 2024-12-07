package binary_searcch;

import java.util.ArrayList;

public class PaintersPartition {
    
    public static int findLargestMinDistance(ArrayList<Integer> boards, int k)
    {
        //    Write your code here.
        int low = 0;
        int high = 0;
        for(int ele: boards){
            high += ele;
            low = Math.max(low, ele);
        }
        int res = Integer.MAX_VALUE;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(isPossible(mid, boards, k)){
                res = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return res;
    }

    public static boolean isPossible(int timeReq, ArrayList<Integer> boards, int k){
        int painters = 1;
        long boardsPainted = 0;

        for(int ele: boards){
            if(boardsPainted + ele <= timeReq){
                boardsPainted += ele;
            }else{
                painters += 1;
                boardsPainted = ele;

                if(painters > k){
                    return false;
                }
            }
        }

        return true;
    }
}

