public class Leetcode129 {
    private int ans = 0;
    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return ans;
    }
    private void dfs(TreeNode root, int num) {
        if (root == null) return;
        num = num * 10 + root.val;
        if (root.left == null && root.right == null) {
            ans += num;
            return;
        }
        dfs(root.left, num);
        dfs(root.right, num);
    }
}
