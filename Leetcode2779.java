import java.util.Arrays;

public class Leetcode2779 {
    public static int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int l = 0;
        int ans = 0;
        for (int r = 0; r < n; r++) {
            while (nums[r] - nums[l] > 2 * k) {
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(maximumBeauty(new int[]{4,6,1,2}, 2));
    }
    
}
