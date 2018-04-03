public class LeetCode0091 {
	public int numDecodings(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		int[] dp = new int[s.length() + 1];
		dp[0] = 1;

		int pre = s.charAt(0) - '0';

		if (pre == 0) {
			return 0;
		} else {
			dp[1] = dp[0];
		}

		for (int i = 1; i < s.length(); i++) {
			int current = s.charAt(i) - '0';
			int num = pre * 10 + current;

			if (num == 0 || current == 0 && pre > 2) {
				return 0;
			}
			if (num == 10 || num == 20) {
				dp[i + 1] = dp[i - 1];
			} else {
				dp[i + 1] = dp[i];
				if (num < 27 && num > 10) {
					dp[i + 1] += dp[i - 1];
				}
			}
			pre = current;
		}
		return dp[s.length()];
	}

	public static void main(String[] args) {
		LeetCode0091 leetcode = new LeetCode0091();
		System.out.println(leetcode.numDecodings("1212"));
	}
}