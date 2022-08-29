class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums)
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> frequencyMap.get(a) - frequencyMap.get(b));
        for (int num : frequencyMap.keySet()) {
            pq.offer(num);
            if (pq.size() > k) pq.poll();
        }

        int[] result = new int[k];
        int i = 0;
        while (!pq.isEmpty()) result[i++] = pq.poll();
        return result;
    }
}