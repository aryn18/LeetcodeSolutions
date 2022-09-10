class Solution {
    int dp[];
    public int recur(int amount, int coins[])
    {
        if(amount == 0)
        {
            return 0;
        }
        
        if(dp[amount]!= -1)
        {
            return dp[amount];
        }
        
        int currentAns = (int)(1e9);
        
        for(int i=0;i<coins.length;i++)
        {
            if(amount>=coins[i])
            {
                int currentNumberOfCoins = 1+recur(amount-coins[i], coins);
                currentAns = Math.min(currentAns, currentNumberOfCoins);
            }
        }
        
        dp[amount] = currentAns;
        return currentAns;
    }
    public int coinChange(int[] coins, int amount) {
        dp = new int[amount+1];
        Arrays.fill(dp,-1);
        int ans = recur(amount, coins);
        if(ans == (int)(1e9))
        {
            ans = -1;
        }
        return ans;
    }
}