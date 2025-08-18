import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Leetcode102 {
    // double array
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return List.of();
        List<TreeNode> cur = new ArrayList<>();
        cur.add(root);
        List<List<Integer>> ans = new ArrayList<>();
        while (!cur.isEmpty()) {
            List<TreeNode> nxt = new ArrayList<>();
            List<Integer> vals = new ArrayList<>();
            for (TreeNode node : cur) {
                vals.add(node.val);
                if (node.left != null) nxt.add(node.left);
                if (node.right != null) nxt.add(node.right);
            }
            ans.add(vals);
            cur = nxt;
        }
        return ans;
    }

    // queue
    public List<List<Integer>> levelOrder2(TreeNode root) {
        if (root == null) return List.of();
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            List<Integer> vals = new ArrayList<>();
            int n = q.size();
            while (n-- > 0) {
                TreeNode node = q.poll();
                vals.add(node.val);
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            ans.add(vals);
        }
        return ans;
    }
}
