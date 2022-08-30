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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) {
            return false;
        }
        
        boolean match = false;
        
        if(root.val == subRoot.val) {
            match = helper(root, subRoot);
        }
        
        return match || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    
    private boolean helper(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null) {
            return true;
        }
        else if((root == null || subRoot == null) || (root.val != subRoot.val)) {
            return false;
        }
        
        return helper(root.left, subRoot.left) && helper(root.right, subRoot.right);
    }
}