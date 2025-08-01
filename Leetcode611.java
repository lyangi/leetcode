import java.util.Arrays;

public class Leetcode611 {

    public static int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        int n = nums.length;
        // 0 < a <= b <= c
        for (int k = n - 1; k > 1; k--) {
            int c = nums[k];
            if (nums[k - 1] + nums[k - 2] <= c) continue; // code optimization
            int i = 0;
            int j = k - 1;
            while (i < j) {
                if (nums[i] + nums[j] > c) {
                    ans += j - i;
                    j--;
                } else {
                    i++;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(triangleNumber(new int[] {2,2,3,4}));
    }
}