public class Leetcode1448 {
    private int ans = 0;
    public int goodNodes(TreeNode root) {
        if (root == null) return 0;
        dfs(root, root.val);
        return ans;
    }
    private void dfs(TreeNode root, int num) {
        if (root == null) return;
        if (root.val >= num) {
            ans++;
            num = root.val;
        }
        dfs(root.left, num);
        dfs(root.right, num);
    }
}
