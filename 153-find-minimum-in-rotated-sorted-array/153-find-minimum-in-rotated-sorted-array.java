class Solution {
    public int findMin(int[] nums) {
        if (nums[0] < nums[nums.length - 1] || nums.length == 1) {
      return nums[0];
    }
    
    int left = 0;
    int right = nums.length - 1;

    while (right - left != 1) {
      int middle = left + (right - left) / 2;
      if (nums[middle] < nums[left]) {
        right = middle;
      } else {
        left = middle;
      }
    }

    return nums[right];
    }
}