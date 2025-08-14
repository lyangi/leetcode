import java.util.ArrayList;
import java.util.List;

public class Leetcode2476 {
    // inorder and binary search
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        int n = list.size();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = list.get(i);
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < queries.size(); i++) {
            int x = queries.get(i);
            int index = lowerBound(a, x);
            int max = index == n ? -1 : a[index];
            if (index == n || x != a[index]) {
                index--;
            }
            int min = index < 0 ? -1 : a[index];
            ans.add(List.of(min, max));
        }
        return ans;

    }
    private void dfs(TreeNode root, List<Integer> list) {
        if (root == null) return;
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }
    private int lowerBound(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}
