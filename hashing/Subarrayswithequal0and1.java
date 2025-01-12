public class Subarrayswithequal0and1 {
    class Solution
{
    //Function to count subarrays with 1s and 0s.
    static int countSubarrWithEqualZeroAndOne(int arr[], int n)
    {
        // add your code here
        HashMap<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0, 1);
        int runningSum = 0;
        int count = 0;
        for(int num: arr){
            runningSum = num == 0 ? runningSum - 1 : runningSum + 1;
            if(prefixSum.containsKey(runningSum)){
                count += prefixSum.get(runningSum);
            }
            prefixSum.put(runningSum, prefixSum.getOrDefault(runningSum, 0) + 1);
        }
        return count;
    }
}

}
