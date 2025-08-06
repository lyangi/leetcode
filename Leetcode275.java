public class Leetcode275 {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int l = 1, r = n;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (citations[n - mid] >= mid) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l - 1;
    }
}
