public class Leetcode110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return treeHeight(root) != -1;
    }
    private int treeHeight(TreeNode root) {
        if (root == null) return 0;
        int lHeight = treeHeight(root.left);
        if (lHeight == -1) return -1;
        int rHeight = treeHeight(root.right);
        if (rHeight == -1 || Math.abs(rHeight - lHeight) > 1) return -1;
        return Math.max(lHeight, rHeight) + 1;
    }
}
