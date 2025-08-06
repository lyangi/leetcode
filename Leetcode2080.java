import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Leetcode2080 {
    HashMap<Integer, List<Integer>> pos = new HashMap<>();
    public void RangeFreqQuery(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            pos.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }
    }
    
    public int query(int left, int right, int value) {
        List<Integer> a = pos.get(value);
        if (a == null) {
            return 0;
        }
        int p = lowerBound(a, right + 1); // > right [q, p-1]
        int q = lowerBound(a, left); // <= left
        return p - q;
    }

    private int lowerBound(List<Integer> nums, int target) {
        int l = 0, r = nums.size() - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums.get(mid) < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}
