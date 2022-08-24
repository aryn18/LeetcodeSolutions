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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for(int i=0; i<inorder.length; i++) {
            hm.put(inorder[i], i);
        }
        
        return constructTree(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1, hm);
    }
    
    public TreeNode constructTree(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd, HashMap<Integer, Integer> hm) {
        if(preStart > preEnd || inStart > inEnd) return null;
        
        
        TreeNode root = new TreeNode(preorder[preStart]);
        int inorderRoot = hm.get(preorder[preStart]);
        
        int leftSizeTree = inorderRoot - inStart;
        int rightSizeTree = inEnd - inorderRoot;
        
        root.left = constructTree(preorder, inorder, preStart + 1, preStart + leftSizeTree, inStart, inorderRoot - 1, hm);
        root.right = constructTree(preorder, inorder, preEnd - rightSizeTree + 1, preEnd, inorderRoot + 1, inEnd, hm);
            
        return root;
    } 
}