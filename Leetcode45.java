/**
 * Leetcode45
 */
public class Leetcode45 {
    public static int jump(int[] nums) {
        int near = 0, far = 0, jump = 0;
        while (far < nums.length - 1) {
            int farthest = 0;
            for (int i = near; i <= far; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }
            near = far + 1;
            far = farthest;
            jump++;
        }
        return jump;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 3, 1, 1, 4 };
        System.out.println(jump(nums));
    }
}