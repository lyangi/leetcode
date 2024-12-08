public class Leetcode122 {
    public static int maxProfit(int[] prices) {
        int max = 0;
        int start = prices[0];
        int len = prices.length;
        for (int i = 1; i < len; i++) {
            if (start < prices[i]) {
                max += prices[i] - start;
            }
            start = prices[i];
        }
        return max;
    }
    public static void main(String[] args) {
        int[] prices = {7,1,1,3,6,9};
        System.out.println(maxProfit(prices));
    }
}
