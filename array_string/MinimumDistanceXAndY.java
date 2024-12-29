public class MinimumDistanceXAndY {
    public class MinimumDistance {
        int minDist(int arr[], int n, int x, int y) {
            // code here
            int xidx = -1;
            int yidx = -1;
            int minimumDistance = Integer.MAX_VALUE;
            for(int i=0; i<n; i++){
                if(arr[i] == x){
                    xidx = i;
                }
                if(arr[i] == y){
                    yidx = i;
                }
                
                if(xidx != -1 && yidx != -1){
                    minimumDistance = Math.min(Math.abs(xidx - yidx), minimumDistance);
                }
            }
            if(xidx == -1 || yidx == -1){
                return -1;
            }
            return minimumDistance;
        }
    }
    
}
