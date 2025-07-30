import java.util.ArrayList;
import java.util.List;

public class Leetcode40 {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();
        backtrack(candidates, target, 0, comb, result);
        return result;
    }
    private static void backtrack(int[] candidates, int target, int start, List<Integer> comb, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(comb));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            
            comb.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i + 1, comb, result);
            comb.remove(comb.size() - 1);
        }
    }
    public static void main(String[] args) {
        int[] candidates = {1, 1, 2};
        int target = 3;
        combinationSum2(candidates, target);
    }
}
