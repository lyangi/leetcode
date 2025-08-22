import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode051 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        int[] path = new int[n]; // row n and col path[n] is Q
        boolean[] col = new boolean[n];
        boolean[] diag1 = new boolean[2 * n - 1]; // n - 1 + n - 1 + 1 = 2n - 1
        boolean[] diag2 = new boolean[2 * n - 1]; // n + n - 1 = 2n - 1
        dfs(0, ans, path, col, diag1, diag2);
        return ans;
    }
    private void dfs(int r, List<List<String>> ans, int[] path, boolean[] col, boolean[] diag1, boolean[] diag2) {
        int n = col.length;
        if (r == n) {
            List<String> s = new ArrayList<>();
            for (int q : path) {
                char[] temp = new char[n];
                Arrays.fill(temp, '.');
                temp[q] = 'Q';
                s.add(new String(temp));
            }
            ans.add(s);
            return;
        }

        for (int c = 0; c < n; c++) {
            int rc = r - c + n - 1;
            if (!col[c] && !diag1[r + c] && !diag2[rc]) {
                path[r] = c;
                col[c] = diag1[r + c] = diag2[rc] = true;
                dfs(r + 1, ans, path, col, diag1, diag2);
                col[c] = diag1[r + c] = diag2[rc] = false;
            }
        }
    }
}
