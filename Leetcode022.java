import java.util.ArrayList;
import java.util.List;

public class Leetcode022 {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        char[] path = new char[n * 2];
        dfs(0, 0, n, ans, path);
        return ans;
    }
    private void dfs(int i, int open, int n, List<String> ans, char[] path) {
        if (i == n * 2) {
            ans.add(new String(path));
            return;
        }
        if (open < n) {
            path[i] = '(';
            dfs(i + 1, open + 1, n, ans, path);
        }

        if (open > i - open) {
            path[i] = ')';
            dfs(i + 1, open, n, ans, path);
        }
    }
}
