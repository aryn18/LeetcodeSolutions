class Solution{
    public boolean checkInclusion(String s1, String s2) {
        
        int map_s1[] = new int[26];
        int map_s2[] = new int[26];
        int left = 0;
        
        for(char c: s1.toCharArray())
            map_s1[c - 'a']++;
        
        for(int right=0; right<s2.length(); right++){
            if(right - left == s1.length()){
                map_s2[s2.charAt(left) - 'a']--;
                left++;
            }
            
            map_s2[s2.charAt(right) - 'a']++;
            
            if(Arrays.equals(map_s1, map_s2))
                return true;
        }
        return false;
    }
}