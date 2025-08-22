import java.util.ArrayList;
import java.util.List;

public class Leetcode093 {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        int[] path = new int[4];
        dfs(0, 0, 0, ans, path, s);
        return ans;
    }

    private void dfs(int i, int j, int val, List<String> ans, int[] path, String s) {
        if (i == s.length()) {
            if (j == 4) {
                int a = path[0], b = path[1], c = path[2];
                ans.add(s.substring(0, a) + "." + s.substring(a, b) + "." + s.substring(b, c) + "." + s.substring(c));
            }
            return;
        }
        if (j == 4)
            return;
        val = val * 10 + s.charAt(i) - '0';
        if (val > 255)
            return;

        if (val > 0) {
            dfs(i + 1, j, val, ans, path, s);
        }

        path[j] = i + 1;
        dfs(i + 1, j + 1, 0, ans, path, s);
    }
}
