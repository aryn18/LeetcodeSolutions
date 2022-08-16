class Solution {
    public boolean wordPattern(String pattern, String s) {
         String[] words = s.split(" ");
    if (words.length != pattern.length())
        return false;
    HashMap<Character,String> map = new HashMap<>();
    HashMap<String, Character> rmap = new HashMap<>();
    for (int i=0; i<words.length; i++){
        String v=words[i];
        char k=pattern.charAt(i);
        if (map.containsKey(k)&&!map.get(k).equals(v)) 
        {return false;}
        map.put(k,v);  
        if(rmap.containsKey(v)&&rmap.get(v)!=k) return false;
            rmap.put(v, k);
    }
    return true;
    }
}