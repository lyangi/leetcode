import java.util.ArrayDeque;
import java.util.Queue;

public class Leetcode2641 {
    public TreeNode replaceValueInTree(TreeNode root) {
        if (root == null) return null;
        int curValue = root.val;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int nextValue = 0;
            int n = q.size();
            while (n-- > 0) {
                TreeNode node = q.poll();
                node.val = curValue - node.val;

                if (node.left != null) {
                    q.offer(node.left);
                    nextValue += node.left.val;
                }
                if (node.right != null) {
                    q.offer(node.right);
                    nextValue += node.right.val;
                }
                if (node.left != null && node.right != null) {
                    int sum = node.left.val + node.right.val;
                    node.left.val = sum;
                    node.right.val = sum;
                }
            }
            curValue = nextValue;
        }
        return root;
    }
}
