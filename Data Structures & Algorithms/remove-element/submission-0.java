class Solution {
    public int removeElement(int[] nums, int val) {

        int right = nums.length - 1;
        int i = 0;

        while( i <= right){
            if(nums[i] == val){
                nums[i] = nums[right];
                right--;
            }else{
                i++;
            }
        }

        return right+1;
        
    }
}