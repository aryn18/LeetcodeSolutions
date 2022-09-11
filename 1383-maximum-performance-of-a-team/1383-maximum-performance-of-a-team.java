class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        PriorityQueue<Integer> min_heap = new PriorityQueue<>();
        int[][] worker = new int[n][2];
        for (int i = 0; i < n; i++) worker[i] = new int[] {efficiency[i], speed[i]};
        Arrays.sort(worker, (a, b) -> Integer.compare(b[0], a[0]));
        
        long sum_of_speed = 0, performance = 0;
        for (int[] pair : worker) {
            int curr_speed = pair[1];
            min_heap.add(curr_speed);
            if (min_heap.size() <= k) sum_of_speed += curr_speed;
            else sum_of_speed += curr_speed - min_heap.poll();
            performance = Math.max(performance, sum_of_speed * pair[0]);
        }
        return (int)(performance % 1000000007);
    }
}