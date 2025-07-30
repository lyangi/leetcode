public class Leetcode07 {
    public static int reverse(int x) {
        if (x == 0) return 0;

        int ans = 0;
        while (x != 0) {
            if (Math.abs(ans) > Integer.MAX_VALUE / 10) {
                return 0;
            }
            ans = ans * 10 + x % 10;
            x /= 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(reverse(321));
    }
}
