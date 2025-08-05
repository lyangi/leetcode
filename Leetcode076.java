public class Leetcode076 {
    public String minWindow(String s, String t) {
        int[] cntS = new int[128];
        int[] cntT = new int[128];
        int m = s.length();
        int n = t.length();
        for (int i = 0; i < n; i++) {
            cntT[t.charAt(i)]++;
        }

        int l = 0;
        int ansLeft = -1;
        int ansRight = m;
        for (int r = 0; r < m; r++) {
            cntS[s.charAt(r)]++;
            while (isContains(cntS, cntT)) {
                if (ansRight - ansLeft > r - l) {
                    ansLeft = l;
                    ansRight = r;
                }
                cntS[s.charAt(l)]--;
                l++;
            }
        }
        return ansLeft < 0 ? "" : s.substring(ansLeft, ansRight + 1);
    }

    private boolean isContains(int[] cntS, int[] cntT) {
        for (int i = 'a'; i <= 'z'; i++) {
            if (cntS[i] > cntT[i]) {
                return false;
            }
        }
        for (int i = 'A'; i <= 'Z'; i++) {
            if (cntS[i] > cntT[i]) {
                return false;
            }
        }
        return true;
    }

    // Optimization O(m+n)
    public static String minWindow2(String s, String t) {
        int[] cnt = new int[128];
        int m = s.length();
        int n = t.length();
        int less = 0;
        for (int i = 0; i < n; i++) {
            if (cnt[t.charAt(i)] == 0) less++;
            cnt[t.charAt(i)]++;
        }
        int ansLeft = -1;
        int ansRight = m;
        int l = 0;
        for (int r = 0; r < m; r++) {
            cnt[s.charAt(r)]--;
            if (cnt[s.charAt(r)] == 0) less--;
            while (less == 0) {
                if (r - l < ansRight - ansLeft) {
                    ansLeft = l;
                    ansRight = r;
                }
                if (cnt[s.charAt(l)] == 0) less++;
                cnt[s.charAt(l)]++;
                l++;
            }
        }
        return ansLeft < 0 ? "" : s.substring(ansLeft, ansRight + 1);
    }
}
