class Solution {
    public static int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int[] output = new int[n];

        // Step 1: Store product of everything on the LEFT
        int leftProduct = 1;

        for (int i = 0; i < n; i++) {
            output[i] = leftProduct;
            leftProduct = leftProduct * nums[i];
        }

        // Step 2: Multiply by product of everything on the RIGHT
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            output[i] = output[i] * rightProduct;
            rightProduct = rightProduct * nums[i];
        }

        return output;
    }
}  
