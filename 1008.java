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
    public TreeNode bstFromPreorder(int[] preorder) {
        return bstPO(preorder, Long.MAX_VALUE, new int[] { 0 });
    }

    public TreeNode bstPO(int[] preorder, long bound, int[] i) {
        if (preorder.length == i[0] || preorder[i[0]] > bound)
            return null;
        TreeNode root = new TreeNode(preorder[i[0]]);// i[0] is a single in counter
        i[0]++;
        root.left = bstPO(preorder, root.val, i);
        root.right = bstPO(preorder, bound, i);
        return root;
    }
}