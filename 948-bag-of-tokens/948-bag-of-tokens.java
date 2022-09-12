class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
                Arrays.sort(tokens);
        int index = 0;
        int end = tokens.length-1;
        int res = 0;
        if(end < 0 || power < tokens[index]) return res;
        while(index <= end){
            int token = tokens[index];
            if(token <= power){
                res++;
                power -= token;
            }else{
                if(end - index >= 2){
                    power += tokens[end--];
                    power -= token;
                }
            }   
            index++;
        }
        return res;
    }
}