class Solution {
    Set<List<Integer>> res = new HashSet<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int i = 0;
        Arrays.sort(nums);
        recursion(i, nums);
        return new ArrayList<>(res);
    }
    
    public void recursion(int i, int[] nums){
        if(i == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[i]);
        recursion(i+1, nums);
        list.remove(list.size()-1);
        recursion(i+1, nums);
    }
}