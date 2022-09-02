class Solution {
    Set<List<Integer>> res = new HashSet<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        recursion(0, nums);
        return new ArrayList<>(res);
    }
    
    void recursion(int i, int[] nums) {
        if(i == nums.length) {
            List<Integer> list = new ArrayList<>();
            for(int j : nums) list.add(j);
            res.add(new ArrayList<>(list));
            return;
        }
        
        for(int x = i; x < nums.length; x++){
            swap(i, x, nums);
            recursion(i+1, nums);
            swap(i, x, nums);
        }
    }
    
    void swap(int i, int x, int[] nums){
        int temp = nums[i];
        nums[i] = nums[x];
        nums[x] = temp;
        return;
    }
}