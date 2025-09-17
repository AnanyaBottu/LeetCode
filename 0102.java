/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (root == null)
            return ans;
        Queue<TreeNode> Q = new ArrayDeque<TreeNode>();
        Q.offer(root);
        while (!Q.isEmpty()) {
            ArrayList<Integer> al = new ArrayList<>();
            int size = Q.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = Q.poll();
                al.add(temp.val);

                if (temp.left != null)
                    Q.offer(temp.left);
                if (temp.right != null)
                    Q.offer(temp.right);
            }
            ans.add(al);
        }
        return ans;
    }
}