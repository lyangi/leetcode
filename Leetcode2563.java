import java.util.Arrays;

public class Leetcode2563 {
    public static long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        return count(nums, upper) - count(nums, lower - 1);
    }

    private static long count(int[] nums, int upper) {
        int n = nums.length;
        int l = 0, r = n - 1;
        long ans = 0;
        while (l < r) {
            if (nums[l] + nums[r] <= upper) {
                ans += r - l;
                l++;
            } else {
                r--;
            }
        }
        return ans;
    }

    public static long countFairPairs2(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long ans = 0;
        for (int j = 0; j < nums.length; j++) {
            int r = lowerBound(nums, j, upper - nums[j] + 1);
            int l = lowerBound(nums, j, lower - nums[j]);
            ans += r - l;
        }
        return ans;
    }

    private static int lowerBound(int[] nums, int j, int target) {
        int l = 0, r = j - 1;
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

    public static void main(String[] args) {
        System.out.println(countFairPairs2(new int[]{0,1,7,4,4,5}, 3, 6));
    }
}
