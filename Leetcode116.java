import java.util.ArrayDeque;
import java.util.Queue;

public class Leetcode116 {
    public Node connect(Node root) {
        if (root == null) return null;
        Queue<Node> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int n = q.size();
            while (n-- > 0) {
                Node node = q.poll();
                if (n != 0) {
                    node.next = q.peek();
                }
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
        }
        return root;
    }
}
