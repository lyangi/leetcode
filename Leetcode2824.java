import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leetcode2824 {
    public static int countPairs(List<Integer> nums, int target) {
        Collections.sort(nums);
        int n = nums.size();
        int l = 0, r = n - 1;
        int count = 0;
        while (l < r) {
            int sum = nums.get(l) + nums.get(r);
            if (sum < target) {
                count += r - l;
                l++;
            } else {
                r--;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.addAll(List.of(-1, 1, 2, 3, 1));
        System.out.println(countPairs(list, 2));;
    }
}
