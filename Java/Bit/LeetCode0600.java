public class LeetCode0600 {

    public int findIntegers(int num)
    {

        int bitCount = 0;
        int[] numInBit = new int[32];

        for (int i = num; i > 0; i >>= 1) {
            numInBit[bitCount++] = (i & 1);
        }

        int[] dp = new int[bitCount + 1];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i <= bitCount; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        int result = 0;
        for (int i = bitCount - 1; i >= 0; i--) {
            if (numInBit[i] == 0) {
                continue;
            }
            result += dp[i];

            if (numInBit[i + 1] == 1) {
                return result;
            }
        }

        return result + 1;
    }

    public static void main(String[] args)
    {
        System.out.println(new LeetCode0600().findIntegers(5));
    }
}