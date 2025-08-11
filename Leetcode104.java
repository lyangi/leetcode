public class Leetcode104 {
    // bottom up
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int lDepth = maxDepth(root.left);
        int rDepth = maxDepth(root.right);
        return Math.max(lDepth, rDepth) + 1;
    }

    // top down
    private int ans = 0;
    public int maxDepth2(TreeNode root) {
        dfs(root, 0);
        return ans;
    }
    private void dfs(TreeNode root, int depth) {
        if (root == null) return;
        depth++;
        ans = Math.max(ans, depth);
        dfs(root.left, depth);
        dfs(root.right, depth);
    }
}
