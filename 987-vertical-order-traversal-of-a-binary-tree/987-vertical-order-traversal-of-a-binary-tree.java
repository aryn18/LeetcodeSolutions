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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<Node> order = new ArrayList<>();
        preOrder(root, 0, 0, order);
		
        Collections.sort(order, new Comparator<Node>() {
            public int compare(Node a, Node b) {
                if (a.col == b.col && a.row == b.row) {
                    return a.val - b.val;
                }
                
                if (a.col == b.col) {
                    return a.row - b.row;
                }
                return a.col - b.col;
            }
        });
		
        List<List<Integer>> res = new ArrayList<>();
        int idx = 0;
        while (idx < order.size()) {
            List<Integer> tmp = new ArrayList<>();
            Node pre = order.get(idx++);
            tmp.add(pre.val);
            while (idx < order.size() && order.get(idx).col == pre.col) {
                pre = order.get(idx++);
                tmp.add(pre.val);
            }
            res.add(tmp);
        }
		
        return res;
    }
    
    private void preOrder(TreeNode root, int row, int col, List<Node> order) {
        if (root == null) {
            return;
        }
        
        order.add(new Node(row, col, root.val));
        preOrder(root.left, row+1, col-1, order);
        preOrder(root.right, row+1, col+1, order);
    }
}

class Node {
    int row;
    int col;
    int val;
    
    Node(int row, int col, int val) {
        this.row = row;
        this.col = col;
        this.val = val;
    }
}