import java.util.ArrayList;
import java.util.List;

public class Leetcode017 {
    private static final String[] MAPPING = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> ans = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        int n = digits.length();
        if (n == 0) return List.of();
        char[] path = new char[n];
        dfs(0, path, digits);
        return ans;
    }
    private void dfs(int i, char[] path, String digits) {
        if (i == digits.length()) {
            ans.add(new String(path));
            return;
        }
        int num = digits.charAt(i) - '0';
        for (char c : MAPPING[num].toCharArray()) {
            path[i] = c;
            dfs(i + 1, path, digits);
        }
    }
}
