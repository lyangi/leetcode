public class Leetcode230 {
    private int ans = -1;
    private int k = 0;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return ans;
    }
    private void dfs(TreeNode root) {
        if (root == null || k == 0) return;
        dfs(root.left);
        if (--k == 0) ans = root.val;
        dfs(root.right);
    }
}
