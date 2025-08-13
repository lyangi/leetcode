public class Leetcode1026 {
    private int ans = 0;
    public int maxAncestorDiff(TreeNode root) {
        if (root == null) return 0;
        dfs(root, root.val, root.val);
        return ans;
    }
    private void dfs(TreeNode root, int max, int min) {
        if (root == null) return;
        if (root.val > max) max = root.val;
        if (root.val < min) min = root.val;
        if (root.left == null && root.right == null) {
            ans = Math.max(ans, max - min);
        }
        dfs(root.left, max, min);
        dfs(root.right, max, min);
    }
}
