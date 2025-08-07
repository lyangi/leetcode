public class Leetcode1901 {
    public int[] findPeakGrid(int[][] mat) {
        if (mat == null || mat.length == 0 || mat[0] == null || mat[0].length == 0) return null;
        int m = mat.length;
        int l = 0, r = m - 2;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int index = findMaxIndex(mat[mid]);
            if (mat[mid][index] > mat[mid + 1][index]) {
                r = mid - 1;
            } else {
                l = l + 1;
            }
        }
        return new int[] {l, findMaxIndex(mat[l])};
    }

    private int findMaxIndex(int[] nums) {
        int n = nums.length;
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[idx]) {
                idx = i;
            }
        }
        return idx;
    }
}
