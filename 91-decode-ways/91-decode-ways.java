class Solution {
    private int dp[];
    public int numDecodings(String s) {
        dp=new int[s.length()];
        Arrays.fill(dp, -1);
        return util(s, 0);
    }
    
    public int util(String s, int i) {
        if(i==s.length()) return 1;
        else if(i>s.length()) return 0;
        
        if(dp[i]!=-1) return dp[i];
        
        char ch=s.charAt(i);
        if(ch-'0'==0) return dp[i]=0; //leading zero
        if(ch-'0'==1){
            return dp[i]=util(s, i+1)+util(s, i+2);
        }else if(ch-'0'==2){
            if(i+1<s.length()) {
                char next=s.charAt(i+1);
                if(0<=next-'0' && next-'0'<=6) {
                    return dp[i]=util(s, i+1)+util(s, i+2);
                }else {
                    return dp[i]=util(s, i+1);
                }
            }else {
                return dp[i]=util(s, i+1);
            }
        }else {
            return dp[i]=util(s, i+1);
        }
    }
}