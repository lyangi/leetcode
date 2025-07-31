import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            int x = nums[i];
            if (i > 0 && x == nums[i - 1]) continue;
            if (x + nums[i + 1] + nums[i + 2] > 0) break; // code optimization
            if (x + nums[n - 1] + nums[n - 2] < 0) continue; // code optimization
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = x + nums[j] + nums[k];
                if (sum > 0) {
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    list.add(List.of(x, nums[j], nums[k]));
                    for (j++; j < k && nums[j] == nums[j - 1]; j++);
                    for (k--; j < k && nums[k] == nums[k + 1]; k--);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[] {2, -2, 0, -2, 2}));
    }
}
