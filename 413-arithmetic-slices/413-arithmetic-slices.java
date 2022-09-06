class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if( nums.length < 3)
    {
        return 0 ;
    }
   
    int count = 0 ;
    int curr = 0 ;
    int globalCount  =0 ;
    int i = 0 ;
    int diff= nums[1]-nums[0] ;
    
   while ( i < nums.length-1)
   {
            if( nums[i+1]-nums[i] == diff )
            {
                    
            count = count +1 ;
                
                
            } 
            else {
              
                if( count >= 1)
                {
                    curr= count+1;
                    globalCount = globalCount+ ( curr* ( curr+1)) / 2-(2*curr)+1;

                }
                
                count = 1 ;
                diff = nums[i+1]-nums[i];
            }
   i++ ;
    }
    
    
    if( count >= 1)
        {
             curr= count+1;
              globalCount = globalCount+ ( curr* ( curr+1)) / 2-(2*curr)+1;
                    
        }
            
    
    return globalCount;
    
    }
}