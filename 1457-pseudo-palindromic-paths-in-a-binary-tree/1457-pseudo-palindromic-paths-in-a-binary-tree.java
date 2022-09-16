/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int pseudoPalindromicPaths (TreeNode root) {
    
        Set<Integer> set=new HashSet<>();
        return number(root,set);
    }
    private int number(TreeNode root,Set<Integer> set){
        if(root==null)
            return  0;
        int cur=root.val;
            
            if(set.contains(cur))
                set.remove(cur);
            else
                set.add(cur);
        
        if(root.left==null && root.right==null){
                return set.size()<=1?1:0;
            }
          
        int left=number(root.left,set);
        if(root.left!=null && set.contains(root.left.val))
            set.remove(root.left.val);
        else if(root.left!=null)
            set.add(root.left.val);
        int right=number(root.right,set);
        if(root.right!=null && set.contains(root.right.val))
            set.remove(root.right.val);
        else if(root.right!=null)
            set.add(root.right.val);
         
        return left+right;
        
    }
}