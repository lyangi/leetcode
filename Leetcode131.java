import java.util.ArrayList;
import java.util.List;

public class Leetcode131 {
    
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> path = new ArrayList<>();
        if (s == null || s.length() == 0) return List.of();
        dfs(0, path, ans, s);
        return ans;
    }
    private void dfs(int i, List<String> path, List<List<String>> ans, String s) {
        if (i == s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int j = i; j < s.length(); j++) {
            if (isPalindrome(s, i , j)) {
                path.add(s.substring(i, j + 1));
                dfs(j + 1, path, ans, s);
                path.removeLast();
            }
        }
    }
    private boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }
}
