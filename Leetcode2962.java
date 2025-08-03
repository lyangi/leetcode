public class Leetcode2962 {
    public static long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int max = 0;
        for (int x : nums) {
            max = Math.max(max, x);
        }

        int l = 0;
        long ans = 0;
        int cnt = 0;
        for (int r = 0; r < n; r++) {
            if (nums[r] == max) cnt++;
            while (cnt == k) {
                if (nums[l] == max) cnt--;
                l++;
            }
            ans += l;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(countSubarrays(new int[]{1,4,2,1}, 1));
    }
}
