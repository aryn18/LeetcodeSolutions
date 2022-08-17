class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

		for (int i = 0; i < strs.length; i++) {
			char[] target = strs[i].toCharArray();
			Arrays.sort(target);
			String key = new String(target);

			List<String> list = new ArrayList<>();
			list.add(strs[i]);
		
			if (map.containsKey(key)) {
				list.addAll(map.get(key));
			}
			map.put(key, list);
		}

		return new ArrayList<>(map.values());
    }
}