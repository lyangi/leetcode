public class Leetcode968 {
    public int minCameraCover(TreeNode root) {
        // choose: min(l_choose, l_by_parent) + min(r_choose, r_by_parent) + 1
        // by_parent: min(l_choose, l_by_children) + min(r_choose, r_by_children)
        // by_children: min(l_choose + r_by_children, l_by_children + r_choose, l_choose + r_choose)

        int[] ans = dfs(root);
        return Math.min(ans[0], ans[2]);
    }
    private int[] dfs(TreeNode root) {
        // edge case
        if (root == null) return new int[] {Integer.MAX_VALUE / 2, 0, 0};
        int[] l = dfs(root.left);
        int[] r = dfs(root.right);
        int choose = Math.min(l[0], l[1]) + Math.min(r[0], r[1]) + 1;
        int byParent = Math.min(l[0], l[2]) + Math.min(r[0], r[2]);
        int byChildren = Math.min(Math.min(l[0] + r[2], l[2] + r[0]), l[0] + r[0]);
        return new int[] {choose, byParent, byChildren};
    }
}
