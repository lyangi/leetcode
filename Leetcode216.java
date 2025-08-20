import java.util.ArrayList;
import java.util.List;

public class Leetcode216 {
    // For loop through choices
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(9, k, n, ans, path);
        return ans;
    }
    private void dfs(int i, int k, int leftSum, List<List<Integer>> ans, List<Integer> path) {
        int d = k - path.size();

        if (leftSum < 0 || leftSum > (i * 2 - d + 1) * d / 2) return;
        if (d == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int j = i; j >= d; j--) {
            path.add(j);
            dfs(j - 1, k, leftSum - j, ans, path);
            path.removeLast();
        }
    }

    // pick or not pick
    public List<List<Integer>> combinationSum32(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs2(9, k, n, ans, path);
        return ans;
    }
    private void dfs2(int i, int k, int leftSum, List<List<Integer>> ans, List<Integer> path) {
        int d = k - path.size();
        if (leftSum < 0 || leftSum > (i * 2 - d + 1) * d / 2) return;
        if (d == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        if (i > d) {
            dfs2(i - 1, k, leftSum, ans, path);
        }
        path.add(i);
        dfs2(i - 1, k, leftSum - i, ans, path);
        path.removeLast();
    }
}
