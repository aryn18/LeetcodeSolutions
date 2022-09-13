class Solution {
    public boolean isHappy(int n) {
        if(n == 1)return true;
        
        HashSet<Integer> set = new HashSet();
        set.add(n);
        
        while(true){
            int num = 0;
            while(n > 0){
                int r = n%10;
                num += r*r;
                n = n/10;
            }
            
            if(num == 1)return true;
            
            if(set.contains(num)) break;
            
            n = num;
            set.add(n);

        }
        
        return false;
    }
}