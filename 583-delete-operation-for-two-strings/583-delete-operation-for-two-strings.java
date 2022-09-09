class Solution {
    
    int longestCommonSubsequence(String text1, String text2) {
        int x = text1.length();
        int y = text2.length();
        int[][] dp = new int[x+1][y+1];
            for(int i=0;i<=x;i++)
                dp[i][0] = 0;

            for(int i=0;i<=y;i++)
                dp[0][i] = 0;

            for(int i=1;i<=x;i++){
                for(int j=1;j<=y;j++){
                    if(text1.charAt(i-1)==text2.charAt(j-1))
                        dp[i][j] = 1+dp[i-1][j-1];
                    else
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }

            return dp[x][y];
    }
    
    public int minDistance(String word1, String word2) {
        int lcs = longestCommonSubsequence(word1,word2);
        
        return (word1.length()-lcs + word2.length() - lcs);
    }
}