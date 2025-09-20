public class Leetcode124 {
    private int ans;
    public int maxPathSum(TreeNode root) {
        ans = Integer.MIN_VALUE / 2;
        dfs(root);
        return ans;
    }
    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int lSum = dfs(root.left);
        int rSum = dfs(root.right);
        ans = Math.max(ans, lSum + rSum + root.val);
        int res = Math.max(lSum, rSum) + root.val;
        return res > 0 ? res : 0;
    }
}
