import java.util.HashMap;
import java.util.Map;

public class Leetcode01 {
    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[] {-1, -1};
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] {map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
        int[] x = {2,7,11,15};
        int[] result = twoSum(x, 9);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
        
    }
}