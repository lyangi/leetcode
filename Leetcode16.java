import java.util.Arrays;

public class Leetcode16 {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = 0;
        int n = nums.length;
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < n - 2; i++) {
            int x = nums[i];
            if (i > 0 && x == nums[i - 1]) continue;

            int s = x + nums[i + 1] + nums[i + 2];
            if (s > target) {
                if (s - target < diff) {
                    ans = s;
                }
                break;
            }

            s = x + nums[n - 1] + nums[n - 2];
            if (s < target) {
                if (target - s < diff) {
                    ans = s;
                    diff = target - s;
                }
                continue;
            }

            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = x + nums[j] + nums[k];
                if (sum == target) {
                    return target;
                }
                if (sum > target) {
                    if (sum - target < diff) {
                        diff = sum - target;
                        ans = sum;
                    }
                    k--;
                } else {
                    if (target - sum < diff) {
                        diff = target - sum;
                        ans = sum;
                    }
                    j++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[] {-1, 2, 1, -4}, 1));
    }
}
