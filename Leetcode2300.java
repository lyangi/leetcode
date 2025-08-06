import java.util.Arrays;

public class Leetcode2300 {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        if (spells == null || potions == null || spells.length == 0 || potions.length == 0) return null;
        Arrays.sort(potions);
        int n = spells.length;
        int m = potions.length;
        int maxPotion = potions[m - 1];
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int spell = spells[i];
            long minPotion = (success - 1) / spell + 1;
            if (minPotion > maxPotion) {
                ans[i] = 0;
                continue;
            }
            ans[i] = m - lowerBound(potions, (int) minPotion);
        }
        return ans;
    }

    private int lowerBound(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}
