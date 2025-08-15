import java.util.HashMap;
import java.util.Map;

public class Leetcode889 {
    private Map<Integer, Integer> map;
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = postorder.length;
        map = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            map.put(postorder[i], i);
        }
        return dfs(preorder, 0, n, 0, n);
    }
    private TreeNode dfs(int[] preorder, int preL, int preR, int posL, int posR) {
        if (preL == preR) return null;
        if (preL + 1 == preR) return new TreeNode(preorder[preL]);
        int rootVal = preorder[preL + 1];
        int indexInPostorder = map.get(rootVal);
        int leftSize = indexInPostorder - posL + 1;
        TreeNode left = dfs(preorder, preL + 1, preL + 1 + leftSize, posL, posL + leftSize);
        TreeNode right = dfs(preorder, preL + 1 + leftSize, preR, posL + leftSize, posR - 1);
        return new TreeNode(preorder[preL], left, right);
    }
}
