import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode2246 {
    private int ans;
    private List<Integer>[] g;
    private String s;
    public int longestPath(int[] parent, String s) {
        this.s = s;
        ans = 0;
        int n = parent.length;
        g = new ArrayList[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int i = 1; i < n; i++) {
            g[parent[i]].add(i);
        }
        dfs(0);
        return ans + 1;
    }
    private int dfs(int x) {
        int maxLen = 0;
        for (int y : g[x]) {
            int len = dfs(y) + 1;
            if (s.charAt(x) != s.charAt(y)) {
                ans = Math.max(ans, maxLen + len);
                maxLen = Math.max(maxLen, len);
            }
        }
        return maxLen;
    }
}
