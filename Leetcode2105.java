public class Leetcode2105 {
    public static int minimumRefill(int[] plants, int capacityA, int capacityB) {
        if (plants == null || plants.length == 0) return 0;
        int l = 0, r = plants.length - 1;
        int ans = 0;
        int a = capacityA, b = capacityB;
        while (l < r) {
            if (a < plants[l]) {
                a = capacityA;
                ans++;
            }
            a -= plants[l++];

            if ((b < plants[r])) {
                b = capacityB;
                ans++;
            }
            b -= plants[r--];
        }
        if (l == r) {
            if (a >= b) {
                if (a < plants[l]) ans++;
            } else {
                if (b < plants[r]) ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(minimumRefill(new int[] {1,2,4,4,5}, 6, 5));
    }
    
}
