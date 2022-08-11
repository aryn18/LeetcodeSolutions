class Solution {
    public void sortColors(int[] nums) {
        int R=0, W=0, B=0;
        
        for(int num: nums){
            R += num == 0? 1 : 0;
            W += num == 1? 1 : 0;
            B += num == 2? 1 : 0;
        }
        
        int num, i=0;
        while(R>0 || W>0 || B>0){
            if(R > 0) {num = 0; R--;}
            else if (W > 0){ num = 1; W--;}
            else {num = 2; B--;}
            
            nums[i++] = num;
        }
    }
}