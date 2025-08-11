import java.util.ArrayList;
import java.util.List;

public class Leetcode987 {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<int[]> data = new ArrayList<>();
        dfs(root, 0, 0, data);
        data.sort((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] != b [1] ? a[1] - b[1] : a[2] - b[2]);

        List<List<Integer>> ans = new ArrayList<>();
        int lastCol = Integer.MIN_VALUE;
        for (int[] d : data) {
            if (d[0] != lastCol) {
                lastCol = d[0];
                ans.add(new ArrayList<>());
            }
            ans.get(ans.size() - 1).add(d[2]);
        }
        return ans;
    }
    private void dfs(TreeNode root, int row, int col, List<int[]> data) {
        if (root == null) return;
        data.add(new int[] {col, row, root.val});
        dfs(root.left, row + 1, col - 1, data);
        dfs(root.right, row + 1, col + 1, data);
    }
}
