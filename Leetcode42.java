public class Leetcode42 {
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
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        trap(height);
    }
}
