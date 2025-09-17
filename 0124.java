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
    public int maxPathSum(TreeNode root) {
        int[] maxi = { Integer.MIN_VALUE };
        int dummy = maxPath(root, maxi);
        return maxi[0];

    }

    public int maxPath(TreeNode root, int[] maxi) {
        if (root == null)
            return 0;
        int ls = maxPath(root.left, maxi);
        if (ls < 0)
            ls = 0;
        int rs = maxPath(root.right, maxi);
        if (rs < 0)
            rs = 0;
        maxi[0] = Math.max(maxi[0], root.val + ls + rs);
        return root.val + Math.max(ls, rs);
    }
}