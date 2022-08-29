class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        //  First Approach
        
        // Arrays.sort(nums);
        // return nums[nums.length-k];
        
        // Second Approach
        
        PriorityQueue<Integer> queue = new PriorityQueue<>(k+1);
        for(int i : nums){
            queue.add(i);
            if(queue.size()>k){
                queue.poll();
            }
        }
        return queue.poll();
    }
}