class Solution {
    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high){
            int n = nums[mid];

            if(n == 0){
                swap(nums, low, mid);
                low++;
                mid++;
            }else if(n == 1){
                mid++;
            }else if(n==2){
                swap(nums, mid, high);
                high--;
            }
        }
    }

    private void swap(int[] nums, int x, int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}