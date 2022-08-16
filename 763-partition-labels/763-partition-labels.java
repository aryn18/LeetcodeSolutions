class Solution {
    public List<Integer> partitionLabels(String s) {
    HashMap<Character,Integer> map = new HashMap<>();
    for(int i = 0; i<s.length(); i++){
        char ch = s.charAt(i);
        map.put(ch,i);
    }
    List<Integer> ans = new ArrayList<>();
    int prev = -1;
    int max = 0;
    for(int i = 0; i<s.length(); i++){
        char ch = s.charAt(i);
        max = Math.max(max,map.get(ch));
        if(max==i){
            int val = max-prev;
            prev = max;
            ans.add(val);
        }
    }
    
    return ans;
    }
}