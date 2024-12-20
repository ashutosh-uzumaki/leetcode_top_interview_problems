package hashing;

import java.util.Arrays;

public class CommonPrefixOfTwoArrays {
    class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] cnt = new int[51];
        Arrays.fill(cnt, 0);
        int[] ans = new int[A.length];
        int prefixCnt = 0;
        for(int i=0; i<A.length; i++){
            if(A[i] == B[i]){
                prefixCnt++;
            }else{
                if(cnt[A[i]] != 0){
                    prefixCnt++;
                }
                if(cnt[B[i]] != 0){
                    prefixCnt++;
                }
            }
            cnt[A[i]]++;
            cnt[B[i]]++;
            ans[i] = prefixCnt;
        }
        return ans;
    }
}
}
