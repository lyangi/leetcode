/**
 * Leetcode169
 */
public class Leetcode169 {
    public static int majorityElement(int[] nums) {
        int count = 0;
        int candidate = nums[0];
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,3,3,3,2,3,3};
        System.out.println(majorityElement(nums));
    }
}