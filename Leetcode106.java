import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Leetcode106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = postorder.length;
        if (n == 0) return null;
        int leftSize = findIndex(inorder, postorder[n - 1]);
        int[] post1 = Arrays.copyOfRange(postorder, 0, leftSize);
        int[] post2 = Arrays.copyOfRange(postorder, leftSize, n - 1);
        int[] in1 = Arrays.copyOfRange(inorder, 0, leftSize);
        int[] in2 = Arrays.copyOfRange(inorder, leftSize + 1, n);
        TreeNode left = buildTree(in1, post1);
        TreeNode right = buildTree(in2, post2);
        return new TreeNode(postorder[n - 1], left, right);
    }
    private int findIndex(int[] inorder, int target) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == target) return i;
        }
        return -1;
    }

    private Map<Integer, Integer> map;
    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        int n = postorder.length;
        map = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        return dfs(postorder, 0, n, 0, n);
    }
    private TreeNode dfs(int[] postorder, int posL, int posR, int inL, int inR) {
        if (posL == posR) return null;
        int rootVal = postorder[posR - 1];
        int indexInInorder = map.get(rootVal);
        int leftSize = indexInInorder - inL;
        TreeNode left = dfs(postorder, posL, posL + leftSize, inL, inL + leftSize);
        TreeNode right = dfs(postorder, posL + leftSize, posR - 1, inL + leftSize + 1, inR);
        return new TreeNode(rootVal, left, right);
    }
}
