public class Leetcode2698 {
    public int punishmentNumber(int n) {
        int p = 0;
        for (int cur = 1; cur <= n; cur++) {
            int q = cur * cur;
            if (canPartition(q, cur)) {
                p += q;
            }
        }
        return p;
    }
    private boolean canPartition(int num, int target) {
        if (target < 0 || num < target) {
            return false;
        }
        if (num == target) return true;

        return canPartition(num / 10, target - (num % 10)) || canPartition(num / 100, target - (num % 100)) || canPartition(num / 1000, target - (num % 1000));
    }
}
