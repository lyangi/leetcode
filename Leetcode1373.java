public class Leetcode1373 {
    private int ans = 0;
    public int maxSumBST(TreeNode root) {
        dfs(root);
        return ans;
    }
    private int[] dfs(TreeNode root) {
        if (root == null) return new int[] {Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int x = root.val;
        if (x <= left[1] || x >= right[0]) {
            return new int[] {Integer.MIN_VALUE, Integer.MAX_VALUE, 0};
        }
        int s = x + left[2] + right[2];
        ans = Math.max(ans, s);
        return new int[] {Math.min(x, left[0]), Math.max(x, right[1]), s};
    }
}
