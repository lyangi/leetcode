import java.util.Arrays;

public class Leetcode1039 {
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        int[][] memo = new int[n][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dfs(0, n - 1, values, memo);
    }
    private int dfs(int i, int j, int[] v, int[][] memo) {
        // base case
        if (i + 1 == j) return 0;
        if (memo[i][j] != -1) return memo[i][j];

        int res = Integer.MAX_VALUE / 2;
        for (int k = i + 1; k < j; k++) {
            res = Math.min(res, dfs(i, k, v, memo) + dfs(k, j, v, memo) + v[i] * v[j] * v[k]);
        }
        return memo[i][j] = res;
    }
}
