public class Leetcode111 {
    // bottom up
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null) return minDepth(root.right) + 1;
        if (root.right == null) return minDepth(root.left) + 1;
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    // bottom up
    public int minDepth2(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int lDepth = root.left != null ? minDepth2(root.left) : Integer.MAX_VALUE;
        int rDepth = root.right != null ? minDepth2(root.right) : Integer.MAX_VALUE;
        return Math.min(lDepth, rDepth) + 1;
    }

    // top down
    private int ans = Integer.MAX_VALUE;
    public int minDepth3(TreeNode root) {
        if (root == null) return 0;
        dfs(root, 0);
        return ans;
    }
    private void dfs(TreeNode root, int depth) {
        if (root == null || ++depth >= ans) return; // code optimization (pruning)
        if (root.left == null && root.right == null) {
            ans = depth;
            return;
        }
        dfs(root.left, depth);
        dfs(root.right, depth);
    }
}
