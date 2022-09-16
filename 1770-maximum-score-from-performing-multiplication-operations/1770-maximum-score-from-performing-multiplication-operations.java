class Solution {
    public int maximumScore(int[] nums, int[] multipliers) {
        int n = nums.length, m = multipliers.length;
        int[][] dp = new int[2][m + 1];
        
        for(int op = m - 1 ; op >= 0 ; op--) {
            for(int left = op ; left >= 0 ; left--) {
                int includeLeft = multipliers[op] * nums[left] + dp[(op + 1) % 2][left + 1];
                int includeRight = multipliers[op] * nums[n - 1 - (op - left)] + dp[(op + 1) % 2][left];
                dp[op % 2][left] = Math.max(includeLeft, includeRight);
            }
        }
        
        return dp[0][0];
    }
}