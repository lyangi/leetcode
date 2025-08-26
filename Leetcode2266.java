public class Leetcode2266 {
    private static boolean done = false;
    private static final int MOD = 1_000_000_007;
    private static final int MX = 100_001;
    private static final long[] f = new long[MX];
    private static final long[] g = new long[MX];

    private void init() {
        if (done) return;
        done = true;

        f[0] = g[0] = 1;
        f[1] = g[1] = 1;
        f[2] = g[2] = 2;
        f[3] = g[3] = 4;
        for (int i = 4; i < MX; i++) {
            f[i] = (f[i - 1] + f[i - 2] + f[i - 3]) % MOD;
            g[i] = (g[i - 1] + g[i - 2] + g[i - 3] + g[i - 4]) % MOD;
        }
    }
    public int countTexts(String pressedKeys) {
        init();
        int cnt = 0;
        long ans = 1;
        for (int i = 0; i < pressedKeys.length(); i++) {
            char c = pressedKeys.charAt(i);
            cnt++;
            if (i == pressedKeys.length() - 1 || c != pressedKeys.charAt(i + 1)) {
                if (c == '7' || c == '9') {
                    ans = (ans * g[cnt]) % MOD;
                } else {
                    ans = (ans * f[cnt]) % MOD;
                }
                cnt = 0;
            }
        }
        return (int) ans;
    }
}
