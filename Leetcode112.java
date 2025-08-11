public class Leetcode112 {
    private boolean ans = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        dfs(root, targetSum);
        return ans;
    }
    private void dfs(TreeNode root, int targetSum) {
        if (root == null) return;
        targetSum -= root.val;
        if (root.left == null && root.right == null) {
            if (targetSum == 0) {
                ans = true;
                return;
            }
        }
        dfs(root.left, targetSum);
        dfs(root.right, targetSum);
    }
}
