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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;
        if (root.val == key) {
            return remove(root);
        }
        TreeNode temp = root;
        while (root != null) {
            if (root.val < key) {
                if (root.right != null && root.right.val == key) {
                    root.right = remove(root.right);
                } else {
                    root = root.right;
                }
            } else {
                if (root.left != null && root.left.val == key) {
                    root.left = remove(root.left);
                } else {
                    root = root.left;
                }
            }
        }
        return temp;
    }

    public TreeNode remove(TreeNode root) {
        if (root.left == null)
            return root.right;
        if (root.right == null)
            return root.left;
        TreeNode leftSub = root.left;
        root.left = null;
        TreeNode leftMost = leftMostOfRight(root.right);
        leftMost.left = leftSub;
        return root.right;

    }

    public TreeNode leftMostOfRight(TreeNode root) {
        if (root.left == null)
            return root;
        else
            return leftMostOfRight(root.left);
    }
}