public class Leetcode125 {
    public static boolean isPalindrome(String s) {
        int n = s.length();
        int l = 0, r = n - 1;
        while (l < r) {
            if (!Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            } else if (!Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            } else if (Character.toLowerCase(s.charAt(l)) == Character.toLowerCase(s.charAt(r))) {
                l++;
                r--;
            } else {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
}
