import java.util.Arrays;

/**
 * Leetcode189
 */
public class Leetcode189 {

    public static void rotate(int nums[], int k) {
        for (int j = 0; j < k; j++) {
            for (int i = nums.length - 1; i > 0; i--) {
                int temp = nums[i];
                nums[i] = nums[i - 1];
                nums[i - 1] = temp;
            }
        }
    }

    public static void rotate2(int nums[], int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);

    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
        rotate2(nums, 3);
        System.out.println(Arrays.toString(nums));
    }
}