package sliding_window;

public class MinimumPenaltyForShopPrefixSum {
    class Solution {
        public int bestClosingTime(String customers) {
            int n = customers.length();
            int[] prefix = new int[n + 1];
            int[] suffix = new int[n + 1];
    
            for(int i=1; i<=n; i++){
                char c = customers.charAt(i - 1);
                if(c == 'N'){
                    prefix[i] = prefix[i - 1] + 1;
                }else{
                    prefix[i] = prefix[i - 1];
                }
            }
    
            for(int i=n-1; i>=0; i--){
                char c = customers.charAt(i);
                if(c == 'Y'){
                    suffix[i] = suffix[i + 1] + 1;
                }else{
                    suffix[i] = suffix[i + 1];
                }
            }
    
            int minPenality = Integer.MAX_VALUE;
            int minHourPenality = n;
            for(int i=0; i<n; i++){
                if(minPenality > prefix[i] + suffix[i]){
                    // System.out.println(minPenality+" "+i);
                    minHourPenality = i;
                    minPenality = prefix[i] + suffix[i];
                }
            }
            System.out.println(minPenality);
            if(minPenality >  prefix[n - 1]){
                minHourPenality = n;
            }
            return minHourPenality;
        }
    }
}
