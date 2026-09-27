class Solution {
    public int majorityElement(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num: nums){
            int count = map.getOrDefault(num, 0) + 1;

            map.put(num, count);

            if(count > nums.length/2){
                return num;
            }
        }

        return -1;
    }
}