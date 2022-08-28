class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int i = -1;
        int j = -1;
        int sum = 0;
        while(true){
            boolean f1 = false;
            boolean f2 = false;
            while(i<nums.length-1 && sum<target){
                i++;
                sum += nums[i];
                f1 = true;
            }
            while(j<i && sum>=target){
                int pans = i-(j+1)+1;
                if(ans==Integer.MAX_VALUE || pans<ans){
                    ans = pans;
                }
                j++;
                sum -= nums[j];
                f2 = true;
            }
            if(f1==false&&f2==false){
                break;
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}