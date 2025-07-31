import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode18 {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n - 3; i++) {
            long x = nums[i];
            if (i > 0 && x == nums[i - 1]) continue;
            if (x + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break; // code optimization
            if (x + nums[n - 1] + nums[n - 2] + nums[n - 3] < target) continue; // code optimization
            for (int j = i + 1; j < n - 2; j++) {
                long y = nums[j];
                if (j > i + 1 && y == nums[j - 1]) continue;
                if (x + y + nums[j + 1] + nums[j + 2] > target) break; // code optimization
                if (x + y + nums[n - 1] + nums[n - 2] < target) continue; // code optimization
                int lo = j + 1;
                int hi = n - 1;
                while (lo < hi) {
                    long sum = x + y + nums[lo] + nums[hi];
                    if (sum > target) {
                        hi--;
                    } else if (sum < target) {
                        lo++;
                    } else {
                        list.add(List.of((int)x, (int)y, nums[lo], nums[hi]));
                        for (lo++; lo < hi && nums[lo] == nums[lo - 1]; lo++);
                        for (hi--; lo < hi && nums[hi] == nums[hi + 1]; hi++);
                    }
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<List<Integer>> list1 = fourSum(new int[] {2,2,2,2,2}, 8);
        List<List<Integer>> list2 = fourSum(new int[] {1,0,-1,0,-2,2}, 0);
        System.out.println(list1);
        System.out.println(list2);
    }
}
