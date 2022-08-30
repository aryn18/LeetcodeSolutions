class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        StringBuilder sb = new StringBuilder();
        
        List<Character> list = new ArrayList<>();
        for (char c : map.keySet()) {
            list.add(c);
        }
        
        Collections.sort(list, new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return -(map.get(o1) - map.get(o2));
            }
        });
        
        for (char c : list) {
            int count = map.get(c);
            while (count > 0) {
                sb.append(c);
                count --;
            }
        }
        
        return sb.toString();
    }
}