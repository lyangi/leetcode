import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Leetcode105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        if (n == 0) return null;
        int leftSize = findIndex(inorder, preorder[0]);
        int[] pre1 = Arrays.copyOfRange(preorder, 1, 1 + leftSize);
        int[] pre2 = Arrays.copyOfRange(preorder, 1 + leftSize, n);
        int[] in1 = Arrays.copyOfRange(inorder, 0, leftSize);
        int[] in2 = Arrays.copyOfRange(inorder, leftSize + 1, n);
        TreeNode left = buildTree(pre1, in1);
        TreeNode right = buildTree(pre2, in2);
        return new TreeNode(preorder[0], left, right);
    }
    private int findIndex(int[] inorder, int target) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == target) return i;
        }
        return -1;
    }

    private Map<Integer, Integer> map;
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        int n = preorder.length;
        map = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        return dfs(preorder, 0, n, 0, n);
    }
    private TreeNode dfs(int[] preorder, int preL, int preR, int inL, int inR) {
        if (preL == preR) return null;
        int rootVal = preorder[preL];
        int indexInInorder = map.get(rootVal);
        int leftSize = indexInInorder - inL;
        TreeNode left = dfs(preorder, preL + 1, preL + 1 + leftSize, inL, inL + leftSize);
        TreeNode right = dfs(preorder, preL + 1 + leftSize, preR, inL + leftSize + 1, inR);
        return new TreeNode(rootVal, left, right);
    }
}
