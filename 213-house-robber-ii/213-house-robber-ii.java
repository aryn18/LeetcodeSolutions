class Solution {
    public int rob(int[] nums) {
        if(nums.length==1)return nums[0];
        int start=0;
        int end=nums.length-1;
        int anslast=robbing(nums,start,end-1);
        int ansstart=robbing(nums,start+1,end);
        return Math.max(anslast,ansstart);
    }
    
    public int robbing(int[] nums,int start,int end) {
        int prev2=0;
        int prev1=nums[start];
        for(int i=start+1;i<=end;i++){
            int pick=nums[i]+prev2;
            int notpick=0+prev1;
            prev2=prev1;
            prev1=Math.max(pick,notpick);
        }
        return prev1;
    }
}