public class Leetcode034 {
    public static int[] searchRange(int[] nums, int target) {
        int start = lowerBound(nums, target);
        if (start == nums.length || nums[start] != target) return new int[]{-1, -1};
        int end = lowerBound(nums, target + 1) - 1;
        return new int[]{start, end};
    }

    private static int lowerBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] ans = searchRange(new int[]{5,7,7,8,8,10}, 8);
        for (int a : ans) {
            System.out.println(a);
        }
    }
}
