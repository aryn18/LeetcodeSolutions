class Solution {
    public int majorityElement(int[] nums) {
        int counter = 1;
        int candidate = nums[0];
        for(int i = 1; i <nums.length; i++){
            if(counter == 0){
                candidate = nums[i];
            }
            if(nums[i] == candidate){
                counter ++;
            }else{
                counter--;
            }
        }
        return candidate;
    }
}