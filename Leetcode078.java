import java.util.ArrayList;
import java.util.List;

public class Leetcode078 {
    // Pick or not pick
    private List<List<Integer>> ans = new ArrayList<>(); // global variable
    private List<Integer> path = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        if (n == 0) return List.of();
        dfs(0, nums);
        return ans;
    }
    private void dfs(int i, int[] nums) {
        if (i == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        // not pick
        dfs(i + 1, nums);

        // pick
        path.add(nums[i]);
        dfs(i + 1, nums);
        path.removeLast();
    }

    // For loop through choices / iterative choices
    public List<List<Integer>> subsets2(int[] nums) {
        int n = nums.length;
        if (n == 0) return List.of();
        dfs2(0, nums);
        return ans;
    }
    private void dfs2(int i, int[] nums) {
        ans.add(new ArrayList<>(path));
        for (int j = i; j < nums.length; j++) {
            path.add(nums[j]);
            dfs2(j + 1, nums);
            path.removeLast();
        }
    }
}