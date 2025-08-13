import java.util.ArrayList;
import java.util.List;

public class Leetcode199 {
    private List<Integer> ans = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        dfs(root, 0);
        return ans;
    }
    private void dfs(TreeNode root, int depth) {
        if (root == null) return;
        if (ans.size() == depth) ans.add(root.val);
        dfs(root.right, depth + 1);
        dfs(root.left, depth + 1);
    }
}
