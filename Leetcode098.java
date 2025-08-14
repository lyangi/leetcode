public class Leetcode098 {
    // preorder
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean dfs(TreeNode root, long min, long max) {
        if (root == null) return true;
        return root.val > min && root.val < max && dfs(root.left, min, root.val) && dfs(root.right, root.val, max);
    }

    // inorder
    private long pre = Long.MIN_VALUE;
    public boolean isValidBST2(TreeNode root) {
        if (root == null) return true;
        if (!isValidBST2(root.left)) return false;
        if (root.val <= pre) return false;
        pre = root.val;
        return isValidBST2(root.right);
    }

    // postorder
    public boolean isValidBST3(TreeNode root) {
        return dfs(root)[1] != Long.MAX_VALUE;
    }
    private long[] dfs(TreeNode root) {
        if (root == null) return new long[] {Long.MAX_VALUE, Long.MIN_VALUE};
        long[] left = dfs(root.left);
        long[] right = dfs(root.right);
        if (root.val <= left[1] || root.val >= right[0]) return new long[] {Long.MIN_VALUE, Long.MAX_VALUE};
        return new long[] {Math.min(root.val, left[0]), Math.max(root.val, right[1])};
    }
}
