class Solution {
    public int longestPalindrome(String s) {
        int[] charCounts = new int [128];
        for(char c : s.toCharArray()){
            charCounts[c]++;
        }
        int res = 0;
        for(Integer charCount : charCounts){
            res += charCount/ 2*2;
            if(res % 2 == 0 && charCount % 2 == 1){
                res += 1;
            }
        }
        return res;
    }
}