public class Leetcode09 {
    public static boolean isPalindrome(int x) {
        if (x == 0) return true;
        if (x < 0) return false;
        int res = 0;
        int tmp = x;
        while (tmp != 0) {
            res = res * 10 + tmp % 10;
            tmp /= 10;
        }
        if (res == x) {
            return true;
        } else {
            return false;
        }
    }
    public static void main(String[] args) {
        int x = 121;
        System.out.println(isPalindrome(x));
    }
}
