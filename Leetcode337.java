public class Leetcode337 {
    public int rob(TreeNode root) {
        int[] ans = dfs(root);
        return Math.max(ans[0], ans[1]);
    }
    private int[] dfs(TreeNode root) {
        if (root == null) return new int[] {0, 0};

        // 0: pick 1: not_pick
        int[] lMax = dfs(root.left);
        int[] rMax = dfs(root.right);
        int rob = lMax[1] + rMax[1] + root.val;
        int notRob = Math.max(lMax[0], lMax[1]) + Math.max(rMax[0], rMax[1]);
        return new int[] {rob, notRob};
    }
}
