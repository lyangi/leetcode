import java.util.Arrays;

/**
 * Leetcode88
 */
public class Leetcode88 {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int pos = m + n - 1;
        m--;
        n--;
        while (m >= 0 && n >= 0) {
            if (nums1[m] > nums2[n]) {
                nums1[pos--] = nums1[m--];
            } else {
                nums1[pos--] = nums2[n--];
            }
        }
        while (n >= 0) {
            nums1[pos--] = nums2[n--];
        }
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 3, 0, 0, 0 };
        int[] nums2 = { 2, 5, 6 };
        merge(nums1, 3, nums2, 3);
        System.err.println(Arrays.toString(nums1));
    }
}