import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Leetcode2415 {
    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        int level = 0;
        while (!q.isEmpty()) {
            int n = q.size();
            List<TreeNode> list = new ArrayList<>();
            while (n-- > 0) {
                TreeNode node = q.poll();
                if (level % 2 == 1) {
                    list.add(node);
                }
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            level++;
            reverseNode(list);
        }
        return root;
    }
    private void reverseNode(List<TreeNode> list) {
        int l = 0, r = list.size() - 1;
        while (l < r) {
            int temp = list.get(l).val;
            list.get(l).val = list.get(r).val;
            list.get(r).val = temp;
            l++;
            r--;
        }
    }
}
