import java.util.Arrays;

public class LeetCode0322 {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount <= 0) {
            return 0;
        }

        long[] dp = new long[amount + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < coins.length; j++) {
                if ((long)i + coins[j] <= amount) {
                    dp[i + coins[j]] = Math.min(dp[i + coins[j]], dp[i] + 1);
                }
            }
        }

        return dp[amount] >= Integer.MAX_VALUE ? -1 : (int) dp[amount];
    }

    public static void main(String[] args) {
        LeetCode0322 leetcode = new LeetCode0322();
        int[] coins = new int[] { 2147483647 };
        System.out.println(leetcode.coinChange(coins, 2));
    }
}
