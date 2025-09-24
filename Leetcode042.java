import java.util.ArrayDeque;
import java.util.Deque;

public class Leetcode042 {
    public static int trap(int[] height) {
        int n = height.length;
        int water = 0;
    
        for (int i = 1; i < n - 1; i++) {
            int leftMax = 0, rightMax = 0;
    
            // Find the maximum height on the left
            for (int j = i; j >= 0; j--) {
                leftMax = Math.max(leftMax, height[j]);
            }
    
            // Find the maximum height on the right
            for (int j = i; j < n; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }
    
            // Calculate water at the current position
            water += Math.min(leftMax, rightMax) - height[i];
        }
    
        return water;
    }

    public static int trap2(int[] height) {
        int n = height.length;
        int[] pre_max = new int[n];
        int[] suf_max = new int[n];
        int ans = 0;

        pre_max[0] = height[0];
        for (int i = 1; i < n; i++) {
            pre_max[i] = Math.max(pre_max[i - 1], height[i]);
        }

        suf_max[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suf_max[i] = Math.max(suf_max[i + 1], height[i]);
        }

        for (int i = 0; i < n; i++) {
            ans += Math.min(pre_max[i], suf_max[i]) - height[i];
        }
        return ans;
    }

    public static int trap3(int[] height) {
        int n = height.length;
        int pre_max = 0;
        int suf_max = 0;
        int ans = 0;
        int l = 0, r = n - 1;
        while (l < r) {
            if (height[l] < height[r]) {
                pre_max = Math.max(pre_max, height[l]);
                ans += pre_max - height[l];
                l++;
            } else {
                suf_max = Math.max(suf_max, height[r]);
                ans += suf_max - height[r];
                r--;
            }
        }
        return ans;
    }

    // use stack
    public int trap4(int[] height) {
        int n = height.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int h = height[i];
            while (!stack.isEmpty() && height[stack.peek()] <= h) {
                int bottomH = height[stack.pop()];
                if (stack.isEmpty()) break;
                int left = stack.peek();
                int dh = Math.min(height[left], h) - bottomH;
                ans += dh * (i - left - 1);
            }
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap3(height));
    }
}
