class Solution {
    public int firstUniqChar(String s) {
        int result = Integer.MAX_VALUE;
        int firstOccurIndex = -1;
        for(char c = 'a'; c<='z'; c++){
            firstOccurIndex = s.indexOf(c);
            
            if(firstOccurIndex != -1 && firstOccurIndex == s.lastIndexOf(c)){
                result = Math.min(firstOccurIndex, result);
            }
        }
        if(result == Integer.MAX_VALUE){
            return -1;
        }
        return result;
    }
}