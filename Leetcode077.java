import java.util.ArrayList;
import java.util.List;

public class Leetcode077 {
    // For loop through choices
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(n, k, ans, path);
        return ans;
    }
    private void dfs(int i, int k, List<List<Integer>> ans, List<Integer> path) {
        int d = k - path.size();
        if (d == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int j = i; j >= d; j--) {
            path.add(j);
            dfs(j - 1, k, ans, path);
            path.removeLast();
        }
    }

    // pick or not pick
    public List<List<Integer>> combine2(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs2(n, k, ans, path);
        return ans;
    }
    private void dfs2(int i, int k, List<List<Integer>> ans, List<Integer> path) {
        int d = k - path.size();
        if (d == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }

        if (i > d) {
            dfs2(i - 1, k, ans, path);
        }

        path.add(i);
        dfs2(i - 1, k, ans, path);
        path.removeLast();
    }
}
