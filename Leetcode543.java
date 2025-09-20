public class Leetcode543 {
    private int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }
    private int dfs(TreeNode root) {
        if (root == null) return -1;
        int l_len = dfs(root.left) + 1;
        int r_len = dfs(root.right) + 1;
        ans = Math.max(ans, l_len + r_len);
        return Math.max(l_len, r_len);
    }
}
