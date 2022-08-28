class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n=nums.length,pro=1,count=0;
        for(int i=0;i<n;i++){
            pro=1;
            for(int j=i;j<n;j++){
                pro*=nums[j];
                if(pro<k){
                    count++;
                }
                else if(pro>=k){
                    break;
                }
            }
        }
        return count;
    }
}