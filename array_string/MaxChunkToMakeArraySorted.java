public class MaxChunkToMakeArraySorted {
    class Solution {
        public int maxChunksToSorted(int[] arr) {
            if(arr.length <= 0){
                return 0;
            }
            int cnt = 0;
            int maxTillNow = arr[0];
            for(int i=0; i<arr.length; i++){
                maxTillNow = Math.max(arr[i], maxTillNow);
                if(maxTillNow == i){
                    cnt++;
                }
            }
    
            return cnt;
        }
    }
}
