class Solution {
    public boolean check(int a[], int b[]) {
        for(int i = 0; i < 26; i ++) {
            if(a[i] != b[i])
                return false;
        }
        return true;
    }
    public List<Integer> findAnagrams(String s, String p) {
        int arr[] = new int[26];
        List<Integer> ans = new ArrayList<>();
        for(int i = 0 ; i < p.length(); i ++)
            arr[p.charAt(i) - 'a'] ++;
        int start = 0, end = 0;
        int ch[] = new int[26];
        while(end < s.length()) { 
            ch[s.charAt(end) - 'a'] ++;
            if(end < p.length()-1)
                end ++;
            else {
                if(check(ch, arr))
                    ans.add(start);
                ch[s.charAt(start) - 'a'] --;
                start ++;
                end ++;
            }
        }
        return ans;
    }
}