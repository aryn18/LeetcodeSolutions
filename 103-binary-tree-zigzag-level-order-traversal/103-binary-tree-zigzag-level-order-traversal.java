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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> levelOrder = new ArrayList<>();

	if (root == null) return levelOrder;

	dfs(root, 1, levelOrder);

	return levelOrder;
}
      
private void dfs(TreeNode root, int level, List<List<Integer>> levelOrder) {

	if (root == null) return;

	if (levelOrder.size() < level) {
		levelOrder.add(new ArrayList<>());
	}

	
	if (level % 2 == 0) {
		levelOrder.get(level - 1).add(0, root.val); // for zigzag
	} else {
		levelOrder.get(level - 1).add(root.val);
	}

	if (root.left != null)
		dfs(root.left, level + 1, levelOrder);

	if (root.right != null)
		dfs(root.right, level + 1, levelOrder);
    }
}