package array_string;

public class ProductArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        result[0] = 1;
        int product = nums[0];
        for(int i=1; i<n; i++){
            result[i] = product;
            product *= nums[i];
        }

        product = 1;
        for(int i=n-1; i>=0; i--){
            result[i] *= product;
            product *= nums[i];
        }

        return result;
    }
}
