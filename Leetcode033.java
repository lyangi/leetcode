public class Leetcode033 {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n - 2;
        while (l <= r)  {
            int mid = l + (r - l) / 2;
            if (check(nums, target, mid)) { // x is right of target
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return nums[l] == target ? l : -1;
    }

    private boolean check(int[] nums, int target, int i) {
        int x = nums[i];
        int n = nums.length;
        if (x > nums[n - 1]) {
            return target > nums[n - 1] && x >= target;
        } else {
            return target > nums[n - 1] || x >= target;
        }
    }
}
