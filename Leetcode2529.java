public class Leetcode2529 {
    public int maximumCount(int[] nums) {
        int numNeg = lowerBound(nums, 0);
        int numPos = nums.length - lowerBound(nums, 1);
        return Math.max(numNeg, numPos);
    }

    private int lowerBound(int[] nums, int target) {
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
    
}
