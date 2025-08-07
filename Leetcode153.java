public class Leetcode153 {
    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 2;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[r + 1]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return nums[l];
    }
}
