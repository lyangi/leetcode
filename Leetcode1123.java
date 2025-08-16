public class Leetcode1123 {
    private TreeNode ans;
    private int maxDepth;
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if (root == null) return null;
        dfs(root, 0);
        return ans;
    }
    private int dfs(TreeNode root, int depth) {
        if (root == null) {
            maxDepth = Math.max(maxDepth, depth);
            return depth;
        }
        int leftDepth = dfs(root.left, depth + 1);
        int rightDepth = dfs(root.right, depth + 1);
        if (leftDepth == rightDepth && leftDepth == maxDepth) {
            ans = root;
        }
        return Math.max(leftDepth, rightDepth);
    }
}
