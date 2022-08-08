class Solution {
    public int lengthOfLIS(int[] nums) {
        TreeSet<Integer> bst = new TreeSet<>();
        for(int num: nums){
            Integer higherOfEqual = bst.ceiling(num);
            if(higherOfEqual == null){
                bst.add(num);
                
            }else{
                bst.remove(higherOfEqual);
                bst.add(num);
            }
        }
        return bst.size();
    }
}