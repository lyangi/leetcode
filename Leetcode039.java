import java.util.ArrayList;
import java.util.List;

public class Leetcode039 {
    // pick or not pick
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(0, candidates, target, ans, path);
        return ans;
    }
    private void dfs(int i, int[] candidates, int leftSum, List<List<Integer>> ans, List<Integer> path) {
        if (leftSum == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        if (i == candidates.length || leftSum < 0) return;

        dfs(i + 1, candidates, leftSum, ans, path);

        path.add(candidates[i]);
        dfs(i, candidates, leftSum - candidates[i], ans, path);
        path.removeLast();
    }

    // For loop through choices(iterative choices)
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs2(0, candidates, target, ans, path);
        return ans;
    }
    private void dfs2(int i, int[] candidates, int leftSum, List<List<Integer>> ans, List<Integer> path) {
        if (leftSum == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        if (leftSum < 0) return;
        for (int j = i; j < candidates.length; j++) {
            path.add(candidates[j]);
            dfs2(j, candidates, leftSum - candidates[j], ans, path);
            path.removeLast();
        }
    }
}
