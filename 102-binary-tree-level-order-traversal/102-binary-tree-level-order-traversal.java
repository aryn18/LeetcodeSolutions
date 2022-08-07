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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        findResult(res,root);
        return res;
    }
    
    public void findResult(List<List<Integer>> res,TreeNode root){
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
        
    while(!queue.isEmpty()){
        
     int cur=queue.size();
     List<Integer> level = new ArrayList<>();
     
     for(int i=0;i<cur;i++){
         TreeNode curNode = queue.poll();
         level.add(curNode.val);
         if(curNode.left!=null)
               queue.add(curNode.left);
         if(curNode.right!=null)
               queue.add(curNode.right);
     
     }
     res.add(level);

      }
    }
}