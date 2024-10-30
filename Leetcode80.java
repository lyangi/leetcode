public class Leetcode80 {

    public static int removeDuplicates(int[] nums) {
        int k = 1;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[k - 1] && count != 2) {
                nums[k++] = nums[i];
                count++;
            } else if (nums[i] != nums[k - 1]) {
                nums[k++] = nums[i];
                count = 1;
            }
        }
        return k;
    }

    public static int removeDuplicates2(int[] nums) {
        int k = 1;
        for (int i = 1; i < nums.length; i++) {
            if (k < 2 || nums[i] != nums[k - 2]) {
                nums[k++] = nums[i];
            }
        }
        return k;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
    }
}
