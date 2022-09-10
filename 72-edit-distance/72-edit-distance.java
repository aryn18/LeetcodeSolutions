class Solution {
    public int minDistance(String str1, String str2) {
    int[][] dp = new int[str1.length()+1][str2.length()+1];
    for(int i = 0; i<dp.length; i++){
        for(int j = 0; j<dp[0].length; j++){
            if(i==0){
                dp[i][j] = j;
            }else if(j==0){
                dp[i][j] = i;
            }else{
                char ch1 = str1.charAt(i-1);
                char ch2 = str2.charAt(j-1);
                if(ch1==ch2){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
                }
            }
        }
    }
    return dp[dp.length-1][dp[0].length-1];
}
}