import java.util.ArrayDeque;
import java.util.Queue;

public class Leetcode513 {
    // BFS
    public int findBottomLeftValue(TreeNode root) {
        if (root == null)
            return -1;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        TreeNode node = root;
        while (!q.isEmpty()) {
            node = q.poll();
            if (node.right != null) q.offer(node.right);
            if (node.left != null) q.offer(node.left);
        }
        return node.val;
    }

    // DFS
    private int maxDepth = -1;
    private int ans;

    public int findBottomLeftValue2(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            if (depth > maxDepth) {
                maxDepth = depth;
                ans = root.val;
            }
        }

        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }
}
