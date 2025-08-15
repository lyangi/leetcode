import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leetcode1110 {
    private List<TreeNode> ans = new ArrayList<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        int n = to_delete.length;
        Set<Integer> set = new HashSet<>(n);
        for (int i : to_delete) {
            set.add(i);
        }
        if (dfs(root, set) != null) ans.add(root);
        return ans;
    }
    private TreeNode dfs(TreeNode root, Set<Integer> set) {
        if (root == null) return null;
        root.left = dfs(root.left, set);
        root.right = dfs(root.right, set);
        if (!set.contains(root.val)) return root;
        if (root.left != null) ans.add(root.left);
        if (root.right != null) ans.add(root.right);
        return null;
    }
}
